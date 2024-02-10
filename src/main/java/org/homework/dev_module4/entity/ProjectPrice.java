package org.homework.dev_module4.entity;

public class ProjectPrice {
    private int projectId;
    private int price;

    public ProjectPrice(int projectId, int price) {
        this.projectId = projectId;
        this.price = price;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProjectPrice{" +
                "projectId=" + projectId +
                ", price=" + price +
                '}';
    }
}
