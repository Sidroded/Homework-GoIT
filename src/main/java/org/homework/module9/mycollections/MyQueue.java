package org.homework.module9.mycollections;

public class MyQueue {
    private int index = 0;
    private int size = 0;
    private Node prev;
    private Node next;
    private Node firstNode;

    public void add(Object o) {
        Node node;

        if (size == 0) {
            node = new Node(o, null, null, index);
            firstNode = node;
            next = node;
            prev = node;
        } else {
            node = new Node(o, null, prev, index);
            prev = node;
            next.setNext(node);
            next = node;
        }

        size++;
        index++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        index = 0;
        size = 0;
        prev = null;
        next = null;
        firstNode = null;
    }

    public Object peek() {
        return firstNode.getObject();
    }

    public Object pull() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("MyQueue is empty");
        }

        Node firstNode = this.firstNode;
        Node nextRemove = firstNode.getNext();

        this.firstNode = nextRemove;

        if (nextRemove != null) nextRemove.setPrev(null);

        this.index--;
        this.size--;

        if (nextRemove != null) {
            for (int i = nextRemove.getIndex(); i < this.index; i++) {
                nextRemove.setIndex(nextRemove.getIndex() - 1);
            }
        }

        return firstNode.getObject();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = firstNode;

        for (int i = 0; i < this.index; i++) {
            sb.append(current.getObject().toString());
            if (this.index - 1 != i) {
                sb.append(", ");
            }
            current = current.getNext();
        }

        return sb.append("]").toString();
    }
}
