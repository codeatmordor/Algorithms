

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.heap;


class ListNode implements Comparable<ListNode> {
  public Integer val;
  public ListNode next;

  /**
   * @param val
   * @param next
   */
  public ListNode(Integer val) {
    super();
    this.val = val;
    this.next = null;
  }

  @Override
  public int compareTo(ListNode o) {
    return this.val - o.val;
  }
}
