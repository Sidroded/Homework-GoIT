package org.homework.module9.mycollections;

import java.util.Arrays;
import java.util.Objects;

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

    public Object get(int index) {
        Objects.checkIndex(index, size);
        return (E) array[index];
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
