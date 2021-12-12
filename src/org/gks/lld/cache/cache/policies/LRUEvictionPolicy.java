package org.gks.lld.cache.cache.policies;

import org.gks.lld.cache.algorithm.DoublyLinkedList;
import org.gks.lld.cache.algorithm.DoublyLinkedListNode;
import org.gks.lld.cache.algorithm.exceptions.InvalidElementException;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy() {
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> first = dll.getFirstNode();
        if(first == null) {
            return null;
        }
        dll.detachNode(first);
        mapper.remove(first.element);
        return first.getElement();
    }

    @Override
    public void keyAccessed(Key key) {
        try {
            if (mapper.containsKey(key)) {
                dll.detachNode(mapper.get(key));
                dll.addNodeAtLast(mapper.get(key));
            } else {
                DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
                mapper.put(key, newNode);
            }
        } catch (InvalidElementException e) {
            e.printStackTrace();
        }
    }
}
