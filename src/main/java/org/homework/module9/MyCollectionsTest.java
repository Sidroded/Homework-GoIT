package org.homework.module9;

import org.homework.module9.mycollections.MyArrayList;
import org.homework.module9.mycollections.MyLinkedList;
import org.homework.module9.mycollections.MyQueue;
import org.homework.module9.mycollections.MyStack;

public class MyCollectionsTest {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        MyLinkedList linkedList = new MyLinkedList();
        MyQueue myQueue = new MyQueue();
        MyStack myStack = new MyStack();

        testMyArrayList(myArrayList);
        testMyLinkedList(linkedList);
        testMyQueue(myQueue);
        testMyStack(myStack);
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
}
