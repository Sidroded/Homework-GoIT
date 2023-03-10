package org.homework.module10.task2.core;

import org.homework.module10.task2.core.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IllegalFormatException;

public class UserUtils {
    public static ArrayList<User> getUsersFromFile(BufferedReader reader) throws IOException {
        ArrayList<User> users = new ArrayList<>();

        try {
            while (reader.ready()) {
                String data = reader.readLine();

                if (!data.equals("name age")) {
                    String[] dataArr = data.split(" ");

                    if (dataArr.length != 2 || dataArr[0].matches(".*\\d+.*") || dataArr[1].matches("\\d+")) {
                        continue;
                    }

                    User user = new User(dataArr[0], Integer.parseInt(dataArr[1]));
                    users.add(user);
                }
            }
        } catch (Exception e) {
            System.err.println("Incorrect data");
            e.printStackTrace();
        }

        return users;
    }
}
