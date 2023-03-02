package org.homework.module10.task1.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineReviewer {
    private final BufferedReader reader;
    private final String[] regex;
    private final StringBuilder result = new StringBuilder();
    private final ArrayList<String> inputDataArr = new ArrayList<>();

    public LineReviewer(BufferedReader reader, String... regex) throws IOException {
        this.reader = reader;
        this.regex = regex;
        fillAllDataArr();
        review();
    }

    public String getResult() {
        return result.toString();
    }

    private void fillAllDataArr() throws IOException {
        while (reader.ready()) {
            inputDataArr.add(reader.readLine());
        }
    }

    private void review() {
        for (String regex : regex) {
            Pattern pattern = Pattern.compile(regex);

            for (String str : inputDataArr) {
                Matcher matcher = pattern.matcher(str);
                if (matcher.find()) {
                    result.append(str).append("\n");
                }
            }
        }
    }
}
