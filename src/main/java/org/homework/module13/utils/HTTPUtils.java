package org.homework.module13.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.homework.module13.model.Post;
import org.homework.module13.model.user.Address;
import org.homework.module13.model.user.Company;
import org.homework.module13.model.user.Geo;
import org.homework.module13.model.user.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HTTPUtils {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final String LINK_USERS = "https://jsonplaceholder.typicode.com/users";
    private static final String LINK_POSTS = "https://jsonplaceholder.typicode.com/posts";

    public static void POSTUser(User user) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(LINK_USERS))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response =
                CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
    }

    public static void PUTUser(User user) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%d", LINK_USERS, user.getId())))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response =
                CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
    }

    public static void DELETEUser(User user) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%d", LINK_USERS, user.getId())))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        HttpResponse<String> response =
                CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
    }

    public static String GETAllUsers() throws IOException {
        StringBuilder response = new StringBuilder();
        URL url = new URL(LINK_USERS);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } else {
            System.out.println("GET request not worked");
        }
        return response.toString();
    }

    public static String GETUserById(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%d", LINK_USERS, id)))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static String GETUserByUsername(String username) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s?username=%s", LINK_USERS, username)))
                .GET()
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static void GETAllCommentsFromLastPostOfUser(User user) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().create();
        int userId = user.getId();
        HttpRequest requestPosts = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%d/posts", LINK_USERS, userId)))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> responsePost = CLIENT.send(requestPosts, HttpResponse.BodyHandlers.ofString());

        List<Post> posts = gson.fromJson(responsePost.body(), new TypeToken<List<Post>>(){}.getType());
        int lastPostId = posts.stream()
                .mapToInt(Post::getId)
                .max()
                .orElse(0);

        HttpRequest requestComment = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%d/comments", LINK_POSTS, lastPostId)))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> responseComment = CLIENT.send(requestComment, HttpResponse.BodyHandlers.ofString());

        TaskUtils.writeToJsonFile(responseComment.body(), userId, lastPostId);
    }
}
