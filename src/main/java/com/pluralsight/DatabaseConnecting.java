package com.pluralsight;

import javax.sql.DataSource;
import java.sql.*;

public class DatabaseConnecting {

    public static void main(String[] args) throws SQLException {
        // get the connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "yearup");

        // create statement
        Statement statement = connection.createStatement();

        // execute query
        String query = "SELECT first_name, last_name, actor_id\n" +
                       "FROM actor";

        ResultSet rs = statement.executeQuery(query);
        System.out.println("first_name - last_name - actor_id");
        // process results
        while (rs.next()) {

            System.out.println(rs.getString("first_name") + " - " + rs.getString("last_name") +
                    " - " + rs.getString("actor_id"));


        }

        connection.close();
    }
}