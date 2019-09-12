
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.string;

//https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/

public class WordIn2Dgrid {

    static int R, C;
    static int[] X = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] Y = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

    static void patternSearch(char[][] gd, String word) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (search(gd, i, j, word))
                    System.out.println("pattern found at " + i + ", " + j);
            }
        }
    }

    static boolean search(char[][] gd, int row, int col, String wd) {
        int len = wd.length();

        int dir = 0;
        if (gd[row][col] != wd.charAt(0))
            return false;

        for (dir = 0; dir < 8; dir++) {
            int rowd = row + X[dir];
            int cold = row + Y[dir];
            int k = 1;
            for (k = 1; k < len; k++) {
                if (rowd < 0 || rowd >= R || cold < 0 || cold >= C)
                    break;
                if (gd[rowd][cold] != wd.charAt(k))
                    break;
                rowd += X[dir];
                cold += Y[dir];
            }

            if (k == len)
                return true;
        }
        return false;

    }

    public static void main(String[] args) {
        R = 3;
        C = 13;
        char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' }, { 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' }, { 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
        patternSearch(grid, "GEEKS");
        System.out.println();
        patternSearch(grid, "EEE");
    }
}
