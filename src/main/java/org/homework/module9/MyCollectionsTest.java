package org.homework.module9;

import org.homework.module9.mycollections.MyArrayList;
import org.homework.module9.mycollections.MyLinkedList;

public class MyCollectionsTest {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        MyLinkedList linkedList = new MyLinkedList();

        //testMyArrayList(myArrayList);
        //testMyLinkedList(linkedList);
    }

    public static void testMyArrayList(MyArrayList myArrayList) {
        //Заполняем масив используя метод - add(), поскольку длина больше минимальной длины массива - массив пересоздается.
        for (int i = 0; i < 15; i++) {
            myArrayList.add("MyArrayList " + i);
        }

        //Выводим его размер вызывая метод - size()
        System.out.println("MyArrayList is filled: size is " + myArrayList.size());
        System.out.println();

        //Выводим весь масив используя метод - get()
        for (int i = 0; i < 15; i++) {
            System.out.println(myArrayList.get(i));
        }
        System.out.println();

        //Удаление и смещение массива вызывая метод - remove()
        System.out.println("Now we are going to remove [" + myArrayList.get(0) + "] size is " + myArrayList.size());
        myArrayList.remove(0);
        System.out.println("Remove is successful new element is [" + myArrayList.get(0) + "] size is " + myArrayList.size());
        System.out.println();

        //Очищаем MyArrayList используя метод - clear()
        myArrayList.clear();
        System.out.println(myArrayList.size());
    }

    public static void testMyLinkedList(MyLinkedList linkedList) {
        //Заполнение MyLinkedList обьектами с помощью - add()
        for (int i = 0; i < 3; i++) {
            linkedList.add("LinkedList " + i);
        }

        //Получаем обьекты из MyLinkedList используя метод - get() и выводим все элементы колекции
        System.out.println(linkedList.get(2));
        System.out.println(linkedList + " size is - " + linkedList.size());

        //Удаление и смещение массива вызывая метод - remove() и получаем измененную колекцию
        linkedList.remove(0);
        System.out.println(linkedList + " size is - " + linkedList.size());

        //Очищаем и выводим колекцию
        linkedList.clear();
        System.out.println(linkedList + " size is - " + linkedList.size());
    }
}
