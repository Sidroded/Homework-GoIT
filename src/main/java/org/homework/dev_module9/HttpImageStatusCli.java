package org.homework.dev_module9;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    private final HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter HTTP status code: ");

        if (scanner.hasNextInt()) {
            int statusCode = scanner.nextInt();

            try {
                downloader.downloadStatusImage(statusCode);
            } catch (IOException e) {
                System.out.println("There is no image for HTTP status " + statusCode);
            }
        } else {
            System.out.println("Please enter a valid number.");
            scanner.next();
        }
    }

}
