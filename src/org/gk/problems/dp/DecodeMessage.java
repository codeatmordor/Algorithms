
// PACKAGE/IMPORTS --------------------------------------------------
package org.gk.problems.dp;

import java.util.Arrays;

public class DecodeMessage {

    static int num_ways(String str) {
        return helper(str, str.length());
    }

    static int helper(String str, int k) {
        if (k == 0)
            return 1;
        if (str.charAt(0) == '0')
            return 0;

        int res = helper(str, k - 1);
        if (k >= 2 && (Integer.parseInt(str.substring(0, 2)) <= 26)) {
            res += helper(str, k - 2);
        }
        return res;

    }

    static int num_waysDP(String str) {
        int[] cache = new int[str.length() + 1];
        Arrays.fill(cache, -1);
        return helperDP(str, str.length(), cache);
    }

    static int helperDP(String str, int k, int[] cache) {
        if (k == 0)
            return 1;
        if (str.charAt(0) == '0')
            return 0;
        if (cache[k] != -1)
            return cache[k];

        int res = helperDP(str, k - 1, cache);
        if (k >= 2 && (Integer.parseInt(str.substring(0, 2)) <= 26)) {
            res += helperDP(str, k - 2, cache);
        }
        cache[k] = res;
        return res;

    }

    public static void main(String[] args) {
        String input = "12345";
        System.out.println(num_waysDP(input));
    }

}
