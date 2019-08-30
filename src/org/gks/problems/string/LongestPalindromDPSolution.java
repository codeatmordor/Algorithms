
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.string;

public class LongestPalindromDPSolution {

    static int longpal(String str) {
        int n = str.length();

        int[][] cache = new int[n][n];

        for (int i = 0; i < n; i++) {
            cache[i][i] = 1;
        }

        int j = 0;
        for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n - cl + 1; i++) {
                j = i + cl - 1;
                System.out.println("i:" + i + " j:" + j);
                if (str.charAt(i) == str.charAt(j) && cl == 2) {
                    cache[i][j] = 2;
                } else if (str.charAt(i) == str.charAt(j)) {
                    cache[i][j] = cache[i + 1][j - 1] + 2;
                } else {
                    cache[i][j] = Math.max(cache[i][j - 1], cache[i + 1][j]);
                }
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(cache[i][j] + " ");
            }
            System.out.println();
        }
        return cache[0][n - 1];

    }

    public static void main(String[] args) {
        LongestPalindromDPSolution.longpal("abaaaaab");
    }

}
