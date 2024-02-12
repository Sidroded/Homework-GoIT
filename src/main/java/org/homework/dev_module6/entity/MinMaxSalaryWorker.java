package org.homework.dev_module6.entity;

public class MinMaxSalaryWorker {
    private String name;
    private int salary;

    public MinMaxSalaryWorker(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "MinMaxSalaryWorker{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
