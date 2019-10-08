

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.arrays;
/*
 * Merge two sorted arrays without extra space, assuming one array has enough space to accommodate
 * second array
 */

public class MergeArrays {

  public static void mergeArrays(int[] a, int[] b, int aActualValuesLength, int bLength) {
    if (aActualValuesLength + bLength > a.length)
      throw new IllegalArgumentException();

    int aIndex = aActualValuesLength - 1;
    int bIndex = bLength - 1;
    int mergeIndex = aActualValuesLength + bLength - 1;

    while (aIndex >= 0 && bIndex >= 0) {
      if (a[aIndex] > b[bIndex]) {
        a[mergeIndex] = a[aIndex];
        aIndex--;
      } else {
        a[mergeIndex] = b[bIndex];
        bIndex--;
      }

      mergeIndex--;
    }

    while (bIndex >= 0) {
      a[mergeIndex] = b[bIndex];
      bIndex--;
      mergeIndex--;
    }
  }

  public static void main(String[] args) {
    int[] A = new int[] {1, 2, 3, 0, 0};
    int[] B = new int[] {4, 5};
    mergeArrays(A, B, 3, 2);
    for (int i : A) {
      System.out.println(i);
    }

  }
}

