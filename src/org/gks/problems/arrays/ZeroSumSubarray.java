

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class ZeroSumSubarray {

  public static int[] zeroSum(int[] input) {
    HashMap<Integer, Integer> sumMp = new HashMap<>();
    int sum = 0;

    for (int i = 0; i <= input.length; i++) {
      Integer oldIndex = sumMp.get(sum);
      if (oldIndex == null && i == input.length) {
        return null;
      } else if (oldIndex == null) {
        sumMp.put(sum, i);
        sum += input[i];
      } else {
        return Arrays.copyOfRange(input, oldIndex, i);
      }
    }
    return null;
  }

  public static void main(String[] args) {
    int[] input = new int[] {1, 2, -5, 1, 2, -1};
    if (zeroSum(input) != null) {
      int[] a = zeroSum(input);
      for (int i : a) {
        System.out.println(i);
      }
    }
  }

}

