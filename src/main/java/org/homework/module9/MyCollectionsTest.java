package org.homework.module9;

import org.homework.module9.mycollections.*;

public class MyCollectionsTest {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        MyQueue<String> myQueue = new MyQueue<>();
        MyStack<String> myStack = new MyStack<>();
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();

        testMyArrayList(myArrayList);
        testMyLinkedList(linkedList);
        testMyQueue(myQueue);
        testMyStack(myStack);
        testMyHashMap(myHashMap);
    }

    private static void testMyStack(MyStack<String> myStack) {
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

    private static void testMyQueue(MyQueue<String> myQueue) {
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

    public static void testMyArrayList(MyArrayList<String> myArrayList) {
        //Заполняем масив используя метод - add(), поскольку длина больше минимальной длины массива - массив пересоздается.
        for (int i = 0; i < 11; i++) {
            myArrayList.add("MyArrayList " + i);
        }

        //Выводим его размер вызывая метод - size()
        System.out.println(myArrayList + " size is " + myArrayList.size());

        //Выводим весь масив используя метод - get()
        System.out.println(myArrayList.get(0) + " " + myArrayList.get(10));

        //Удаление и смещение массива вызывая метод - remove()
        System.out.println("Now we are going to remove [" + myArrayList.get(0) + "] size is - " + myArrayList.size());
        myArrayList.remove(0);
        System.out.println(myArrayList + " remove is successful size is - " + myArrayList.size());

        //Очищаем MyArrayList используя метод - clear()
        myArrayList.clear();
        System.out.println("Clear is successful " + myArrayList + " size is - " + myArrayList.size());
    }

    public static void testMyLinkedList(MyLinkedList<String> linkedList) {
        //Заполнение MyLinkedList обьектами с помощью - add()
        for (int i = 0; i < 3; i++) {
            linkedList.add("LinkedList " + i);
        }

        //Получаем обьекты из MyLinkedList используя метод - get() и выводим все элементы колекции и ее размер с помощью метода - size()
        System.out.println(linkedList + " size is - " + linkedList.size());
        System.out.println(linkedList.get(2));

        //Удаление и смещение массива вызывая метод - remove() и получаем измененную колекцию
        linkedList.remove(0);
        System.out.println(linkedList + " size is - " + linkedList.size());

        //Очищаем и выводим колекцию
        linkedList.clear();
        System.out.println(linkedList + " size is - " + linkedList.size());
    }

    public static void testMyHashMap(MyHashMap<String, Integer> myHashMap) {
        //Заполнение MyHashMap обьектами с помощью - put() и изменение значения элемента с существующим ключем.
        //Вывод размера с помощью метода - size()
        for (int i = 0; i < 3; i++) {
            myHashMap.put("MyHashMap key " + i, i);
        }

        System.out.println(myHashMap + " size is - " + myHashMap.size());
        myHashMap.put("MyHashMap key 1", 9999999);
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
