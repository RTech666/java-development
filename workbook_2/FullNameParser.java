package workbook_2;
import java.util.Scanner;

public class FullNameParser {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Create the variables.
    static String fullName;
    static String firstName, middleName = "", lastName;
    
    public static void main(String[] args) {
        // Call to the enterName method.
        enterName();

        // Call to the parseName method.
        parseName();

        // Call to the printPieces method.
        printPieces();
    }

    // Ask user to enter their name, then trim the spaces.
    public static void enterName() {
        System.out.print("Please enter your name (First Last or First Middle Last): ");
        fullName = scanner.nextLine().trim();
    }

    // Parse the name.
    public static void parseName() {
        // Split the inputed name.
        String[] nameParts = fullName.split("\\s+");

        // If user put First Last.
        if (nameParts.length == 2) {
            firstName = nameParts[0];
            lastName = nameParts[1];
        // If user put First Middle Last.
        } else if (nameParts.length == 3) {
            firstName = nameParts[0];
            middleName = nameParts[1];
            lastName = nameParts[2];
        }
    }

    // Print the pieces of the name.
    public static void printPieces() {
        System.out.println("First Name: " + firstName);

        // If user put a middle name.
        if (!middleName.isEmpty()) {
            System.out.println("Middle Name: " + middleName);
        // If user didn't put a middle name.
        } else if (middleName.isEmpty()) {
            System.out.println("Middle Name: (none)");
        }

        System.out.println("Last Name: " + lastName);
    }
}