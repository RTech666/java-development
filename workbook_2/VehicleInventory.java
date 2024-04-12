package workbook_2;
import java.util.Scanner;

class Vehicle {
    // Create the variables, as private.
    private long vehicleId;
    private String makeModel;
    private String color;
    private int odometerReading;
    private float price;

    // Create the constrcutor.
    public Vehicle(long vehicleId, String makeModel, String color, int odometerReading, float price) {
        this.vehicleId = vehicleId;
        this.makeModel = makeModel;
        this.color = color;
        this.odometerReading = odometerReading;
        this.price = price;
    }

    // Create the setter and getters.
    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(int odometerReading) {
        this.odometerReading = odometerReading;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

public class VehicleInventory {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Create the variables.
    public static final int MAX_VEHICLES = 20;
    public static final int INITIAL_VEHICLE_COUNT = 6;

    // Create the array.
    public static Vehicle[] vehicles = new Vehicle[MAX_VEHICLES];
    public static int vehicleCount = INITIAL_VEHICLE_COUNT;

    public static void main(String[] args) {
        // Call the preloadVehicles method.
        preloadVehicles();

        // Call the userCommands method.
        userCommands();
    }

    // Create the prealoadVehicles method.
    public static void preloadVehicles() {
        // Preload the vehicles into the array.
        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        vehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        vehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);
    }

    // Create the userCommands method.
    public static void userCommands() {
        // Ask the user what they would like to do.
        System.out.println("What do you want to do?");
        System.out.println("1 - List all vehicles");
        System.out.println("2 - Search by make/model");
        System.out.println("3 - Search by price range");
        System.out.println("4 - Search by color");
        System.out.println("5 - Add a vehicle");
        System.out.println("6 - Quit");
        System.out.print("Enter your command: ");
        int command = scanner.nextInt();
        scanner.nextLine();

        // Read the user input and execute the appropiate method.
        switch (command) {
            case 1:
                listAllVehicles();
                break;
            case 2:
                searchByMakeModel(scanner);
                break;
            case 3:
                searchByPrice(scanner);
                break;
            case 4:
                searchByColor(scanner);
                break;
            case 5:
                addAVehicle(scanner);
                break;
            case 6:
                return;
        }
    }

    // Create the listAllVehicles method.
    public static void listAllVehicles() {
        // Read the array, create the list of vehicles, and print it.
        for (int i = 0; i < vehicleCount; i++) {
            Vehicle vehicle = vehicles[i];
            System.out.println("Vehicle ID: " + vehicle.getVehicleId());
            System.out.println("Make/Model: " + vehicle.getMakeModel());
            System.out.println("Color: " + vehicle.getColor());
            System.out.println("Odometer Reading: " + vehicle.getOdometerReading());
            System.out.println("Price: $" + vehicle.getPrice());
            System.out.println("");
        }
    }

    // Create the searchByMakeModel method.
    public static void searchByMakeModel(Scanner scanner) {
        // Ask the user to enter the make/model they want to search for.
        System.out.print("Enter make/model to search: ");
        String makeModel = scanner.nextLine();

        // Create the variable.
        boolean found = false;

        // Search for the vehicle in the array and print the information for the found vehicle.
        for (int i = 0; i < vehicleCount; i++) {
            Vehicle vehicle = vehicles[i];
            if (vehicle.getMakeModel().equalsIgnoreCase(makeModel)) {
                System.out.println("Vehicle found:");
                System.out.println("Vehicle ID: " + vehicle.getVehicleId());
                System.out.println("Make/Model: " + vehicle.getMakeModel());
                System.out.println("Color: " + vehicle.getColor());
                System.out.println("Odometer Reading: " + vehicle.getOdometerReading());
                System.out.println("Price: $" + vehicle.getPrice());
                System.out.println();
                found = true;
            }
        }

        // If the search didn't find the make/model in the array, print error.
        if (!found) {
            System.out.println("No vehicles found with the given make/model.");
        }
    }

    // Create searchByPrice method.
    public static void searchByPrice(Scanner scanner) {
        // Ask the user to enter their price range.
        System.out.print("Enter minimum price: $");
        float minPrice = scanner.nextFloat();

        System.out.print("Enter maximum price: $");
        float maxPrice = scanner.nextFloat();
        
        // Create the variable.
        boolean found = false;

        // Search for vehicles in the array that fit into the user's price range.
        for (int i = 0; i < vehicleCount; i++) {
            Vehicle vehicle = vehicles[i];
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                System.out.println("Vehicle found:");
                System.out.println("Vehicle ID: " + vehicle.getVehicleId());
                System.out.println("Make/Model: " + vehicle.getMakeModel());
                System.out.println("Color: " + vehicle.getColor());
                System.out.println("Odometer Reading: " + vehicle.getOdometerReading());
                System.out.println("Price: $" + vehicle.getPrice());
                System.out.println();
                found = true;
            }
        }
        
        // If no vehicles in the array fits the user's price range, print error.
        if (!found) {
            System.out.println("No vehicles found within the specified price range.");
        }
    }

    // Create searchByColor method.
    public static void searchByColor(Scanner scanner) {
        // Ask the user what color they want to search for.
        System.out.print("Enter color to search: ");
        String colorToSearch = scanner.next();
        
        // Create the variable.
        boolean found = false;

        // Find the vehicle with the entered color in the array.
        for (int i = 0; i < vehicleCount; i++) {
            Vehicle vehicle = vehicles[i];
            if (vehicle.getColor().equalsIgnoreCase(colorToSearch)) {
                System.out.println("Vehicle found:");
                System.out.println("Vehicle ID: " + vehicle.getVehicleId());
                System.out.println("Make/Model: " + vehicle.getMakeModel());
                System.out.println("Color: " + vehicle.getColor());
                System.out.println("Odometer Reading: " + vehicle.getOdometerReading());
                System.out.println("Price: $" + vehicle.getPrice());
                System.out.println();
                found = true;
            }
        }
        
        // If no vehicles in the array matches the entered color, print error.
        if (!found) {
            System.out.println("No vehicles found with the specified color.");
        }
    }

    // Create the addAVehicle method.
    public static void addAVehicle(Scanner scanner) {
        // If their is 20 vehicles already in the array, print error.
        if (vehicleCount >= MAX_VEHICLES) {
            System.out.println("Cannot add more vehicles. Inventory is full.");
            return;
        }

        // Ask user to enter the information of the vehicle they want to add.
        System.out.print("Enter vehicle ID: ");
        long vehicleId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter make/model: ");
        String makeModel = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter odometer reading: ");
        int odometerReading = scanner.nextInt();

        System.out.print("Enter price: ");
        float price = scanner.nextFloat();

        // Add the vehicle to the array.
        vehicles[vehicleCount++] = new Vehicle(vehicleId, makeModel, color, odometerReading, price);
        System.out.println("Vehicle added successfully.");
        listAllVehicles();
    }
}
