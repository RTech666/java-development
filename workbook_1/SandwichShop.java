package workbook_1;
import java.util.Scanner;
import java.text.DecimalFormat;

public class SandwichShop {
    // Set double to print with only 2 decimal places.
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        // Create the variables.
        double regularSandwich = 5.45;
        double largeSandwich = 8.95;
        double total;
        double discount;

        // Initalize the scanner.
        Scanner scanner = new Scanner(System.in);

        // Ask the user what size sandwich they want.
        System.out.println("What size sandwich would you like?");
        System.out.println("1: Regular");
        System.out.println("2: Large");
        int sandwichSize = scanner.nextInt();

        // Ask the user if they want the sandwich "loaded".
        System.out.println("Would you like a loaded sandwich? (Yes/No)");
        String loaded = scanner.nextLine();

        // Ask the user how old they are.
        System.out.print("How old are you? ");
        int age = scanner.nextInt();

        // If user chose a regular sandwich.
        if (sandwichSize == 1) {
            // If user wants it loaded.
            if (loaded.equalsIgnoreCase("yes")) {
                // If user's age is 17 or younger.
                if (age <= 17) {
                    // Calculate the discount.
                    discount = regularSandwich * .10;
                    
                    // Calculate the total with the discount.
                    total = regularSandwich + 1 - discount;
                    
                    // Print out the total with the discount.
                    System.out.println("The total is: $" + df.format(total));

                // If user's age is 65 or older.
                } else if (age >= 65) {
                    // Calculate the discount.
                    discount = regularSandwich * .20;
                    
                    // Calculate the total with the discount.
                    total = regularSandwich + 1 - discount;
                    
                    // Print out the total with the discount.
                    System.out.println("The total is: $" + df.format(total));
                }
            // If user doesn't want it loaded.
            } else if (loaded.equalsIgnoreCase("no")) {
                // If user's age is 17 or younger.
                if (age <= 17) {
                    // Calculate the discount.
                    discount = regularSandwich * .10;
                    
                    // Calculate the total with the discount.
                    total = regularSandwich - discount;
                    
                    // Print out the total with the discount.
                    System.out.println("The total is: $" + df.format(total));

                // If user's age is 65 or older.
                } else if (age >= 65) {
                    // Calculate the discount.
                    discount = regularSandwich * .20;
                    
                    // Calculate the total with the discount.
                    total = regularSandwich - discount;
                    
                    // If user's age is 65 or older.
                    System.out.println("The total is: $" + df.format(total));
                }
            }  
        // If user wants a large sandwich.
        } else if (sandwichSize == 2) {
            // If user wants it loaded.
            if (loaded.equalsIgnoreCase("yes")) {
                // If user's age is 17 or younger.
                if (age <= 17) {
                    // Calculate the discount.
                    discount = largeSandwich * .10;
                    
                    // Calculate the total with the discount.
                    total = largeSandwich + 1.75 - discount;
                    
                    // Print out the total with the discount.
                    System.out.println("The total is: $" + df.format(total));

                // If user's age is 65 or older.
                } else if (age >= 65) {
                    // Calculate the discount.
                    discount = largeSandwich * .20;
                    
                    // Calculate the total with the discount.
                    total = largeSandwich + 1.75 - discount;
                    
                    // Print out the total with the discount.
                    System.out.println("The total is: $" + df.format(total));
                }
            // If user doesn't want it loaded.
            } else if (loaded.equalsIgnoreCase("no")) {
                // If user's age is 17 or younger.
                if (age <= 17) {
                    // Calculate the discount.
                    discount = largeSandwich * .10;
                    
                    // Calculate the total with the discount.
                    total = largeSandwich - discount;
                    
                    // Print out the total with the discount.
                    System.out.println("The total is: $" + df.format(total));
                // If user's age is 65 or older.
                } else if (age >= 65) {
                    // Calculate the discount.
                    discount = largeSandwich * .20;
                    
                    // Calculate the total with the discount.
                    total = largeSandwich - discount;
                    
                    // If user's age is 65 or older.
                    System.out.println("The total is: $" + df.format(total));
                }
            }
        }
    }
}
