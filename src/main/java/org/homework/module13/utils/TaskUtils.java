package org.homework.module13.utils;

import org.homework.module13.model.user.Address;
import org.homework.module13.model.user.Company;
import org.homework.module13.model.user.Geo;
import org.homework.module13.model.user.User;

import java.io.File;
import java.io.FileWriter;

public class TaskUtils {
    public static User getDefaultUser() {
        User user = new User();
        user.setId(10);
        user.setName("Daniil");
        user.setUsername("DD");
        user.setWebsite("deinekindaniil21@gmail.com");
        user.setPhone("132456799");
        user.setEmail("123123");
        user.setCompany(new Company("23123", "123123", "123123"));
        user.setAddress(new Address("1231", "123123", "123123", "234234", new Geo("21312", "q312123")));
        return user;
    }

    public static void writeToJsonFile(String str, int userId, int postId) {
        String path = String.format("user-%d-post-%d-comments.json", userId, postId);
        File file = new File(path);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
