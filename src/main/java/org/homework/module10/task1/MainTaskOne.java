package org.homework.module10.task1;

import org.homework.module10.task1.core.LineReviewer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainTaskOne {
    public static void main(String[] args) {
        String inputPath = "file.txt";
        String pattern1 = "^\\d{3}\\-\\d{3}\\-\\d{4}$";
        String pattern2 = "^\\(\\d{3}\\)\\s\\d{3}\\-\\d{4}$";

        try(BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            LineReviewer lineReviewer = new LineReviewer(reader, pattern1, pattern2);

            System.out.println(lineReviewer.getResult());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
