package com.pluralsight;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Connect to database.
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "TC2%T@ajrGUhcB");
             Statement statement = connection.createStatement()) {

            // Define query to select product details.
            String queryProductDetails = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";

            // Execute query
            try (ResultSet productDetails = statement.executeQuery(queryProductDetails)) {
                while (productDetails.next()) {
                    int productId = productDetails.getInt("ProductID");
                    String productName = productDetails.getString("ProductName");
                    double unitPrice = productDetails.getDouble("UnitPrice");
                    int unitsInStock = productDetails.getInt("UnitsInStock");

                    System.out.println("ID: " + productId);
                    System.out.println("Name: " + productName);
                    System.out.println(String.format("Price: %.2f", unitPrice));
                    System.out.println("Stock: " + unitsInStock);
                    System.out.println("------------------");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}