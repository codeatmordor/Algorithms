
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.sort;

public class QuickSort {

    public static void qSort(int[] a) {
        qSort(a, 0, a.length - 1);
    }

    public static void qSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }

        int pivot = a[(l + r) / 2];
        int index = partition(a, l, r, pivot);
        qSort(a, l, index - 1);
        qSort(a, index, r);

    }

    public static int partition(int[] a, int l, int r, int pivot) {
        while (l <= r) {
            while (a[l] < pivot) {
                l++;
            }
            while (a[r] > pivot) {
                r--;
            }

            if (l <= r) {
                swap(a, l, r);
                l++;
                r--;
            }
        }
        return l;
    }

    /**
     * @param a
     * @param l
     * @param r
     */
    private static void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, 4, 5, -8, 9, 10, 0, 7, 6, 5 };
        QuickSort.qSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

}
