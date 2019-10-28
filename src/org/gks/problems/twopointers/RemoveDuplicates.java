package org.gks.problems.twopointers;

public class RemoveDuplicates {

  public static void main(final String[] args) {
    int[] arr = new int[] {2, 3, 3, 3, 6, 9, 9};
    System.out.println(RemoveDuplicates.remove(arr));

    arr = new int[] {2, 2, 2, 11};
    System.out.println(RemoveDuplicates.remove(arr));
  }

  public static int remove(final int[] arr) {

    int j = 1;
    int nextnondup = 1;

    for (j = 1; j < arr.length; j++) {
      if (arr[nextnondup - 1] != arr[j]) {
        arr[nextnondup] = arr[j];
        nextnondup++;
      }
    }
    return nextnondup;
  }

}
