package org.homework.module9.mycollections;

public class MyHashMap {

}

class NodeHash {
    private final Object key;
    private final Object value;
    private Node next;

    public NodeHash(Object key, Object value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}
