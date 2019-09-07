package org.gks.problems.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DNode {
        int key;
        int value;
        DNode prev, next;
    }

    private Map<Integer, DNode> mp = new HashMap<>();
    private DNode head, tail;
    private int maxCap;
    private int currSize;

    public LRUCache(int maxCap) {
        this.maxCap = maxCap;
        currSize = 0;
        head = new DNode();
        head.prev = null;
        tail = new DNode();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    // New node will always be right after dummy head
    private void addNode(DNode n) {

        n.prev = head;
        n.next = head.next;

        head.next.prev = n;

        head.next = n;

    }

    private void removeNode(DNode n) {
        DNode nPrev = n.prev;
        DNode nNext = n.next;

        nPrev.next = nNext;
        nNext.prev = nPrev;

    }

    private void moveToHead(DNode n) {
        removeNode(n);
        addNode(n);
    }

    public int get(int key) {
        DNode node = mp.get(key);
        boolean itemFound = node != null;
        if (!itemFound)
            return -1;

        moveToHead(node);

        return node.value;
    }

    public void put(int key, int val) {
        DNode n = mp.get(key);
        if (n == null) {
            n = new DNode();
            n.key = key;
            n.value = val;

            mp.put(key, n);
            addNode(n);

            currSize++;

            if (currSize > maxCap) {
                removeLRUEntry(n);
            }

        } else {
            n.value = val;
            moveToHead(n);
        }

    }

    private DNode popTail() {
        DNode itemBeingRemoved = tail.prev;
        removeNode(itemBeingRemoved);
        return itemBeingRemoved;
    }

    private void removeLRUEntry(DNode n) {
        DNode tail = popTail();
        mp.remove(tail.key);
        --currSize;

    }

}