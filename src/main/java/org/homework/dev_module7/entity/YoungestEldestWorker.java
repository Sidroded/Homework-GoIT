package org.homework.dev_module7.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class YoungestEldestWorker {
    private String type;
    private String name;
    private String birthday;

    public YoungestEldestWorker(String type, String name, String birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }
}
