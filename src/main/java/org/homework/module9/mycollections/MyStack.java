package org.homework.module9.mycollections;

public class MyStack<E> {
    private int size = 0;
    private Node prev;
    private Node next;
    private Node firstNode;
    private Node lastNode;

    public void push(E o) {
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
            lastNode = node;
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

    public Object peek() {
        return lastNode.getObject();
    }

    public Object pull() {
        Node lastNode = this.lastNode;
        Node prevLast = this.lastNode.getPrev();
        this.lastNode = prevLast;
        if (prevLast != null) prevLast.setNext(null);
        size--;
        return lastNode.getObject();
    }

    public void remove(int index) {
        Node removeNode = firstNode;
        Node prevRemove;
        Node nextRemove;

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Object with index " + index + " doesn't exist.");
        }

        for (int i = 0; i < index; i++) {
            removeNode = removeNode.getNext();
        }

        prevRemove = removeNode.getPrev();
        nextRemove = removeNode.getNext();

        if (index == 0) firstNode = nextRemove;

        if (index == size - 1) lastNode = prevRemove;

        if (prevRemove != null) prevRemove.setNext(nextRemove);

        if (nextRemove != null) nextRemove.setPrev(prevRemove);

        this.size--;
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
