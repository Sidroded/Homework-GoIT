package org.homework.module9;

import org.homework.module9.mycollections.MyArrayList;

public class MyCollectionsTest {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();

        testMyArrayList(myArrayList);
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
}
