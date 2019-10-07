

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.tree;
/*
 * Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an algorithm to
 * determine if T2 is a subtree of Tl.
 */

public class CheckSubtree {

  static boolean containsTree(Node t1, Node t2) {
    StringBuilder s1 = new StringBuilder();
    StringBuilder s2 = new StringBuilder();
    getOrderString(t1, s1);
    getOrderString(t2, s2);

    return s1.indexOf(s2.toString()) != -1;

  }

  static void getOrderString(Node n, StringBuilder sb) {
    if (n == null) {
      sb.append('X');
      return;
    }
    // Pre-order traversal
    sb.append(n.data + " ");
    getOrderString(n.left, sb);
    getOrderString(n.right, sb);
  }

}

