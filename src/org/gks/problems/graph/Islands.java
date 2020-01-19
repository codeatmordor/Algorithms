package org.gks.problems.graph;


// https://www.geeksforgeeks.org/find-number-of-islands/
public class Islands {

	static final int R = 5, C = 5;

	boolean isSafe(int M[][], int r, int c, boolean visited[][]) {

		return (r >= 0) && (r < R) && (c >= 0) && (c < C) && (M[r][c] == 1 && !visited[r][c]);
	}

	// A utility function to do DFS for a 2D boolean matrix.
	// It only considers the 8 neighbors as adjacent vertices
	void DFS(int[][] M, int r, int c, boolean visited[][]) {

		// These arrays are used to get row and column numbers
		// of 8 neighbors of a given cell
		int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

		visited[r][c] = true;

		for (int k = 0; k < 8; ++k) {

			if (isSafe(M, r + rowNbr[k], c + colNbr[k], visited)) {
				DFS(M, r + rowNbr[k], c + colNbr[k], visited);
			}
		}

	}

	int countIslands(int M[][]) {
		// Make a bool array to mark visited cells.
		// Initially all cells are unvisited
		boolean visited[][] = new boolean[R][C];

		// Initialize count as 0 and traverse through the all cells
		// of given matrix
		int count = 0;
		for (int i = 0; i < R; ++i)
			for (int j = 0; j < C; ++j)
				if (M[i][j] == 1 && !visited[i][j]) // If a cell with
				{ // value 1 is not
					// visited yet, then new island found, Visit all
					// cells in this island and increment island count
					DFS(M, i, j, visited);
					++count;
				}

		return count;
	}

	// Driver method
	public static void main(String[] args) throws java.lang.Exception {
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		Islands I = new Islands();
		System.out.println("Number of islands is: " + I.countIslands(M));
	}

}
