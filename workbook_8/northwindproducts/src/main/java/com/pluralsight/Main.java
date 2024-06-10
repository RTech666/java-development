package com.pluralsight;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "admin", "TC2%T@ajrGUhcB");
            Statement statement = connection.createStatement()) {

            // Define query to select all products.
            String selectQuery = "SELECT * FROM products";

            // Execute query.
            try (ResultSet allProducts = statement.executeQuery(selectQuery)) {
                System.out.println("All Products:");
                while (allProducts.next()) {
                    int productId = allProducts.getInt("ProductID");
                    String productName = allProducts.getString("ProductName");
                    System.out.println("ID: " + productId + ", Name: " + productName);
                }
            }

            // Define query to select all product names.
            String queryProductNames = "SELECT ProductName FROM products";

            // Execute query
            try (ResultSet productNames = statement.executeQuery(queryProductNames)) {
                System.out.println("\nProduct Names:");
                while (productNames.next()) {
                    String productName = productNames.getString("ProductName");
                    System.out.println(productName);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}