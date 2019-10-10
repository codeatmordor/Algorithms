package org.gks.problems.linkedlist;

import java.util.ArrayList;
import java.util.List;


public class LinkList {

  private class Node {
    String value;
    Node next;

    Node(String value) {
      this.value = value;
      this.next = null;
    }
  }

  private Node start;
  private int length;

  /**
   * @param start
   * @param length
   */
  public LinkList(String value) {
    super();
    this.start = new Node(value);
    start.next = null;
    this.length = 1;
  }

  public void add(String value) {
    Node curr = start;
    while (curr.next != null) {
      curr = curr.next;
    }
    Node n = new Node(value);
    n.next = null;
    curr.next = n;
    length++;
  }

  public String getNthToLastNode(int n) {
    if (n > length)
      throw new IllegalArgumentException();
    int frombegin = (length - n) + 1;
    int count = 1;
    Node curr = start;
    while (count < frombegin) {
      curr = curr.next;
      count++;
    }
    return curr.value;
  }

  public List<Node> split() {
    Node list = this.start;
    // runner will be the fast moving pointer
    Node runner = list.next;
    List<Node> toReturn = new ArrayList<>();

    while (runner != null) {
      runner = runner.next;
      if (runner == null)
        break;
      runner = runner.next;
      list = list.next;
    }
    toReturn.add(list.next);
    list.next = null;
    toReturn.add(this.start);
    return toReturn;
  }

  public void displayMiddle() {
    Node list = this.start;
    Node fast = list;

    while (fast != null && fast.next != null) {
      if (fast == null) {
        System.out.println(list.toString());
        break;
      }

      list = list.next;
      if (fast.next.next != null)
        fast = fast.next.next;
    }

  }

  public void reverse() {
    Node n = this.start;
    Node prev = null;
    Node temp = null;
    while (n != null) {
      temp = n.next;
      n.next = prev;
      prev = n;
      n = temp;
    }
    this.start = prev;

  }

  public void display() {
    Node n = this.start;

    while (n != null) {
      System.out.println(n.value);
      n = n.next;
    }

  }
}
