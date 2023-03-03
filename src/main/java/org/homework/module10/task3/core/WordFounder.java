package org.homework.module10.task3.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class WordFounder {
    private final BufferedReader reader;
    private final StringBuilder result = new StringBuilder();
    private final StringBuilder data = new StringBuilder();
    private final Set<Word> words = new TreeSet<>();

    public WordFounder(BufferedReader reader) throws IOException {
        this.reader = reader;
    }

    public void start() throws IOException {
        readAllInfo();
        calculateAllCoincidence();
    }

    private void readAllInfo() throws IOException {
        while (reader.ready()) {
            data.append(reader.readLine()).append(" ");
        }
    }

    private void calculateAllCoincidence() {
        String dataString = data.toString().replace("  ", " ");
        String[] dataArr = dataString.split(" ");

        for (String outerString : dataArr) {
            int count = 0;

            for (String innerString : dataArr) {
                if (outerString.equals(innerString)) count++;
            }

            words.add(new Word(outerString, count));
        }
    }

    public String getResult() {
        for (Word word : words) {
            result.append(word.getName()).append(" ").append(word.getCount()).append("\n");
        }
        return result.toString();
    }
}
