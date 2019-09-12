
// PACKAGE/IMPORTS --------------------------------------------------
package org.gk.most_asked.problems;

public class MaxProductOfThreeNumbers {

    public static int maxProd(int[] a) {
        int res = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = a[i];
            } else if (a[i] > max2) {
                max3 = max2;
                max2 = a[i];
            } else if (a[i] > max3) {
                max3 = a[i];
            }
        }
        System.out.println(max1 + " " + max2 + " " + max3);
        return max1 * max2 * max3;

        /*
         * for (int i = 0; i < a.length; i++) { int j = i + 1; int k = a.length
         * - 1; while (j <= k) { int p = a[i] * a[j] * a[k]; if (p > res) { res
         * = p; } } }
         */

    }

    public static void main(String[] args) {
        int a[] = new int[] { 2, 5, 1, -8, 0, 90, 7, 1, 3 };
        System.out.println(MaxProductOfThreeNumbers.maxProd(a));
    }
}
