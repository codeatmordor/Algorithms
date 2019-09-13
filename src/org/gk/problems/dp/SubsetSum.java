
// PACKAGE/IMPORTS --------------------------------------------------
package org.gk.problems.dp;

public class SubsetSum {

    static boolean isSubsetSum(int[] set, int n, int sum) {
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum);

        return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);

    }

    static boolean isSubsetSumDP(int[] set, int n, int sum) {
        boolean[][] subset = new boolean[sum + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            subset[0][i] = true;
        }

        for (int i = 1; i <= sum; i++) {
            subset[i][0] = false;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
            }
        }

        for (int i = 0; i <= sum; i++) {
            for (int j = 0; j <= n; j++)
                System.out.print(subset[i][j] + " ");
            System.out.println();
        }

        return subset[sum][n];

    }

    public static void main(String[] args) {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = set.length;
        if (isSubsetSumDP(set, n, sum) == true)
            System.out.println("Found a subset" + " with given sum");
        else
            System.out.println("No subset with" + " given sum");
    }

}
