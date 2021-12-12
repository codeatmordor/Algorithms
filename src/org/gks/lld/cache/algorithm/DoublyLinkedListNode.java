package org.gks.lld.cache.algorithm;

public class DoublyLinkedListNode<Element> {

    public Element element;
    public DoublyLinkedListNode prev;
    public DoublyLinkedListNode next;

    public DoublyLinkedListNode(Element element) {
        this.element = element;
        prev = null;
        next = null;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}
