
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {

  static Node root;

  public BinarySearchTree() {
    root = null;
  }

  void insert(int k) {
    root = insertRec(root, k);
  }

  int getHeight(Node root) {
    if (root == null)
      return -1;
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }

  boolean isBalanced(Node root) {
    if (root == null)
      return true;

    int heightDiff = getHeight(root.left) - getHeight(root.right);
    if (Math.abs(heightDiff) > 1)
      return false;
    else {
      return isBalanced(root.left) && isBalanced(root.right);
    }
  }

  Node insertRec(Node root, int k) {
    if (root == null) {
      root = new Node(k);
      return root;
    }

    if (k < root.data) {
      if (root.left != null)
        System.out.println("Left : " + root.left.data);
      root.left = insertRec(root.left, k);
    } else if (k > root.data) {
      if (root.right != null)
        System.out.println("Right : " + root.right.data);
      root.right = insertRec(root.right, k);
    }

    return root;
  }

  void deleteKey(int key) {
    root = deleteRec(root, key);
  }

  Node deleteRec(Node root, int k) {
    if (root == null)
      return null;

    if (k < root.data)
      root.left = deleteRec(root.left, k);
    else if (k > root.data)
      root.right = deleteRec(root.right, k);
    else {
      if (root.left == null)
        return root.right;
      else if (root.right == null)
        return root.left;

      // node with two children: Get the inorder successor (smallest
      // in the right subtree)
      root.data = minValue(root.right);

      // Delete the inorder successor
      root.right = deleteRec(root.right, root.data);
    }
    return root;
  }

  int minValue(Node root) {
    int minv = root.data;
    while (root.left != null) {
      minv = root.left.data;
      root = root.left;
    }
    return minv;
  }

  void inorder() {
    inorderRec(root);
  }

  // A utility function to do inorder traversal of BST
  void inorderRec(Node root) {
    if (root != null) {
      inorderRec(root.left);
      System.out.println(root.data);
      inorderRec(root.right);
    }
  }

  static Node lca(Node node, int n1, int n2) {
    if (node == null)
      return null;

    // If both n1 and n2 are smaller than root, then LCA lies in left
    if (node.data > n1 && node.data > n2)
      return lca(node.left, n1, n2);

    // If both n1 and n2 are greater than root, then LCA lies in right
    if (node.data < n1 && node.data < n2)
      return lca(node.right, n1, n2);

    return node;
  }

  public static List<LinkedList<Integer>> allSequences(Node node) {
    List<LinkedList<Integer>> result = new ArrayList<>();
    if (node == null) {
      result.add(new LinkedList<>());
      return result;
    }

    LinkedList<Integer> prefix = new LinkedList<>();
    prefix.add(node.data);

    /* Recurse on left and right subtrees. */
    List<LinkedList<Integer>> leftSeq = allSequences(node.left);
    System.out.println("For Left Node - " + node.left);
    leftSeq.stream().forEach(l -> System.out.println(l));
    List<LinkedList<Integer>> rightSeq = allSequences(node.right);
    System.out.println("For right Node - " + node.right);
    rightSeq.stream().forEach(l -> System.out.println(l));

    /* Weave together each list from the left and right sides. */
    for (LinkedList<Integer> left : leftSeq) {
      for (LinkedList<Integer> right : rightSeq) {
        ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
        weaveLists(left, right, weaved, prefix);
        result.addAll(weaved);
      }
    }
    return result;
  }

  private static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
      List<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
    /* One list is empty. Add remainder to [a cloned] prefix and store result. */
    if (first.size() == 0 || second.size() == 0) {
      LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
      result.addAll(first);
      result.addAll(second);
      results.add(result);
      return;
    }

    /*
     * Recurse with head of first added to the prefix. Removing the head will damage first, so we'll
     * need to put it back where we found it afterwards.
     */
    int headFirst = first.removeFirst();
    prefix.addLast(headFirst);
    weaveLists(first, second, results, prefix);
    prefix.removeLast();
    first.addFirst(headFirst);

    /* Do the same thing with second, damaging and then restoring the list. */
    int headSecond = second.removeFirst();
    prefix.addLast(headSecond);
    weaveLists(first, second, results, prefix);
    prefix.removeLast();
    second.addFirst(headSecond);
  }

  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();

    /*
     * Let us create following BST 50 / \ 30 70 / \ / \ 20 40 60 80
     */
    tree.insert(50);
    tree.insert(30);
    tree.insert(20);
    tree.insert(40);
    tree.insert(70);
    tree.insert(60);
    tree.insert(80);

    // print inorder traversal of the BST
    tree.inorder();

    System.out.println("\nDelete 20");
    tree.deleteKey(20);
    System.out.println("Inorder traversal of the modified tree");
    tree.inorder();

    System.out.println("\nDelete 30");
    tree.deleteKey(30);
    System.out.println("Inorder traversal of the modified tree");
    tree.inorder();

    System.out.println("\nDelete 50");
    tree.deleteKey(50);
    System.out.println("Inorder traversal of the modified tree");
    tree.inorder();

    BinarySearchTree t1 = new BinarySearchTree();
    t1.root = new Node(2);
    t1.root.left = new Node(1);
    t1.root.right = new Node(3);
    /*
     * t1.root.left.left = new Node(4); t1.root.left.right = new Node(12); t1.root.left.right.left =
     * new Node(10); t1.root.left.right.right = new Node(14);
     */
    /*
     * int n1 = 10, n2 = 14; Node t = t1.lca(t1.root, n1, n2); System.out.println("LCA of " + n1 +
     * " and " + n2 + " is " + t.data);
     *
     * n1 = 14; n2 = 8; t = t1.lca(t1.root, n1, n2); System.out.println("LCA of " + n1 + " and " +
     * n2 + " is " + t.data);
     *
     * n1 = 10; n2 = 22; t = t1.lca(t1.root, n1, n2); System.out.println("LCA of " + n1 + " and " +
     * n2 + " is " + t.data);
     */
    List<LinkedList<Integer>> res = allSequences(t1.root);
    System.out.println("========== ALL BST SEQUENCES ============");
    System.out.println();
    res.stream().forEach(l -> System.out.println(l));

  }

}
