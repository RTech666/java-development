package com.pluralsight;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initalize ApplicationContext.
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Initalize ProductDao.
        ProductDao productDao = context.getBean(SimpleProductDao.class);

        // Initalize scanner.
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Print home screen.
            System.out.println("Home Screen");
            System.out.println("1. List Products");
            System.out.println("2. Add Product");
            System.out.println("3. Search Product by Name");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("0. Exit");

            // Ask user to enter their choice.
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Read the user input and execute the appropriate method.
            switch (choice) {
                case 1:
                    // Print title.
                    System.out.println("List of Products:");

                    // Print products.
                    List<Product> products = productDao.getAll();
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    // Ask user for the product name.
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();

                    // Ask user for the product category.
                    System.out.print("Enter product category: ");
                    String category = scanner.nextLine();

                    // Ask user for the product price.
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    // Add new product.
                    Product newProduct = new Product(productDao.getAll().size() + 1, name, category, price);
                    productDao.add(newProduct);

                    // Print success message.
                    System.out.println("Product added successfully.");
                    break;
                case 3:
                    // Ask user for product name.
                    System.out.print("Enter product name to search: ");
                    String searchName = scanner.nextLine();

                    // Search for product.
                    Product searchedProduct = productDao.searchByName(searchName);
                    if (searchedProduct != null) {
                        // If found, print success messsage.
                        System.out.println("Product found: " + searchedProduct);
                    } else {
                        // If product isn't found, print error message.
                        System.out.println("Product not found.");
                    }
                    break;
                case 4:
                    // Ask user for product name.
                    System.out.print("Enter product name to update: ");
                    String updateName = scanner.nextLine();

                    // Ask user for new product name.
                    System.out.print("Enter new product name: ");
                    String newName = scanner.nextLine();

                    // Ask user for new category.
                    System.out.print("Enter new product category: ");
                    String newCategory = scanner.nextLine();

                    // Ask user for new product price.
                    System.out.print("Enter new product price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();

                    // Update the product.
                    Product updatedProduct = new Product(0, newName, newCategory, newPrice);
                    productDao.updateByName(updateName, updatedProduct);

                    // Print success messsage.
                    System.out.println("Product updated successfully.");
                    break;
                case 5:
                    // Ask user for the product name.
                    System.out.print("Enter product name to delete: ");
                    String deleteName = scanner.nextLine();

                    // Delete product.
                    productDao.deleteByName(deleteName);

                    // Print success message.
                    System.out.println("Product deleted successfully.");
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}