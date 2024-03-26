package org.homework.dev_module8.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LongestProject {
    private int ID;
    private int monthCount;

    public LongestProject(int ID, int monthCount) {
        this.ID = ID;
        this.monthCount = monthCount;
    }
}
