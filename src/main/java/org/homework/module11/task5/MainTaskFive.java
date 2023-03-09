package org.homework.module11.task5;

import java.util.Objects;
import java.util.stream.Stream;

public class MainTaskFive {
    public static void main(String[] args) {
        Integer[] evenNumbers = {0, 2, 4, 6, 8, 10};
        Integer[] oddNumbers = {1, 3, 5, 7, 9};

        Stream<Integer> evenStream = Stream.of(evenNumbers);
        Stream<Integer> oddStream = Stream.of(oddNumbers);

        Stream<Integer> zippedStream = zip(evenStream, oddStream);
        zippedStream.forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        var iterator1 = first.iterator();
        var iterator2 = second.iterator();

        return Stream.iterate(
                        new Object[]{iterator1.next(), iterator2.next()}, Objects::nonNull,
                        objects -> {
                            try {
                                objects[0] = iterator1.next();
                                objects[1] = iterator2.next();
                                return objects;
                            } catch (Exception e) {
                                return null;
                            }
                        })
                .flatMap(objects -> {
                    if (objects != null) {
                        return Stream.of((T) objects[0], (T) objects[1]);
                    }
                    return Stream.empty();
                });
    }
}