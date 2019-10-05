

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.tree;
/*
 * Construction of Segment Tree from given array We start with a segment arr[0 . . . n-1]. and every
 * time we divide the current segment into two halves(if it has not yet become a segment of length
 * 1), and then call the same procedure on both halves, and for each such segment, we store the sum
 * in the corresponding node. All levels of the constructed segment tree will be completely filled
 * except the last level. Also, the tree will be a Full Binary Tree because we always divide
 * segments in two halves at every level. Since the constructed tree is always a full binary tree
 * with n leaves, there will be n-1 internal nodes. So the total number of nodes will be 2*n – 1.
 * Note that this does not include dummy nodes.
 */

public class SegmentTree {
  int[] stArray;

  SegmentTree(int[] input) {
    int height = (int) Math.ceil((Math.log(input.length) / Math.log(2)));
    int maxSize = 2 * (int) Math.pow(2, height) - 1;
    stArray = new int[maxSize];
    construct(input, 0, input.length - 1, 0);
  }

  int getMid(int start, int end) {
    return start + (end - start) / 2;
  }

  void display() {
    for (int i : stArray) {
      System.out.println(i);
    }
  }

  void updateValueUtil(int rangeStart, int rangeEnd, int indexTobeUpdated, int diff,
      int currIndSegTree) {
    // Base Case: If the input index lies outside the range of
    // this segment
    if (indexTobeUpdated < rangeStart || indexTobeUpdated > rangeEnd)
      return;

    // If the input index is in range of this node, then update the
    // value of the node and its children
    stArray[currIndSegTree] = stArray[currIndSegTree] + diff;
    if (rangeEnd != rangeStart) {
      int mid = getMid(rangeStart, rangeEnd);
      updateValueUtil(rangeStart, mid, indexTobeUpdated, diff, 2 * currIndSegTree + 1);
      updateValueUtil(mid + 1, rangeEnd, indexTobeUpdated, diff, 2 * currIndSegTree + 2);
    }
  }

  // The function to update a value in input array and segment tree.
  // It uses updateValueUtil() to update the value in segment tree
  void updateValue(int arr[], int n, int i, int new_val) {
    // Check for erroneous input index
    if (i < 0 || i > n - 1) {
      System.out.println("Invalid Input");
      return;
    }

    // Get the difference between new value and old value
    int diff = new_val - arr[i];

    // Update the value in array
    arr[i] = new_val;

    // Update the values of nodes in segment tree
    updateValueUtil(0, n - 1, i, diff, 0);
  }

  int construct(int arr[], int startIndex, int endIndex, int currentIndexStArray) {
    // If there is one element in array, store it in current node of
    // segment tree and return
    if (startIndex == endIndex) {
      stArray[currentIndexStArray] = arr[startIndex];
      return arr[startIndex];
    }

    // If there are more than one elements, then recur for left and
    // right subtrees and store the sum of values in this node
    int mid = getMid(startIndex, endIndex);
    stArray[currentIndexStArray] = construct(arr, startIndex, mid, currentIndexStArray * 2 + 1)
        + construct(arr, mid + 1, endIndex, currentIndexStArray * 2 + 2);
    return stArray[currentIndexStArray];
  }

  public static void main(String[] args) {

    int arr[] = {1, 3, 5, 7, 9, 11};

    SegmentTree tree = new SegmentTree(arr);

    tree.display();
  }
}

