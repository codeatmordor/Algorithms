package org.gks.problems.arrays;

// https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
public class MinJumpsToreachEnd {


  public static int minjumps(int[] input) {

    int[] jumps = new int[input.length];
    if (input[0] == 0)
      return Integer.MAX_VALUE;

    jumps[0] = 0;

    // Find the minimum number of jumps to reach arr[i]
    // from arr[0], and assign this value to jumps[i]
    for (int i = 1; i < input.length; i++) {
      jumps[i] = Integer.MAX_VALUE;

      for (int j = 0; j < i; j++) {
        if (i <= j + input[j] && jumps[j] != Integer.MAX_VALUE) {
          jumps[i] = Math.min(jumps[i], jumps[j] + 1);
          break;
        }
      }
    }
    return jumps[input.length - 1];

  }

  public static void main(String[] args) {

    int[] input = {1, 3, 6, 1, 0, 9};
    System.out.println(minjumps(input));

  }


}

