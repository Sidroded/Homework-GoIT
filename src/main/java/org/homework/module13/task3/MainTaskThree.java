package org.homework.module13.task3;

import org.homework.module13.utils.HTTPUtils;

import java.io.IOException;

public class MainTaskThree {
    public static void main(String[] args) throws IOException, InterruptedException {
        HTTPUtils.GETOpenTodosForUser(10);
    }
}
