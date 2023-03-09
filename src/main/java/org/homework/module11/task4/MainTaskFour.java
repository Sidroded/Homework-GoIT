package org.homework.module11.task4;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainTaskFour {
    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);

        Stream<Long> randomStream = generate(a, c, m);

        //Перевірка результату на перших 10 елемнтах стріму
        String output = randomStream.limit(10)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(output);
    }

    public static Stream<Long> generate(long a, long c, long m) {
        return Stream.iterate(123456789L, x -> (a * x + c) % m);
    }
}
