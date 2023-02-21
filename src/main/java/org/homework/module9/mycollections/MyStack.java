package org.homework.module9.mycollections;

public class MyStack {
    private int index = 0;
    private int size = 0;
    private Node prev;
    private Node next;
    private Node firstNode;
    private Node lastNode;

    public void push(Object o) {
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
            lastNode = node;
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
        return lastNode.getObject();
    }

    public Object pull() {
        Node lastNode = this.lastNode;
        Node prevLast = this.lastNode.getPrev();
        this.lastNode = prevLast;
        if (prevLast != null) prevLast.setNext(null);
        size--;
        index--;
        return lastNode.getObject();
    }

    public void remove(int index) {
        Node removeNode = firstNode;
        Node prevRemove;
        Node nextRemove;

        if (index >= this.index || index < 0) {
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

        this.index--;
        this.size--;

        if (nextRemove != null) {
            for (int i = nextRemove.getIndex(); i < this.index; i++) {
                nextRemove.setIndex(nextRemove.getIndex() - 1);
            }
        }
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
