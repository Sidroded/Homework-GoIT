package org.homework.module10.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import org.homework.module10.task2.core.User;
import org.homework.module10.task2.core.UserUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainTaskTwo {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String inputPath = "file.txt";
        String outputPath = "user.json";
        ArrayList<User> users;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             JsonWriter jsonWriter = gson.newJsonWriter(new FileWriter(outputPath))) {
            users = UserUtils.getUsersFromFile(reader);

            String usersJsonString = gson.toJson(users);

            jsonWriter.jsonValue(usersJsonString);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
