package org.gks.problems.misc;


// PACKAGE/IMPORTS --------------------------------------------------


class ListNode {
  int val;
  ListNode next;


  ListNode(int i) {
    val = i;
    next = null;
  }
}


public class LinkedListLoopLogicMonitor {

  static boolean detectLoop(ListNode root) {

    if (root == null || root.next == null)
      return false;

    ListNode slowOne = root;
    ListNode fastOne = root.next;

    while (fastOne.next != null && slowOne.next != null && slowOne != fastOne) {
      slowOne = slowOne.next;
      fastOne = fastOne.next.next;
      if (slowOne == fastOne)
        return true;
    }

    return false;

  }



  public static void main(String[] args) {

  }
}

