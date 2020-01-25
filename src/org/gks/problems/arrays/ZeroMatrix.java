
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.arrays;

import java.util.Arrays;

// how to update a boolean matrix so that if any cell is true, all the cells in that row and column
// are true.
public class ZeroMatrix {

	public static void modifyMatrix(int mat[][], int R, int C) {
		int row[] = new int[R];
		int col[] = new int[C];
		int i, j;

		/* Initialize all values of row[] as 0 */
		for (i = 0; i < R; i++) {
			row[i] = 0;
		}

		/* Initialize all values of col[] as 0 */
		for (i = 0; i < C; i++) {
			col[i] = 0;
		}

		/*
		 * Store the rows and columns to be marked as 1 in row[] and col[] arrays
		 * respectively
		 */
		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++) {
				if (mat[i][j] == 1) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}

		/*
		 * Modify the input matrix mat[] using the above constructed row[] and col[]
		 * arrays
		 */
		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++) {
				if (row[i] == 1 || col[j] == 1) {
					mat[i][j] = 1;
				}
			}
		}
	}

	public static void zeroMat(boolean[][] matrix) {
		// Verify the input array is nonzero
		if (matrix.length == 0 || matrix[0].length == 0)
			return;

		// Determine whether the first row or first column is true
		boolean rowZero = false, colZero;
		for (boolean i : matrix[0]) {
			rowZero |= i;
		}
		colZero = Arrays.stream(matrix).map(i -> i[0]).reduce(false, (a, b) -> a || b);

		// For each cell not in the first row/column, if it is true, set the
		// cell in the first row/same column and first column/same row to be
		// true
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j]) {
					matrix[i][0] = true;
					matrix[0][j] = true;
				}
			}
		}

		// Go through the first column and set each row to true where cell in
		// the first column is true
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0]) {
				for (int j = 1; j < matrix[i].length; j++) {
					matrix[i][j] = true;
				}
			}
		}

		// Repeat for the rows
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j]) {
				for (int i = 1; i < matrix.length; i++) {
					matrix[i][j] = true;
				}
			}
		}

		// Set first row/column to true if necessary
		if (rowZero) {
			Arrays.fill(matrix[0], true);
		}

		if (colZero) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = true;
			}
		}
	}

	public static void main(String[] args) {
		boolean[][] mat = new boolean[][] { { true, false, false }, { false, false, false }, { false, false, false } };
	}
}
