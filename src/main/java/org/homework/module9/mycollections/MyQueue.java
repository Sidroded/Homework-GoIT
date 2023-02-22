package org.homework.module9.mycollections;

public class MyQueue<E> {
    private int size = 0;
    private Node prev;
    private Node next;
    private Node firstNode;

    public void add(E o) {
        Node node;

        if (size == 0) {
            node = new Node(o, null, null);
            firstNode = node;
            next = node;
            prev = node;
        } else {
            node = new Node(o, null, prev);
            prev = node;
            next.setNext(node);
            next = node;
        }

        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        prev = null;
        next = null;
        firstNode = null;
    }

    public E peek() {
        return firstNode.getObject();
    }

    public E pull() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("MyQueue is empty");
        }

        Node firstNode = this.firstNode;
        Node nextRemove = firstNode.getNext();

        this.firstNode = nextRemove;

        if (nextRemove != null) nextRemove.setPrev(null);

        this.size--;

        return firstNode.getObject();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = firstNode;

        for (int i = 0; i < size; i++) {
            sb.append(current.getObject().toString());
            if (size - 1 != i) {
                sb.append(", ");
            }
            current = current.getNext();
        }

        return sb.append("]").toString();
    }

    private class Node {
        private final E o;
        private Node next;
        private Node prev;


        public Node(E o, Node next, Node prev) {
            this.o = o;
            this.next = next;
            this.prev = prev;
        }

        public E getObject() {
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
}
