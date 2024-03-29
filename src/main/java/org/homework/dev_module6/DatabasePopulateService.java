package org.homework.dev_module6;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    private static final String path = "sql/populate_db.sql";

    public static void main(String[] args) {
        try {
            Connection conn = Database.getInstance().getConnection();
            Statement stmt = conn.createStatement();

            for (String query : DatabaseUtils.getQueryList(path)) {
                int result = stmt.executeUpdate(query);
                System.out.println(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
