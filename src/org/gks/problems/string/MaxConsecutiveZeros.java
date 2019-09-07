
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.string;

public class MaxConsecutiveZeros {

    static int getMaxLength(boolean[] arr, int n) {

        int count = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {

            if (arr[i] == true)
                count = 0;

            else {
                count++;
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        boolean arr[] = { true, true, false, false, true, false, true, false, true, true, true, true };

        int n = arr.length;

        System.out.println(getMaxLength(arr, n));
    }

}
