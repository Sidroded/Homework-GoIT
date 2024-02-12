package org.homework.dev_module6.entity;

public class LongestProject {
    private int ID;
    private int monthCount;

    public LongestProject(int ID, int monthCount) {
        this.ID = ID;
        this.monthCount = monthCount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(int monthCount) {
        this.monthCount = monthCount;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "ID=" + ID +
                ", monthCount=" + monthCount +
                '}';
    }
}
