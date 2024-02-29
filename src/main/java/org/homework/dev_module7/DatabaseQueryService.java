package org.homework.dev_module7;

import org.homework.dev_module7.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private static final String findLongestProjectPath = "sql/find_longest_project.sql";
    private static final String findMaxProjectsClientPath = "sql/find_max_projects_client.sql";
    private static final String findMaxSalaryWorkerPath = "sql/find_max_salary_worker.sql";
    private static final String findYoungestEldestWorkersPath = "sql/find_youngest_eldest_workers.sql";
    private static final String findProjectPricesPath = "sql/print_project_prices.sql";
    private final Connection conn;


    public DatabaseQueryService() {
        conn = Database.getInstance().getConnection();
    }

    public List<LongestProject> findLongestProject() throws SQLException {
        List<LongestProject> longestProjectList = new ArrayList<>();
        PreparedStatement statement = conn.prepareStatement(DatabaseUtils.getQueryString(findLongestProjectPath));
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            LongestProject project = new LongestProject(resultSet.getInt("ID"), resultSet.getInt("MONTH_COUNT"));
            longestProjectList.add(project);
        }

        return longestProjectList;
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() throws SQLException {
        List<MaxProjectCountClient> maxProjectsClient = new ArrayList<>();
        PreparedStatement statement = conn.prepareStatement(DatabaseUtils.getQueryString(findMaxProjectsClientPath));
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            MaxProjectCountClient client = new MaxProjectCountClient(resultSet.getString("NAME"), resultSet.getInt("PROJECT_COUNT"));
            maxProjectsClient.add(client);
        }

        return maxProjectsClient;
    }

    public List<MinMaxSalaryWorker> findMaxSalaryWorker() throws SQLException {
        List<MinMaxSalaryWorker> minMaxSalaryWorker = new ArrayList<>();
        PreparedStatement statement = conn.prepareStatement(DatabaseUtils.getQueryString(findMaxSalaryWorkerPath));
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            MinMaxSalaryWorker project = new MinMaxSalaryWorker(resultSet.getString("NAME"), resultSet.getInt("SALARY"));
            minMaxSalaryWorker.add(project);
        }

        return minMaxSalaryWorker;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers() throws SQLException {
        List<YoungestEldestWorker> youngestEldestWorker = new ArrayList<>();
        PreparedStatement statement = conn.prepareStatement(DatabaseUtils.getQueryString(findYoungestEldestWorkersPath));
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            YoungestEldestWorker project = new YoungestEldestWorker(resultSet.getString("TYPE"), resultSet.getString("NAME"), resultSet.getString("BIRTHDAY"));
            youngestEldestWorker.add(project);
        }

        return youngestEldestWorker;
    }

    public List<ProjectPrice> findProjectPrices() throws SQLException {
        List<ProjectPrice> projectPrice = new ArrayList<>();
        PreparedStatement statement = conn.prepareStatement(DatabaseUtils.getQueryString(findProjectPricesPath));
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            ProjectPrice project = new ProjectPrice(resultSet.getInt("PROJECT_ID"), resultSet.getInt("PRICE"));
            projectPrice.add(project);
        }

        return projectPrice;
    }
}
