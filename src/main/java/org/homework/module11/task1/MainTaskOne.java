package org.homework.module11.task1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainTaskOne {
    private static final List<String> names = Arrays.asList("Bogdan", "Ivan", "Daniil", "Oleg", "Tim");

    public static void main(String[] args) {
        System.out.println(getOddElements(names));
    }

    private static String getOddElements(List<String> list) {

        return IntStream.range(0, list.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> i + ". " + list.get(i))
                .collect(Collectors.joining(", "));
    }
}
