package workbook_1;
import java.util.Scanner;
import java.text.DecimalFormat;

public class SandwichShop {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Set double to print with only 2 decimal places.
    private static final DecimalFormat df = new DecimalFormat("0.00");

    // Create the variables.
    static double regularSandwich = 5.45;
    static double largeSandwich = 8.95;
    static double total;
    static double discount;
    static int sandwichSize;
    static String loaded;
    static int age;

    public static void main(String[] args) {
        // Ask the user what size sandwich they want.
        System.out.println("What size sandwich would you like?");
        System.out.println("1: Regular");
        System.out.println("2: Large");
        sandwichSize = scanner.nextInt();

        // Ask the user if they want the sandwich "loaded".
        System.out.println("Would you like a loaded sandwich? (Yes/No)");
        loaded = scanner.nextLine();

        // Ask the user how old they are.
        System.out.print("How old are you? ");
        age = scanner.nextInt();

        // If user chose a regular sandwich.
        if (sandwichSize == 1) {
            // If user wants it loaded.
            if (loaded.equalsIgnoreCase("yes")) {
                // If user's age is 17 or younger.
                if (age <= 17) {
                    underageLoadedRegular();

                // If user's age is 65 or older.
                } else if (age >= 65) {
                    seniorLoadedRegular();
                }
            // If user doesn't want it loaded.
            } else if (loaded.equalsIgnoreCase("no")) {
                // If user's age is 17 or younger.
                if (age <= 17) {
                    underageRegular();

                // If user's age is 65 or older.
                } else if (age >= 65) {
                    seniorRegular();
                }
            }  
        // If user wants a large sandwich.
        } else if (sandwichSize == 2) {
            // If user wants it loaded.
            if (loaded.equalsIgnoreCase("yes")) {
                // If user's age is 17 or younger.
                if (age <= 17) {
                    underageLoadedLarge();

                // If user's age is 65 or older.
                } else if (age >= 65) {
                    seniorLoadedLarge();
                }
            // If user doesn't want it loaded.
            } else if (loaded.equalsIgnoreCase("no")) {
                // If user's age is 17 or younger.
                if (age <= 17) {
                    underageLarge();
                // If user's age is 65 or older.
                } else if (age >= 65) {
                    seniorLarge();
                }
            }
        }
    }

    public static void underageLoadedRegular() {
        // Calculate the discount.
        discount = regularSandwich * .10;
                    
        // Calculate the total with the discount.
        total = regularSandwich + 1 - discount;
        
        // Print out the total with the discount.
        System.out.println("The total is: $" + df.format(total));
    }

    public static void underageRegular() {
        // Calculate the discount.
        discount = regularSandwich * .10;
                    
        // Calculate the total with the discount.
        total = regularSandwich - discount;
        
        // Print out the total with the discount.
        System.out.println("The total is: $" + df.format(total));
    }

    public static void underageLoadedLarge() {
        // Calculate the discount.
        discount = largeSandwich * .10;
                    
        // Calculate the total with the discount.
        total = largeSandwich + 1.75 - discount;
        
        // Print out the total with the discount.
        System.out.println("The total is: $" + df.format(total));
    }

    public static void underageLarge() {
        // Calculate the discount.
        discount = largeSandwich * .10;
                    
        // Calculate the total with the discount.
        total = largeSandwich - discount;
        
        // Print out the total with the discount.
        System.out.println("The total is: $" + df.format(total));
    }

    public static void seniorLoadedRegular() {
        // Calculate the discount.
        discount = regularSandwich * .20;
                    
        // Calculate the total with the discount.
        total = regularSandwich + 1 - discount;
        
        // Print out the total with the discount.
        System.out.println("The total is: $" + df.format(total));
    }

    public static void seniorRegular() {
        // Calculate the discount.
        discount = regularSandwich * .20;
                    
        // Calculate the total with the discount.
        total = regularSandwich - discount;
        
        // If user's age is 65 or older.
        System.out.println("The total is: $" + df.format(total));
    }

    public static void seniorLoadedLarge() {
        // Calculate the discount.
        discount = largeSandwich * .20;
                    
        // Calculate the total with the discount.
        total = largeSandwich + 1.75 - discount;
        
        // Print out the total with the discount.
        System.out.println("The total is: $" + df.format(total));
    }

    public static void seniorLarge() {
        // Calculate the discount.
        discount = largeSandwich * .20;
                    
        // Calculate the total with the discount.
        total = largeSandwich - discount;
        
        // If user's age is 65 or older.
        System.out.println("The total is: $" + df.format(total));
    }
}
