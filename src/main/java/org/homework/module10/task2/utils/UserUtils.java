package org.homework.module10.task2.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.homework.module10.task2.user.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IllegalFormatException;

public class UserUtils {

    /**
     * Read file and return all Users in this file.
     * @param reader
     * @return ArrayList<User> users
     * @throws IOException
     */
    public static ArrayList<User> getUsersFromFile(BufferedReader reader) throws IOException {
        ArrayList<User> users = new ArrayList<>();

        try {
            while (reader.ready()) {
                String data = reader.readLine();

                if (!data.equals("name age")) {
                    String[] dataArr = data.split(" ");

                    User user = new User(dataArr[0], Integer.parseInt(dataArr[1]));
                    users.add(user);
                }
            }
        } catch (IllegalFormatException e) {
            System.err.println("Incorrect data");
            e.printStackTrace();
        }

        return users;
    }

    /**
     * @param users
     * @return JSONArray with all Users
     */
    public static JSONArray usersToJsonArray(ArrayList<User> users) {
        JSONArray jsonArray = new JSONArray();

        for (User user : users) {
            JSONObject object = new JSONObject();
            object.put("name", user.getName());
            object.put("age", user.getAge());
            jsonArray.add(object);
        }

        return jsonArray;
    }

    /**
     * If constant is JSON convert users to Json by Gson
     * If constant is TO_STRING convert users to Json by override method toString()
     * @param users
     * @param constant
     * @return ArrayList<String> of users in Json format
     */
    public static ArrayList<String> usersToJsonArrayList(ArrayList<User> users, Type constant) {
        ArrayList<String> jsonUsersStringList = new ArrayList<>();

        switch (constant) {
            case JSON -> {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                for (User user : users) {
                    jsonUsersStringList.add(gson.toJson(user));
                }
            }
            case TO_STRING -> {
                for (User user : users) {
                    jsonUsersStringList.add(user.toString());
                }
            }
        }

        return jsonUsersStringList;
    }

    public enum Type {
        TO_STRING,
        JSON
    }
}
