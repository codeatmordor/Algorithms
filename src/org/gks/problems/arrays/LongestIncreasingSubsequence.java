package org.gks.problems.arrays;


public class LongestIncreasingSubsequence {

  /*
   * lis() returns the length of the longest increasing subsequence in arr[] of size n
   */
  private static int lis(int[] a, int n) {
    int[] lis = new int[n];


    for (int i = 0; i < n; i++) {
      lis[i] = 1;
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (a[i] > a[j] && lis[i] < lis[j] + 1) {
          lis[i] = lis[j] + 1;
        }
      }
    }


    int max = 0;

    for (int i = 0; i < n; i++) {
      if (lis[i] > max)
        max = lis[i];
    }

    return max;


  }

  public static void main(String[] args) {
    int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
    int n = arr.length;
    System.out.println("Length of lis is " + lis(arr, n) + "\n");
  }
}

