

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.tree;
/*
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm to
 * create a binary search tree with minimal height.
 */

public class MinimalBST {
  static Node root;

  public static void createMinimalBST(int[] input) {
    root = createMinimalBST(input, 0, input.length - 1);
  }

  private static Node createMinimalBST(int[] input, int start, int end) {
    if (end < start) {
      return null;
    }
    int mid = start + (end - start) / 2;
    Node n = new Node(input[mid]);
    n.left = createMinimalBST(input, start, mid - 1);
    n.right = createMinimalBST(input, mid + 1, end);
    return n;
  }

  public static void display(Node n) {
    if (n == null)
      return;
    System.out.println(n.data);
    display(n.left);
    display(n.right);
  }

  public static void main(String[] args) {
    int[] input = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    createMinimalBST(input);
    display(root);
  }

}

