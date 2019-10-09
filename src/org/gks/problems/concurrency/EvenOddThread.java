
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.concurrency;

class Printer {
    private volatile boolean isOdd;

    synchronized void printEven(int num) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + ":" + num);
        isOdd = false;
        notify();
    }

    synchronized void printOdd(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = true;
        notify();
    }
}

class TaskEvenOdd implements Runnable {

    private int max;
    private Printer printer;
    private boolean isEven;

    /**
     * @param max
     * @param printer
     * @param isEven
     */
    public TaskEvenOdd(int max, Printer printer, boolean isEven) {
        super();
        this.max = max;
        this.printer = printer;
        this.isEven = isEven;
    }

    @Override
    public void run() {
        int number = isEven ? 2 : 1;
        while (number <= max) {
            if (isEven) {
                printer.printEven(number);
            } else {
                printer.printOdd(number);
            }
            number += 2;
        }

    }

}

public class EvenOddThread {
    public static void main(String[] args) {
        Printer p = new Printer();
        Thread even = new Thread(new TaskEvenOdd(100, p, true), "Even");
        Thread odd = new Thread(new TaskEvenOdd(100, p, false), "Odd");
        even.start();
        odd.start();

    }
}
