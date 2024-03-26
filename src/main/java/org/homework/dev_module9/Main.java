package org.homework.dev_module9;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        checkStatusChecker();
        checkDownloader();
        checkStatusCli();
    }

    private static void checkStatusChecker() {
        HttpStatusChecker checker = new HttpStatusChecker();

        try {
            String image = checker.getStatusImage(200);
            log.info("Status 200 image: " + image);

            String nonExistentImage = checker.getStatusImage(10000);
            log.info("This won't be printed because an exception will be thrown.");
        } catch (RuntimeException | IOException e) {
            log.warning("Exception occurred: " + e.getMessage());
        }
    }

    public static void checkDownloader() {
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        try {
            downloader.downloadStatusImage(200);
            downloader.downloadStatusImage(10000);
        } catch (IOException e) {
            log.warning("IOException: " + e.getMessage());
        }
    }

    public static void checkStatusCli() {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}
