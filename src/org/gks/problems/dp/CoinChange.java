

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.dp;


public class CoinChange {
  public static int minCoinRecur(int[] coins, int val) {
    // System.out.println(val);
    if (val == 0)
      return 0;
    int min = val;

    for (int c : coins) {
      if (val - c >= 0) {
        int i = minCoinRecur(coins, val - c);
        if (min > i + 1)
          min = i + 1;
      }
    }
    return min;
  }

  public static int minCoinDP(int[] coins, int val) {
    int[] cache = new int[val];
    for (int i = 1; i < val; i++) {
      cache[i] = -1;
    }
    return minCoin(coins, val, cache);
  }

  private static int minCoin(int[] coins, int val, int[] cache) {
    // System.out.println(val);
    if (val == 0)
      return 0;
    int min = val;

    for (int c : coins) {
      if (val - c >= 0) {
        int i;
        if (cache[val - c] >= 0)
          i = cache[val - c];
        else {
          i = minCoin(coins, val - c, cache);
        }
        if (min > i + 1)
          min = i + 1;
      }
    }
    return min;
  }



  public static void main(String[] args) {
    int[] coins = new int[] {10, 20, 25, 50};

    System.out.println(minCoinRecur(coins, 120));
    System.out.println(minCoinDP(coins, 120));
  }
}

