package org.homework.module10.task2.core;

public class User {
    private final String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "\n\t{\n" +
                "\t\t\"name\":\"" + name + "\",\n" +
                "\t\t\"age\":" + age + "\n" +
                "\t}\n";
    }
}
