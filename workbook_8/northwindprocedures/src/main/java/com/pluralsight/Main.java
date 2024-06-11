package com.pluralsight;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Create database connection.
            DataManager dataManager = new DataManager("jdbc:mysql://localhost:3306/northwind", "root", "TC2%T@ajrGUhcB");

            while (true) {
                // Print home screen.
                System.out.println("Choose an option:");
                System.out.println("1. Search for customer order history");
                System.out.println("2. Search for sales by year");
                System.out.println("3. Search for sales by category");
                System.out.println("4. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();

                // Read the user input and execute the appropiate method.
                switch (choice) {
                    case 1:
                        System.out.print("Enter customer ID: ");
                        String customerId = scanner.nextLine();
                        List<CustomerOrderHistory> history = dataManager.getCustomerOrderHistory(customerId);
                        for (CustomerOrderHistory h : history) {
                            System.out.println("Product: " + h.getProductName() + ", Total: " + h.getTotal());
                        }
                        break;
                    case 2:
                        System.out.print("Enter year: ");
                        int year = scanner.nextInt();
                    
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, Calendar.JANUARY);
                        calendar.set(Calendar.DAY_OF_MONTH, 1);
                        java.sql.Date startDate = new java.sql.Date(calendar.getTimeInMillis());
                    
                        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
                        calendar.set(Calendar.DAY_OF_MONTH, 31);
                        java.sql.Date endDate = new java.sql.Date(calendar.getTimeInMillis());

                        try {
                            List<SalesByYear> salesByYear = dataManager.getSalesByYear(startDate, endDate);
                            for (SalesByYear s : salesByYear) {
                                System.out.println("Shipped Date: " + s.getShippedDate() + ", Order ID: " + s.getOrderID() + ", Subtotal: " + s.getSubtotal());
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        System.out.print("Enter category: ");
                        String category = scanner.nextLine();
                    
                        System.out.print("Enter year: ");
                        String yearDate = scanner.nextLine();
                    
                        try {
                            List<SalesByCategory> salesByCategory = dataManager.getSalesByCategory(category, yearDate);
                            for (SalesByCategory s : salesByCategory) {
                                System.out.println("Product Name: " + s.getProductName() + ", Total Purchase: " + s.getTotalPurchase());
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice, please try again.");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}