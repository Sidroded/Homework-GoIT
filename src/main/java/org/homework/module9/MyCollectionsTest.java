package org.homework.module9;

import org.homework.module9.mycollections.*;

import java.util.HashMap;

public class MyCollectionsTest {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        MyLinkedList linkedList = new MyLinkedList();
        MyQueue myQueue = new MyQueue();
        MyStack myStack = new MyStack();
        MyHashMap myHashMap = new MyHashMap();

        //testMyArrayList(myArrayList);
        //testMyLinkedList(linkedList);
        //testMyQueue(myQueue);
        //testMyStack(myStack);
        //testMyHashMap(myHashMap);
    }

    private static void testMyStack(MyStack myStack) {
        //Заполнение MyStack обьектами с помощью - add()
        for (int i = 0; i < 5; i++) {
            myStack.push("MyStack " + i);
        }

        //Получаем обьекты из MyStack используя метод - peek() и выводим все элементы колекции
        System.out.println("Last element in collection - " + myStack.peek());
        System.out.println(myStack + " size is - " + myStack.size());

        //Удаляем элемент колекции вызывая метод - remove() и получаем измененную колекцию
        myStack.remove(0);
        System.out.println("Remove successes. Last element in collection - " + myStack.peek());
        System.out.println(myStack + " size is - " + myStack.size());

        //Получаем и удаляем элемент используя метод poll()
        System.out.println(myStack.pull());
        System.out.println(myStack.pull());
        System.out.println(myStack + " size is - " + myStack.size());

        //Очищаем и выводим колекцию
        myStack.clear();
        System.out.println(myStack + " size is - " + myStack.size());
    }

    private static void testMyQueue(MyQueue myQueue) {
        //Заполнение MyLinkedList обьектами с помощью - add()
        for (int i = 0; i < 3; i++) {
            myQueue.add("MyQueue " + i);
        }

        //Получаем обьекты из MyQueue используя метод - peek() и выводим все элементы колекции
        System.out.println("First element in collection - " + myQueue.peek());
        System.out.println(myQueue + " size is - " + myQueue.size());

        //Получаем и удаляем элемент колекции вызывая метод - pull() и получаем измененную колекцию
        System.out.println("First element in collection now - " + myQueue.pull());
        System.out.println("First element in collection now - " + myQueue.pull());
        System.out.println(myQueue + " size is - " + myQueue.size());

        //Очищаем и выводим колекцию
        myQueue.clear();
        System.out.println(myQueue + " size is - " + myQueue.size());
    }

    public static void testMyArrayList(MyArrayList myArrayList) {
        //Заполняем масив используя метод - add(), поскольку длина больше минимальной длины массива - массив пересоздается.
        for (int i = 0; i < 11; i++) {
            myArrayList.add("MyArrayList " + i);
        }

        //Выводим его размер вызывая метод - size()
        System.out.println(myArrayList + " size is " + myArrayList.size());
        System.out.println();

        //Выводим весь масив используя метод - get()
        for (int i = 0; i < 11; i++) {
            System.out.println(myArrayList.get(i));
        }
        System.out.println();

        //Удаление и смещение массива вызывая метод - remove()
        System.out.println("Now we are going to remove [" + myArrayList.get(0) + "] size is " + myArrayList.size());
        myArrayList.remove(0);
        System.out.println(myArrayList + " remove is successful");
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

    public static void testMyHashMap(MyHashMap myHashMap) {
        //Заполнение MyHashMap обьектами с помощью - put() и изменение значения элемента с существующим ключем.
        //Вывод размера с помощью метода - size()
        for (int i = 0; i < 3; i++) {
            myHashMap.put("MyHashMap key " + i, "value " + i);
        }

        System.out.println(myHashMap + " size is - " + myHashMap.size());
        myHashMap.put("MyHashMap key 1", "new value");
        System.out.println(myHashMap + " size is - " + myHashMap.size());

        //Получаем элемент из колекции с помощью метода - get()
        System.out.println("Value of object with key \"MyHashMap key 1\" - " + myHashMap.get("MyHashMap key 1"));

        //Удаление элемента по ключу используя метод - remove()
        System.out.println("Now we are going to remove \"MyHashMap key 2\"");
        myHashMap.remove("MyHashMap key 2");
        System.out.println("Removed is successful - " + myHashMap + " size is - " + myHashMap.size());

        //Очищаем колекцию используя метод - clear()
        myHashMap.clear();
        System.out.println("Collection is cleared - " + myHashMap + " size is " + myHashMap.size());
    }
}
