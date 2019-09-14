
// PACKAGE/IMPORTS --------------------------------------------------
package org.gk.problems.dp;

public class AllSubsetsOfASet {

    static void allSubsets(Integer[] a) {
        Integer[] subset = new Integer[a.length];
        subset(a, subset, 0);
    }

    static void subset(Integer[] a, Integer[] subset, int currentIndex) {
        if (currentIndex == a.length)
            display(subset);
        else {
            subset[currentIndex] = null;
            subset(a, subset, currentIndex + 1);
            subset[currentIndex] = a[currentIndex];
            subset(a, subset, currentIndex + 1);
        }
    }

    static void display(Integer[] a) {
        System.out.print("[");
        for (Integer i : a) {
            if (i != null) {
                System.out.print(i + ",");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        allSubsets(arr);
    }

}
