package org.homework.module10.task2;

import org.homework.module10.task2.user.User;
import org.homework.module10.task2.utils.BufferedJsonWriter;
import org.homework.module10.task2.utils.UserUtils;
import org.json.simple.JSONArray;

import java.io.*;
import java.util.ArrayList;

public class MainTaskTwo {
    public static void main(String[] args) {
        String inputPath = "file.txt";
        String outputPath = "user.json";
        ArrayList<User> users;
        ArrayList<String> usersGson;
        ArrayList<String> usersJsonFromToString;
        JSONArray usersJson;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedJsonWriter writer = new BufferedJsonWriter(new BufferedWriter(new FileWriter(outputPath)))) {
            users = UserUtils.getUsersFromFile(reader);
            usersJson = UserUtils.usersToJsonArray(users);

            usersGson = UserUtils.usersToJsonArrayList(users, UserUtils.Type.JSON);
            usersJsonFromToString = UserUtils.usersToJsonArrayList(users, UserUtils.Type.TO_STRING);

            writer.writeArray(usersGson);
            writer.write(usersJson);
            writer.write(usersJsonFromToString.toString());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
