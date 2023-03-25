package org.homework.module13.model;

public class Todo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Todo() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\"userId\":" + userId +
                ",\n\"id\":" + id +
                ",\n\"title\":\"" + title +
                "\",\n\"completed:\"" + completed +
                "\n}\n";
    }
}
