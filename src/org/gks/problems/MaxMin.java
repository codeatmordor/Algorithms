
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems;

public class MaxMin {

    public static void main(String[] args) {
        int[] a = new int[] { 1, 4, 5, 8, 9, 10, 0, 7, 6, 5 };

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

    }
}
