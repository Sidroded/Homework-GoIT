package org.homework.dev_module4;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class DatabaseUtils {

    public static List<String> getQueryList(String path) {
        String filePath = new File(path).getAbsolutePath();
        StringBuilder result = new StringBuilder();

        try (Scanner scanner = new Scanner(new FileReader(filePath))) {
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return List.of(result.toString().split(";"));
    }

    public static String getQueryString(String path) {
        String filePath = new File(path).getAbsolutePath();
        StringBuilder result = new StringBuilder();

        try (Scanner scanner = new Scanner(new FileReader(filePath))) {
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
