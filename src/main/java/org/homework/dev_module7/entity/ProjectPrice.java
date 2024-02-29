package org.homework.dev_module7.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProjectPrice {
    private int projectId;
    private int price;

    public ProjectPrice(int projectId, int price) {
        this.projectId = projectId;
        this.price = price;
    }
}
