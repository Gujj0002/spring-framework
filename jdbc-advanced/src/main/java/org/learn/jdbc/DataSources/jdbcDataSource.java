package org.learn.jdbc.DataSources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcDataSource {

    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_advanced";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    public static final Connection getConnection() {

        try {

            Class.forName(Driver);
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            return connection;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
