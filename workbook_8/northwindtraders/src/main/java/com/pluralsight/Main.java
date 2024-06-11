package com.pluralsight;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.Scanner;
import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

public class Main {
    // Exercise 1
    // public static void main(String[] args) {
    //     try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "admin", "TC2%T@ajrGUhcB");
    //         Statement statement = connection.createStatement()) {

    //         // Define query to select all products.
    //         String selectQuery = "SELECT * FROM products";

    //         // Execute query.
    //         try (ResultSet allProducts = statement.executeQuery(selectQuery)) {
    //             System.out.println("All Products:");
    //             while (allProducts.next()) {
    //                 int productId = allProducts.getInt("ProductID");
    //                 String productName = allProducts.getString("ProductName");
    //                 System.out.println("ID: " + productId + ", Name: " + productName);
    //             }
    //         }

    //         // Define query to select all product names.
    //         String queryProductNames = "SELECT ProductName FROM products";

    //         // Execute query.
    //         try (ResultSet productNames = statement.executeQuery(queryProductNames)) {
    //             System.out.println("\nProduct Names:");
    //             while (productNames.next()) {
    //                 String productName = productNames.getString("ProductName");
    //                 System.out.println(productName);
    //             }
    //         }

    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }

    // Exercise 2
    // public static void main(String[] args) {
    //     // Connect to database.
    //     try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "TC2%T@ajrGUhcB");
    //          Statement statement = connection.createStatement()) {

    //         // Define query to select product details.
    //         String queryProductDetails = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";

    //         // Execute query.
    //         try (ResultSet productDetails = statement.executeQuery(queryProductDetails)) {
    //             while (productDetails.next()) {
    //                 int productId = productDetails.getInt("ProductID");
    //                 String productName = productDetails.getString("ProductName");
    //                 double unitPrice = productDetails.getDouble("UnitPrice");
    //                 int unitsInStock = productDetails.getInt("UnitsInStock");

    //                 System.out.println("ID: " + productId);
    //                 System.out.println("Name: " + productName);
    //                 System.out.println(String.format("Price: %.2f", unitPrice));
    //                 System.out.println("Stock: " + unitsInStock);
    //                 System.out.println("------------------");
    //             }
    //         }

    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }

    // Exercise 3 and 4
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                // Print home screen.
                System.out.println("What do you want to do?");
                System.out.println("1) Display all products");
                System.out.println("2) Display all customers");
                System.out.println("3) Display all categories");
                System.out.println("0) Exit");
                System.out.print("Select an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                // Read the user input and execute the appropriate method.
                switch (choice) {
                    case 1:
                        displayAllProducts();
                        break;
                    case 2:
                        displayAllCustomers();
                        break;
                    case 3:
                        displayAllCategories(scanner);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create displayAllProducts() method.
    private static void displayAllProducts() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "TC2%T@ajrGUhcB");
            Statement statement = connection.createStatement()) {

            // Define query to display all products.
            String queryProductDetails = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";

            // Execute query.
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
        }
    }

    // Create displayAllCustomers() method.
    private static void displayAllCustomers() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "TC2%T@ajrGUhcB");
            Statement statement = connection.createStatement()) {

            // Define query to display all customers.
            String queryCustomerDetails = "SELECT ContactName, CompanyName, City, Country, Phone FROM customers ORDER BY Country";
            
            // Execute query.
            try (ResultSet customerDetails = statement.executeQuery(queryCustomerDetails)) {
                while (customerDetails.next()) {
                    String contactName = customerDetails.getString("ContactName");
                    String companyName = customerDetails.getString("CompanyName");
                    String city = customerDetails.getString("City");
                    String country = customerDetails.getString("Country");
                    String phone = customerDetails.getString("Phone");

                    System.out.println("Contact Name: " + contactName);
                    System.out.println("Company Name: " + companyName);
                    System.out.println("City: " + city);
                    System.out.println("Country: " + country);
                    System.out.println("Phone: " + phone);
                    System.out.println("------------------");
                }
            }
        }
    }

    private static void displayAllCategories(Scanner scanner) throws SQLException {
        // Connect to database.
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "TC2%T@ajrGUhcB");
            Statement statement = connection.createStatement()) {
            
            // Define query to display all categories.
            String queryCategoryDetails = "SELECT CategoryID, CategoryName FROM categories ORDER BY CategoryID";
            
            // Execute query.
            try (ResultSet categoryDetails = statement.executeQuery(queryCategoryDetails)) {
                while (categoryDetails.next()) {
                    int categoryId = categoryDetails.getInt("CategoryID");
                    String categoryName = categoryDetails.getString("CategoryName");

                    System.out.println("Category ID: " + categoryId + ", Category Name: " + categoryName);
                }
            }

            // Asks user for the CategoryID.
            System.out.print("Enter the CategoryID to display its products: ");
            int categoryId = scanner.nextInt();

            // Define query to display all products of the entered CategoryID.
            String queryProductsByCategory = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products WHERE CategoryID = " + categoryId;

            // Execute query.
            try (ResultSet productsByCategory = statement.executeQuery(queryProductsByCategory)) {
                while (productsByCategory.next()) {
                    int productId = productsByCategory.getInt("ProductID");
                    String productName = productsByCategory.getString("ProductName");
                    double unitPrice = productsByCategory.getDouble("UnitPrice");
                    int unitsInStock = productsByCategory.getInt("UnitsInStock");

                    System.out.println("ID: " + productId);
                    System.out.println("Name: " + productName);
                    System.out.println(String.format("Price: %.2f", unitPrice));
                    System.out.println("Stock: " + unitsInStock);
                    System.out.println("------------------");
                }
            }
        }
    }
}