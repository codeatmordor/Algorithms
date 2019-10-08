package org.gks.problems.arrays;


public class MatrixSearch {
  public static boolean contains(int[][] arr, int x) {
    if (arr.length == 0 || arr[0].length == 0)
      return false;
    int row = 0;
    int col = arr.length - 1;

    while (row < arr[0].length && col >= 0) {
      if (arr[row][col] == x)
        return true;
      if (arr[row][col] < x)
        row++;
      else
        col--;
    }

    return false;
  }

  public static void main(String[] args) {
    int[][] mat = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    System.out.println(contains(mat, 7));
  }

}

