package workbook_1;
import java.util.Scanner;
import java.text.DecimalFormat;

public class SandwichShop {
    // Set doubel to print with only 2 decimal places.
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

        // Ask the user how old they are.
        System.out.print("How old are you? ");
        int age = scanner.nextInt();

        if (sandwichSize == 1) {
            if (age <= 17) {
                discount = regularSandwich * .10;

                total = regularSandwich - discount;

                System.out.println("The total is: $" + df.format(total));
            } else if (age >= 65) {
                discount = regularSandwich * .20;

                total = regularSandwich - discount;

                System.out.println("The total is: $" + df.format(total));
            }
        } else if (sandwichSize == 2) {
            if (age <= 17) {
                discount = largeSandwich * .10;

                total = largeSandwich - discount;

                System.out.println("The total is: $" + df.format(total));
            } else if (age >= 65) {
                discount = largeSandwich * .20;

                total = largeSandwich - discount;

                System.out.println("The total is: $" + df.format(total));
            }
        }
    }
}
