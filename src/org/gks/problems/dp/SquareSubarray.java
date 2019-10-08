package org.gks.problems.dp;


public class SquareSubarray {

  public static int squareSubarrayDimentionDP(int[][] input) {
    int max = 0;
    int[][] cache = new int[input.length][input[0].length];

    for (int i = 0; i < cache.length; i++) {
      for (int j = 0; j < cache[0].length; j++) {
        if (i == 0 || j == 0) {
          cache[i][j] = input[i][j];
        } else if (input[i][j] != 0) {
          cache[i][j] =
              Math.min(Math.min(cache[i][j - 1], cache[i - 1][j]), cache[i - 1][j - 1]) + 1;
        }
        if (cache[i][j] > max)
          max = cache[i][j];
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[][] mat = new int[][] {{1, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 0, 0}};
    System.out.println(squareSubarrayDimentionDP(mat));
  }

}

