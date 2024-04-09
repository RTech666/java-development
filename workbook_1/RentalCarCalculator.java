package workbook_1;
import java.util.Scanner;
import java.text.DecimalFormat;

public class RentalCarCalculator {
    // Set double to print with only 2 decimal places.
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        // Create the variables.
        double tagPrice = 3.95;
        double gpsPrice = 2.95;
        double roadsidePrice = 3.95;
        double rentalPrice = 29.99;
        double underageRate = .30;
        double optionsTotal = 0;
        double underageTotal = 0;

        // Initalize the scanner.
        Scanner scanner = new Scanner(System.in);

        // Ask the user the pickup date.
        System.out.println("What is the pickup date? (MM/DD/YYYY)");
        String pickupDate = scanner.nextLine();

        // Ask the user how many days they want to rent.
        System.out.println("How many days do you want to rent for?");
        int rentDays = scanner.nextInt();

        // Ask the user if they want an electronic toll tag.
        System.out.println("Do you want an electronic toll tag at $3.95/day? (Yes/No)");
        String tollTag = scanner.nextLine();
        scanner.nextLine();

        // Ask the user if they want a GPS.
        System.out.println("Do you want a GPS at $2.95/day? (Yes/No)");
        String gps = scanner.nextLine();

        // Ask the user if they want roadside assistance.
        System.out.println("Do you want roadside assistance at $3.95/day? (Yes/No)");
        String roadside = scanner.nextLine();

        // Ask the user their age.
        System.out.println("What is your age?");
        int age = scanner.nextInt();

        // Calculate car rental without any options.
        double noOptionsRental = rentalPrice * rentDays;

        // Calculate electronic toll tag total if user said yes.
        if (tollTag.equalsIgnoreCase("yes")) {
            optionsTotal += tagPrice * rentDays;
        }

        // Calculate GPS total if user said yes.
        if (gps.equalsIgnoreCase("yes")) {
            optionsTotal += gpsPrice * rentDays;
        }

        // Calculate roadside assistance total if user said yes.
        if (roadside.equalsIgnoreCase("yes")) {
            optionsTotal += roadsidePrice * rentDays;
        }

        // Calculate underage surcharge if user is 25 or younger.
        if (age <= 25) {
            underageTotal = rentalPrice * underageRate;
        }

        // Calculate total cost of the rental.
        double totalCost = rentalPrice + optionsTotal + underageTotal;

        // Print out the calculations.
        System.out.println("Rental Summary:");
        System.out.println("Basic Car Rental Cost: $" + df.format(rentalPrice));
        System.out.println("Total Options Cost: $" + df.format(optionsTotal));
        System.out.println("Underage Driver Surcharge Cost: $" + df.format(underageTotal));
        System.out.println("Total Cost: $" + df.format(totalCost));
    }
}
