package org.gks.problems.arrays;

import java.util.Arrays;

public class MatrixProduct {

    public static int matprodAllPositive(int[][] mat, int n, int m) {
        int[][] cache = new int[n][m];
        for (int[] i : cache) {
            Arrays.fill(i, 0);
        }
        cache[0][0] = mat[0][0];
        for (int j = 1; j < m; j++) {
            cache[0][j] = cache[0][j - 1] * mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            cache[i][0] = cache[i - 1][0] * mat[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]) * mat[i][j];
            }
        }
        return cache[n - 1][m - 1];
    }

    private static int matrixProduct(int[][] matrix) {
        int result = 0;
        if (matrix.length != 0
            && matrix[0].length != 0) {// Create cache of min and max product to a given cell
            int[][] maxCache = new int[matrix.length][matrix[0].length];
            int[][] minCache = new int[matrix.length][matrix[0].length];// Fill caches. We start at the top left and iteratively find the
// greatest
// at smallest path to each subsequent cell by considering the greatest
// and
// smallest path to the cells above and to the left of the current cell
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    int maxVal = Integer.MIN_VALUE;
                    int minVal = Integer.MAX_VALUE;

                    // If you're in the top left corner, just copy to cache
                    if (i == 0 && j == 0) {
                        maxVal = matrix[i][j];
                        minVal = matrix[i][j];
                    }

                    // If we're not at the top, consider the value above
                    if (i > 0) {
                        int tempMax = Math.max(matrix[i][j] * maxCache[i - 1][j],
                            matrix[i][j] * minCache[i - 1][j]);
                        maxVal = Math.max(tempMax, maxVal);
                        int tempMin = Math.min(matrix[i][j] * maxCache[i - 1][j],
                            matrix[i][j] * minCache[i - 1][j]);
                        minVal = Math.min(tempMin, minVal);
                    }
                    // If we're not on the left, consider the value to the left
                    if (j > 0) {
                        int tempMax = Math.max(matrix[i][j] * maxCache[i][j - 1],
                            matrix[i][j] * minCache[i][j - 1]);
                        maxVal = Math.max(tempMax, maxVal);
                        int tempMin = Math.min(matrix[i][j] * maxCache[i][j - 1],
                            matrix[i][j] * minCache[i][j - 1]);
                        minVal = Math.min(tempMin, minVal);
                    }
                    maxCache[i][j] = maxVal;
                    minCache[i][j] = minVal;
                }
            }// Return the max value at the bottom right
            result = maxCache[maxCache.length - 1][maxCache[0].length - 1];
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] mat = new int[3][3];
        mat[0] = new int[] { -1, 2, 3 };
        mat[1] = new int[] { 4, 5, -6 };
        mat[2] = new int[] { 7, 8, 9 };
        System.out.println(matrixProduct(mat));

    }
}
