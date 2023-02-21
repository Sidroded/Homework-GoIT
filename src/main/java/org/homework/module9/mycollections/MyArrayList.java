package org.homework.module9.mycollections;

import java.util.Arrays;

public class MyArrayList {

    private Object[] array = {};
    private static final int MIN_CAPACITY = 10;
    private int size = 0;


    public void add(Object o) {
        checkSize();
        size++;
        array[size - 1] = o;
    }

    public Object get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] == array[index]){
                Object[] newArr = new Object[array.length - 1];
                for(int y = 0; y < i; y++){
                    newArr[y] = array[y];
                }
                for(int j = i; j < array.length - 1; j++){
                    newArr[j] = array[j+1];
                }
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

    private void checkSize() {
        if (array.length == size) {
            Object[] copy = Arrays.copyOf(array, array.length + MIN_CAPACITY);
            array = copy;
        }
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
