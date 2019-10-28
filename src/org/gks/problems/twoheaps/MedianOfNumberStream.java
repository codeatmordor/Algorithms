
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.twoheaps;

import java.util.PriorityQueue;

public class MedianOfNumberStream {

    static PriorityQueue<Integer> maxH = new PriorityQueue<>((a, b) -> b - a);
    static PriorityQueue<Integer> minH = new PriorityQueue<>((a, b) -> a - b);

    static void insertNum(int n) {
        if (maxH.isEmpty() || n <= maxH.peek()) {
            maxH.add(n);
        } else {
            minH.add(n);
        }

        // either both the heaps will have equal number of elements or max-heap
        // will have one
        // more element than the min-heap
        if (maxH.size() > minH.size() + 1) {
            minH.add(maxH.poll());
        } else if (maxH.size() < minH.size()) {
            maxH.add(minH.poll());
        }
    }

    static double findMedian() {
        if (maxH.size() == minH.size()) {
            return maxH.peek() / 2.0 + minH.peek() / 2.0;
        } else {
            return maxH.peek();
        }
    }

    public static void main(String[] args) {
        MedianOfNumberStream medianOfAStream = new MedianOfNumberStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }

}
