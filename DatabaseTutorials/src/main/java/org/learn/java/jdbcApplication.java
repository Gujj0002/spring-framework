package org.learn.java;

import java.sql.*;

import static java.lang.Class.forName;

public class jdbcApplication {

    static final String Driver = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/spring_web_boot";
    static final String USER_NAME = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName(Driver);
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        System.out.println("Database connection established.");
        Statement statement = connection.createStatement();

       /* String sqlPrepared = "INSERT INTO BOOK (ID,NAME) VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlPrepared);*/


        String sqlCallable = "{call list_name(?,?)}";
        CallableStatement callableStatement = connection.prepareCall(sqlCallable);
        callableStatement.setInt(1, 10004);
        callableStatement.setString(2, "Black Panther");
        callableStatement.executeUpdate();

       /* preparedStatement.setInt(1,10002); preparedStatement.executeUpdate();
        preparedStatement.setString(2,"The Avengers");
        preparedStatement.executeUpdate();*/

       /* preparedStatement.setInt(1,10003);
        preparedStatement.setString(2,"The Avengers: Endgame");
        preparedStatement.executeUpdate();
*/

        /*String insert = "INSERT INTO BOOK" + "(id,NAME )" + "VALUES(1002, 'Iron man')";
        statement.executeUpdate(insert);*/

        String sqlQuery = "SELECT * FROM BOOK";
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + " " + resultSet.getString("NAME"));
        }

        statement.close();
        connection.isClosed();


    }
}
