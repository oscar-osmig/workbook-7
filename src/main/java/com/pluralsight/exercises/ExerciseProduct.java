package com.pluralsight.exercises;

import java.sql.*;

public class ExerciseProduct {
    public static void main(String[] args) throws SQLException {
        // get the connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "yearup");

        // create statement
        Statement statement = connection.createStatement();

        // execute query
        String query = "SELECT productName\n" +
                "FROM products";

        ResultSet rs = statement.executeQuery(query);
        //System.out.println("first_name - last_name - actor_id");
        // process results
        while (rs.next()) {

            System.out.println(rs.getString("productName"));


        }

        connection.close();
    }

}
