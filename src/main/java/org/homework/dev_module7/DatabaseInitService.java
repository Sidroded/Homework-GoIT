package org.homework.dev_module7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseInitService {
    private static final String path = "sql/init_db.sql";

    public static void main(String[] args) {
        try {
            Connection conn = Database.getInstance().getConnection();

            for (String query : DatabaseUtils.getQueryList(path)) {
                PreparedStatement statement = conn.prepareStatement(query);
                int result = statement.executeUpdate(query);
                System.out.println(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
