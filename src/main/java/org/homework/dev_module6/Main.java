package org.homework.dev_module6;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println(new DatabaseQueryService().findLongestProject());
        System.out.println(new DatabaseQueryService().findMaxProjectsClient());
        System.out.println(new DatabaseQueryService().findMaxSalaryWorker());
        System.out.println(new DatabaseQueryService().findYoungestEldestWorkers());
        System.out.println(new DatabaseQueryService().findProjectPrices());
    }
}
