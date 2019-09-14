
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.most_asked.problems;

public class MatrixSpriral {

    static void spiralPrint(int m, int n, int[][] a) {
        int i = 0;
        int k = 0, l = 0;
        while (k < m && l < n) {
            for (i = l; i < n; i++) {
                System.out.print(a[k][i] + " ");
            }
            k++;

            for (i = k; i < m; i++) {
                System.out.print(a[i][n - 1] + " ");
            }
            n--;
            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(a[m - 1][i] + " ");
                }
                m--;
            }

            // Print the first column from the remaining columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(a[i][l] + " ");
                }
                l++;
            }

        }
    }

    public static void main(String[] args) {
        int[][] m = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        MatrixSpriral.spiralPrint(3, 3, m);
    }

}
