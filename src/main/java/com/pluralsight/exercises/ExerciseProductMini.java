package com.pluralsight.exercises;

import java.sql.*;
import java.util.Scanner;

public class ExerciseProductMini {

    public static void main(String[] args) throws SQLException {
        // get the connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "yearup");

        // create statement
        String query = "SELECT first_name, address_id FROM customer WHERE first_name = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        // set params
        String input;
        do {
            input = getUserInput("enter name: ");
            if (!input.isEmpty()) {
                break;
            }else {
                System.out.println("Please enter a name!");
            }
        }while (true);

        String name = input;
        statement.setString(1, name);

        // execute query
        ResultSet rs = statement.executeQuery();

        // process results
        boolean run = true;
        do {
            if (rs.next()) {
                System.out.println(rs.getString(1) + " : " + rs.getInt(2));
                run = false;
            }
        }while(run);


        connection.close();
    }

    public static String getUserInput(String q){
        System.out.print(q);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
