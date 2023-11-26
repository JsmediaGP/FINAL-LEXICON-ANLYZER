/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Js'Media
 */
public class Database {
    
   public static boolean saveToDatabase(String lastName, String firstName, String otherName, String address, String email, String password, String comment) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/finalproject";
        String jdbcUsername = "root";
        String jdbcPassword = "";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            // Create and execute the SQL query
            String sql = "INSERT INTO lexicon (lastname, firstname, othername, address, email, password, comment) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, lastName);
                preparedStatement.setString(2, firstName);
                preparedStatement.setString(3, otherName);
                preparedStatement.setString(4, address);
                preparedStatement.setString(5, email);
                preparedStatement.setString(6, password);
                preparedStatement.setString(7, comment);

                int rowsAffected = preparedStatement.executeUpdate();

                // Close the connection
                connection.close();

                // Return true if at least one row is affected (data saved successfully)
                return rowsAffected > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
   
    
}
