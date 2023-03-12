package org.homework.module11.task3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainTaskThree {
    public static void main(String[] args) {
        List<String> array = Arrays.asList("1, 2, 0", "4, 5", "10, 11", "33");

        String result = array.stream()
                .flatMap(string -> Arrays.stream(string.split(",\\s*")))
                .map(Integer :: parseInt)
                .sorted()
                .map(String :: valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}
