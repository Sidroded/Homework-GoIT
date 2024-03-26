package org.homework.dev_module9;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws IOException {
        String urlString = "https://http.cat/" + code + ".jpg";
        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            return urlString;
        } else {
            throw new IOException("Image not found for status code " + code);
        }
    }
}
