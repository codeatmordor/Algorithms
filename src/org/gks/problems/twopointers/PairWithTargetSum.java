
package org.gks.problems.twopointers;


public class PairWithTargetSum {

  public static int[] search(final int[] arr, final int targetSum) {
    int left = 0;
    int end = arr.length - 1;
    while (left < end) {
      final int targetDiff = targetSum - arr[left];
      if (targetDiff == arr[end])
        return new int[] {left, end};
      if (targetDiff > arr[end])
        left++;
      else
        end--;
    }

    return new int[] {-1, -1};
  }

  public static void main(final String[] args) {
    int[] result = PairWithTargetSum.search(new int[] {1, 2, 3, 4, 6}, 6);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    result = PairWithTargetSum.search(new int[] {2, 5, 9, 11}, 11);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

  }

}
