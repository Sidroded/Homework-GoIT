package org.homework.module11.task2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainTaskTwo {
    private static final List<String> names = Arrays.asList("Bogdan", "Adam", "Zohan", "Ivan", "Daniil", "Oleg", "Tim");

    public static void main(String[] args) {
        System.out.println(sortAndUppercase(names));
    }

    private static List<String> sortAndUppercase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .sorted(Collections.reverseOrder())
                .toList();
    }
}
