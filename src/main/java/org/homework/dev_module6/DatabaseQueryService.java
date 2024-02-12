package org.homework.dev_module6;

import org.homework.dev_module6.entity.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private static final String findLongestProjectPath = "sql/find_longest_project.sql";
    private static final String findMaxProjectsClientPath = "sql/find_max_projects_client.sql";
    private static final String findMaxSalaryWorkerPath = "sql/find_max_salary_worker.sql";
    private static final String findYoungestEldestWorkersPath = "sql/find_youngest_eldest_workers.sql";
    private static final String findProjectPricesPath = "sql/print_project_prices.sql";
    private final Statement stmt;


    public DatabaseQueryService() {
        try {
            Connection conn = Database.getInstance().getConnection();
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<LongestProject> findLongestProject() throws SQLException {
        List<LongestProject> longestProjectList = new ArrayList<>();
        ResultSet resultSet = stmt.executeQuery(DatabaseUtils.getQueryString(findLongestProjectPath));

        while (resultSet.next()) {
            LongestProject project = new LongestProject(resultSet.getInt("ID"), resultSet.getInt("MONTH_COUNT"));
            longestProjectList.add(project);
        }

        return longestProjectList;
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() throws SQLException {
        List<MaxProjectCountClient> maxProjectsClient = new ArrayList<>();
        ResultSet resultSet = stmt.executeQuery(DatabaseUtils.getQueryString(findMaxProjectsClientPath));

        while (resultSet.next()) {
            MaxProjectCountClient client = new MaxProjectCountClient(resultSet.getString("NAME"), resultSet.getInt("PROJECT_COUNT"));
            maxProjectsClient.add(client);
        }

        return maxProjectsClient;
    }

    public List<MinMaxSalaryWorker> findMaxSalaryWorker() throws SQLException {
        List<MinMaxSalaryWorker> minMaxSalaryWorker = new ArrayList<>();
        ResultSet resultSet = stmt.executeQuery(DatabaseUtils.getQueryString(findMaxSalaryWorkerPath));

        while (resultSet.next()) {
            MinMaxSalaryWorker project = new MinMaxSalaryWorker(resultSet.getString("NAME"), resultSet.getInt("SALARY"));
            minMaxSalaryWorker.add(project);
        }

        return minMaxSalaryWorker;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers() throws SQLException {
        List<YoungestEldestWorker> youngestEldestWorker = new ArrayList<>();
        ResultSet resultSet = stmt.executeQuery(DatabaseUtils.getQueryString(findYoungestEldestWorkersPath));

        while (resultSet.next()) {
            YoungestEldestWorker project = new YoungestEldestWorker(resultSet.getString("TYPE"), resultSet.getString("NAME"), resultSet.getString("BIRTHDAY"));
            youngestEldestWorker.add(project);
        }

        return youngestEldestWorker;
    }

    public List<ProjectPrice> findProjectPrices() throws SQLException {
        List<ProjectPrice> projectPrice = new ArrayList<>();
        ResultSet resultSet = stmt.executeQuery(DatabaseUtils.getQueryString(findProjectPricesPath));

        while (resultSet.next()) {
            ProjectPrice project = new ProjectPrice(resultSet.getInt("PROJECT_ID"), resultSet.getInt("PRICE"));
            projectPrice.add(project);
        }

        return projectPrice;
    }
}
