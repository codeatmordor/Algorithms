

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.dp;

class Calls {
  public long count;

  Calls() {
    count = 0;
  }
}


public class CoinChange {
  public static int minCoinRecur(int[] coins, int val, Calls calls) {
    // System.out.println(val);
    if (val == 0)
      return 0;
    int min = val;

    for (int c : coins) {
      if (val - c >= 0) {
        calls.count++;
        int i = minCoinRecur(coins, val - c, calls);
        if (min > i + 1)
          min = i + 1;
      }
    }
    return min;
  }

  public static int minCoinDP(int[] coins, int val, Calls calls) {
    int[] cache = new int[val + 1];
    for (int i = 1; i <= val; i++) {
      cache[i] = -1;
    }

    return minCoin(coins, val, cache, calls);
  }


  private static int minCoin(int[] coins, int val, int[] cache, Calls calls) {
    // System.out.println(val);
    if (val == 0)
      return 0;
    int min = val;

    for (int c : coins) {
      if (val - c >= 0) {
        int i;
        if (cache[val - c] >= 0) {
          i = cache[val - c];
        } else {
          calls.count++;
          i = minCoin(coins, val - c, cache, calls);
          // Update Cache
          cache[val - c] = i;
        }
        if (min > i + 1)
          min = i + 1;
      }
    }
    return min;
  }



  public static void main(String[] args) {
    int[] coins = new int[] {10, 20, 25, 50};
    int val = 400;
    Calls calls1 = new Calls();
    System.out.println(minCoinRecur(coins, val, calls1));
    System.out.println(calls1.count);// 412,953,506,808 Calls for 400
    calls1.count = 0;
    System.out.println(minCoinDP(coins, val, calls1));
    System.out.println(calls1.count);// 77 Calls for 400

  }
}

