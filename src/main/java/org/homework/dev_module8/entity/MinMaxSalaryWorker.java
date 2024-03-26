package org.homework.dev_module8.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MinMaxSalaryWorker {
    private String name;
    private int salary;

    public MinMaxSalaryWorker(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
