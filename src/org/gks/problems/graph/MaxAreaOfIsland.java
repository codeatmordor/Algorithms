package org.gks.problems.graph;

// Java program to find the length of the largest 
//region in boolean 2D-matrix 
import java.io.*;
import java.util.*;

/*
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 */

public class MaxAreaOfIsland {
	static int ROW, COL, count;

	// A function to check if a given cell (row, col)
	// can be included in DFS
	static boolean isSafe(int[][] M, int row, int col, boolean[][] visited) {
		// row number is in range, column number is in
		// range and value is 1 and not yet visited
		return ((row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]));
	}

	// A utility function to do DFS for a 2D boolean
	// matrix. It only considers the 8 neighbours as
	// adjacent vertices
	static void DFS(int[][] M, int row, int col, boolean[][] visited) {
		// These arrays are used to get row and column
		// numbers of 8 neighbours of a given cell
		int[] rowNbr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] colNbr = { -1, 0, 1, -1, 1, -1, 0, 1 };

		// Mark this cell as visited
		visited[row][col] = true;

		// Recur for all connected neighbours
		for (int k = 0; k < 8; k++) {
			if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
				// increment region length by one
				count++;
				DFS(M, row + rowNbr[k], col + colNbr[k], visited);
			}
		}
	}

	// The main function that returns largest length region
	// of a given boolean 2D matrix
	static int largestRegion(int[][] M) {
		// Make a boolean array to mark visited cells.
		// Initially all cells are unvisited
		boolean[][] visited = new boolean[ROW][COL];

		// Initialize result as 0 and traverse through the
		// all cells of given matrix
		int result = 0;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {

				// If a cell with value 1 is not
				if (M[i][j] == 1 && !visited[i][j]) {

					// visited yet, then new region found
					count = 1;
					DFS(M, i, j, visited);

					// maximum region
					result = Math.max(result, count);
				}
			}
		}
		return result;
	}

//Driver code 
	public static void main(String args[]) {
		int M[][] = { { 0, 0, 1, 1, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1 } };
		ROW = 4;
		COL = 5;
		System.out.println(largestRegion(M));
	}
}

//This code is contributed by rachana soma 
