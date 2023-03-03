package org.homework.module10.task3;

import org.homework.module10.task3.core.WordFounder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainTaskThree {
    public static void main(String[] args) {
        String inputFile = "words.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            WordFounder founder = new WordFounder(reader);
            founder.start();
            System.out.println(founder.getResult());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
