package org.homework.dev_module9;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

public class HttpStatusImageDownloader {

    private final HttpStatusChecker checker = new HttpStatusChecker();
    private final Logger log = Logger.getLogger(HttpStatusChecker.class.getName());

    public void downloadStatusImage(int code) throws IOException {
        String imageUrl = checker.getStatusImage(code);

        if (imageUrl != null && !imageUrl.isEmpty()) {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                download(connection, code);
            } else {
                throw new IOException("Failed to download image for status code " + code);
            }
        } else {
            throw new IOException("Image not found for status code " + code);
        }
    }

    private void download(HttpURLConnection connection, int code) throws IOException {
        if (!new File(code + ".jpg").exists()) {
            try (InputStream inputStream = connection.getInputStream();
                 FileOutputStream outputStream = new FileOutputStream(code + ".jpg")) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                log.info("Image downloaded successfully.");
            } catch (IOException e) {
                throw new IOException("Failed to download image for status code " + code);
            }
        } else {
            log.info("FIle " + code + ".jpg already exist");
        }
    }
}
