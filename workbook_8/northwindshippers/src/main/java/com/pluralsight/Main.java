package com.pluralsight;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataManager dataManager = null;

        try {
            // Create database connection.
            dataManager = new DataManager("jdbc:mysql://localhost:3306/northwind", "root", "TC2%T@ajrGUhcB");

            // Step 1: Prompt user for new shipper data
            System.out.print("Enter new shipper name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new shipper phone: ");
            String phone = scanner.nextLine();

            int newShipperId = dataManager.insertShipper(name, phone);
            System.out.println("New shipper ID: " + newShipperId);

            // Step 2: Display all shippers
            displayAllShippers(dataManager);

            // Step 3: Prompt user to change the phone number of a shipper
            System.out.print("Enter the ID of the shipper to update: ");
            int idToUpdate = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new phone number: ");
            String newPhone = scanner.nextLine();

            dataManager.updateShipperPhone(idToUpdate, newPhone);

            // Step 4: Display all shippers
            displayAllShippers(dataManager);

            // Step 5: Prompt user to delete a shipper
            System.out.print("Enter the ID of the shipper to delete: ");
            int idToDelete = scanner.nextInt();

            if (idToDelete <= 3) {
                System.out.println("Shippers 1-3 cannot be deleted.");
            } else {
                dataManager.deleteShipper(idToDelete);
            }

            // Step 6: Display all shippers
            displayAllShippers(dataManager);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (dataManager != null) {
                try {
                    dataManager.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            scanner.close();
        }
    }

    // Create displayAllShippers method.
    private static void displayAllShippers(DataManager dataManager) throws SQLException {
        List<Shipper> shippers = dataManager.getAllShippers();
        for (Shipper shipper : shippers) {
            System.out.println(shipper);
        }
    }
}