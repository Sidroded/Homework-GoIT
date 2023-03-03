package org.homework.module10.task3.core;

public class Word implements Comparable<Word> {
    private final String name;
    private final int count;

    public Word(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Word{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public int compareTo(Word o) {
        if (this.count > o.count) {
            return -1;
        } else if (this.count < o.count) {
            return 1;
        }
        return 0;
    }
}
