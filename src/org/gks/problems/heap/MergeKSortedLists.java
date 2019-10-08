package org.gks.problems.heap;

import java.util.PriorityQueue;

class ListNode {
  public int val;
  public ListNode next;

  /**
   * @param val
   * @param next
   */
  public ListNode(int val) {
    super();
    this.val = val;
    this.next = null;
  }
}


public class MergeKSortedLists {

  public static ListNode merge(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>();

    for (ListNode root : lists) {
      if (root != null) {
        pq.add(root);
      }
    }

    ListNode resultHead = null, resultTail = null;

    while (!pq.isEmpty()) {
      ListNode node = pq.poll();
      if (resultHead == null) {
        resultHead = resultTail = node;
      } else {
        resultTail.next = node;
        resultTail = resultTail.next;
      }
      if (node.next != null) {
        pq.add(node.next);
      }
    }
    return resultHead;

  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(6);
    l1.next.next = new ListNode(8);

    ListNode l2 = new ListNode(3);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(7);

    ListNode l3 = new ListNode(1);
    l3.next = new ListNode(3);
    l3.next.next = new ListNode(4);

    ListNode result = MergeKSortedLists.merge(new ListNode[] {l1, l2, l3});
    System.out.print("Here are the elements form the merged list: ");
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }
  }
}

