package org.homework.module9.mycollections;

public class MyHashMap<K,V> {
    private int size = 0;
    private NodeHash firstNode;
    private NodeHash next;

    public void put(K key, V value) {
        NodeHash current = firstNode;

        for (int i = 0; i < size; i++) {
            if (current.getKey().equals(key)) {
                current.setValue(value);
                return;
            }

            current = current.getNext();
        }

        NodeHash node = new NodeHash(key, value, null);

        if (size == 0) {
            firstNode = node;
        } else {
            next.setNext(node);
        }

        next = node;
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        next = null;
        firstNode = null;
    }

    public V get(K key) {
        NodeHash current = firstNode;

        for (int i = 0; i < size; i++) {
            if (current.getKey().equals(key)) {
                return (V) current.getValue();
            }
            current = current.getNext();
        }

        return null;
    }

    public void remove(K key) {
        if (firstNode.getKey().equals(key)) {
            firstNode = firstNode.getNext();
            size--;
            return;
        }

        NodeHash current = firstNode.getNext();
        NodeHash prev = firstNode;

        for (int i = 0; i < size; i++) {
            if (current.getKey().equals(key)) {
                prev.setNext(current.getNext());
                size--;
                return;
            }

            prev = current;
            current = current.getNext();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        NodeHash current = firstNode;

        for (int i = 0; i < size; i++) {
            sb.append(current.getKey().toString()).append(" - ").append(current.getValue().toString());
            if (size - 1 != i) {
                sb.append(", ");
            }
            current = current.getNext();
        }

        return sb.append("]").toString();
    }

    private class NodeHash {
        private final K key;
        private V value;
        private NodeHash next;

        public NodeHash(K key, V value, NodeHash next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public NodeHash getNext() {
            return next;
        }

        public void setNext(NodeHash next) {
            this.next = next;
        }
    }
}


