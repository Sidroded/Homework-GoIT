package org.homework.module11.task5;

import java.util.Iterator;
import java.util.stream.Stream;

public class MainTaskFive {
    public static void main(String[] args) {
        Integer[] evenNumbers = {0, 2, 4, 6, 8, 10, 12, 14};
        Integer[] oddNumbers = {1, 3, 5, 7, 9};

        Stream<Integer> evenStream = Stream.of(evenNumbers);
        Stream<Integer> oddStream = Stream.of(oddNumbers);

        Stream<Integer> zippedStream = zip(evenStream, oddStream);
        zippedStream.forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Stream<T> zipped = Stream.empty();

        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            zipped = Stream.concat(zipped, Stream.of(firstIterator.next(), secondIterator.next()));
        }

        return zipped;
    }
}