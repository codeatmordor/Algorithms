
// PACKAGE/IMPORTS --------------------------------------------------
package org.gk.problems.dp;

public class PalindromPartition {

    static int minPal(String s) {
        int n = s.length();

        int[][] C = new int[n][n];
        boolean[][] P = new boolean[n][n];

        int i, j, k, L;

        for (i = 0; i < n; i++) {
            C[i][i] = 0;
            P[i][i] = true;
        }

        for (L = 2; L <= n; L++) {
            for (i = 0; i < n - L + 1; i++) {
                j = i + L - 1;

                if (L == 2) {
                    P[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    P[i][j] = (s.charAt(i) == s.charAt(j)) && P[i + 1][j - 1];
                }

                if (P[i][j] == true) {
                    C[i][j] = 0;
                } else {
                    C[i][j] = Integer.MAX_VALUE;
                    for (k = i; k <= j - 1; k++) {
                        C[i][j] = Integer.min(C[i][j], C[i][k] + C[k + 1][j] + 1);
                    }
                }

            }
        }

        return C[0][n - 1];
    }

    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println("Min cuts needed for " + "Palindrome Partitioning" + " is " + minPal(str));
    }
}
