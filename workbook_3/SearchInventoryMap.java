package workbook_3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Inventory {
    // Create the variables, as private.
    private int id;
    private String name;
    private double price;

    // Create the constrcutor.
    public Inventory(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Create the setter and getters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: $" + price;
    }
}

public class SearchInventoryMap {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Create the Map.
    private Map<String, Inventory> inventory;

    // Create the variables.
    static SearchInventoryMap searchInventory;
    static String csvFile;
    static String delimiter;
    static int id;
    static String name;
    static double price;
    static Inventory product;
    static double minPrice;
    static double maxPrice;
    static Inventory newInventory;

    public static void main(String[] args) {
        searchInventory = new SearchInventoryMap();
        searchInventory.loadInventory();

        int choice;
        do {
            // Create the menu.
            System.out.println("\nWhat do you want to do?");
            System.out.println("1- List all products");
            System.out.println("2- Lookup a product by its id");
            System.out.println("3- Find all products within a price range");
            System.out.println("4- Add a new product");
            System.out.println("5- Quit the application");
            System.out.print("Enter command: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            // Read the user input and execute the appropiate method.
            switch (choice) {
                case 1:
                    searchInventory.listAllProducts();
                    break;
                case 2:
                    searchInventory.lookupProductsByID();
                    break;
                case 3:
                    searchInventory.findProductsByPriceRange();
                    break;
                case 4:
                    searchInventory.addNewProduct();
                    break;
                case 5:
                    System.out.println("Quitting the application.");
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);
    }

    // Create SearchInventoryMap() method.
    public SearchInventoryMap() {
        // Initalize the Map.
        this.inventory = new HashMap<>();
    }

    // Create loadInventory method.
    public void loadInventory() {
        String line;

        // Initalize the variables.
        csvFile = "inventory.csv";
        delimiter = "\\|";
    
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // Split the entries.
                String[] parts = line.split(delimiter);

                if (parts.length == 3) {
                    // Set the variables from parts split.
                    id = Integer.parseInt(parts[0]);
                    name = parts[1];
                    price = Double.parseDouble(parts[2]);

                    // Add the items to the inventory Map.
                    inventory.put(name, new Inventory(id, name, price));
                // Print error message if inventory.csv has a line that isnt formatted correctly.
                } else {
                    System.out.println("Invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Create the listAllProducts method.
    public void listAllProducts() {
        // Print the products.
        System.out.println("All products:");
        for (Inventory Inventory : inventory.values()) {
            System.out.println(Inventory);
        }
    }

    // Create the lookupProductsByID method.
    public void lookupProductsByID() {
        String choice;
        do {
            // Ask user for the product ID.
            System.out.print("Enter product ID: ");
            id = scanner.nextInt();

            // Search the Map for the item that matches the entered ID.
            Inventory product = null;
            for (Inventory p : inventory.values()) {
                if (p.getId() == id) {
                    product = p;
                    break;
                }
            }

            // If product found.
            if (product != null) {
                System.out.println("Product found: " + product);
            // If product not found.
            } else {
                System.out.println("Product not found");
            }

            // Ask user if they want to do another search.
            System.out.print("Do you want to search again? (Yes/No): ");
            scanner.nextLine();
            choice = scanner.nextLine();

        } while (choice.equalsIgnoreCase("yes"));
    }

    // Create findProductsByPriceRange method.
    public void findProductsByPriceRange() {
        // Ask user for the minimum price.
        System.out.print("Enter minimum price: ");
        minPrice = scanner.nextDouble();

        // Ask user for maximum price.
        System.out.print("Enter maximum price: ");
        maxPrice = scanner.nextDouble();

        // Print products that match the price range.
        System.out.println("Products within price range:");
        for (Inventory Inventory : inventory.values()) {
            if (Inventory.getPrice() >= minPrice && Inventory.getPrice() <= maxPrice) {
                System.out.println(Inventory);
            }
        }
    }

    // Create the addNewProduct method.
    public void addNewProduct() {
        // Ask user for the new product ID.
        System.out.print("Enter product ID: ");
        id = scanner.nextInt();
        scanner.nextLine();

        // Ask user for the new product name.
        System.out.print("Enter product name: ");
        name = scanner.nextLine();

        // Ask user for the new product price.
        System.out.print("Enter product price: ");
        price = scanner.nextDouble();

        // Add the product to the Map.
        newInventory = new Inventory(id, name, price);
        inventory.put(name, newInventory);

        // Print message when added to Map.
        System.out.println("New product added successfully.");
    }
}