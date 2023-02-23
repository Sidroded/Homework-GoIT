package org.homework.module9.mycollections;

import java.util.Arrays;

public class MyArrayList<E> {

    private Object[] array = {};
    private static final int MIN_CAPACITY = 10;
    private int size = 0;


    public void add(E o) {
        if (array.length == size) {
            array = Arrays.copyOf(array, array.length + MIN_CAPACITY);
        }
        array[size] = o;
        size++;
    }

    public E get(int index) {
        if (index > size - 1 || index < 0) return null;
        return (E) array[index];
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] == array[index]){
                Object[] newArr = new Object[array.length - 1];
                System.arraycopy(array, 0, newArr, 0, i);
                if (array.length - 1 - i >= 0) System.arraycopy(array, i + 1, newArr, i, array.length - 1 - i);
                array = newArr;
                size--;
                break;
            }
        }
    }

    public void clear() {
        array = new Object[0];
        size = 0;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (size - 1 != i) {
                sb.append(", ");
            }
        }

        return sb.append("]").toString();
    }
}
