package org.homework.module12.task2;

import java.util.Scanner;

public class TaskUtils {

    private static final String START_INFO = "Для того щоб почати роботу із программою" +
            " введіть число включно до якого будуть виконуватись вимоги до завдання.";

    public static int getNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(START_INFO);

        while (!scanner.hasNextInt()) {
            System.out.println(START_INFO);
            scanner.next();
        }

        return scanner.nextInt();
    }

}
