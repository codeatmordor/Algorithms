
// PACKAGE/IMPORTS --------------------------------------------------
package org.gk.problems.greedy;

public class FittingShelves {

    public static void minSpacePreLarge(int w, int large, int small) {
        int min_large = 0;
        int min_small = 0;
        int min_empty = w;
        int p;
        int q = 0;
        int rem;

        while (w >= large) {
            p = w / large;
            rem = w % large;

            if (rem <= min_empty) {
                min_large = p;
                min_small = q;
                min_empty = rem;
            }

            q += 1;
            w = w - large;
        }

        System.out.println("Large : " + min_large + " Small : " + min_small + " Empty : " + min_empty);
    }

    public static void main(String[] args) {
        FittingShelves.minSpacePreLarge(24, 5, 3);
        FittingShelves.minSpacePreLarge(24, 7, 4);

    }
}
