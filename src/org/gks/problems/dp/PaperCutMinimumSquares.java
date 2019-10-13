package org.gks.problems.dp;

/*
 * Input : 36 x 30 Output : 5 Explanation : 3 (squares of size 12x12) + 2 (squares of size 18x18)
 * 
 * Input : 4 x 5 Output : 5 Explanation : 1 (squares of size 4x4) + 4 (squares of size 1x1)
 */
public class PaperCutMinimumSquares {

  static int dp[][] = new int[300][300];

  // Returns min number of squares needed
  static int minimumSquare(int m, int n) {
    // Initializing max values to
    // vertical_min and horizontal_min
    int vertical_min = Integer.MAX_VALUE;
    int horizontal_min = Integer.MAX_VALUE;

    // If the given rectangle is
    // already a square
    if (m == n)
      return 1;

    // If the answer for the given
    // rectangle is previously
    // calculated return that answer
    if (dp[m][n] != 0)
      return dp[m][n];

    /*
     * The rectangle is cut horizontally and vertically into two parts and the cut with minimum
     * value is found for every recursive call.
     */

    for (int i = 1; i <= m / 2; i++) {
      // Calculating the minimum answer
      // for the rectangles with width
      // equal to n and length less than
      // m for finding the cut point for
      // the minimum answer
      horizontal_min = Math.min(minimumSquare(i, n) + minimumSquare(m - i, n), horizontal_min);
    }

    for (int j = 1; j <= n / 2; j++) {
      // Calculating the minimum answer
      // for the rectangles with width
      // less than n and length equal to
      // m for finding the cut point for
      // the minimum answer
      vertical_min = Math.min(minimumSquare(m, j) + minimumSquare(m, n - j), vertical_min);
    }

    // Minimum of the vertical cut or
    // horizontal cut to form a square
    // is the answer
    dp[m][n] = Math.min(vertical_min, horizontal_min);

    return dp[m][n];
  }

  // Driver code
  public static void main(String[] args) {
    int m = 30, n = 35;
    System.out.println(minimumSquare(m, n));
  }
}


