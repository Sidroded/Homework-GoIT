package org.homework.module9.mycollections;


public class Node {
    private final Object o;
    private Node next;
    private Node prev;


    public Node(Object o, Node next, Node prev) {
        this.o = o;
        this.next = next;
        this.prev = prev;
    }

    public Object getObject() {
        return o;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

}
