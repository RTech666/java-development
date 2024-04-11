package workbook_2.com.pluralsight;
import java.util.Scanner;

public class FullNameApplication {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Create the variables.
    static String firstName;
    static String middleName;
    static String lastName;
    static String suffix;

    public static void main(String[] args) {
        // Ask them to enter their name.
        System.out.println("Please enter your name:");

        // Call the askFirstName method.
        askFirstName();
        
        // Call the askMiddleName method.
        askMiddleName();

        // Call the askLastName method.
        askLastname();

        // Call the askSuffix method.
        askSuffix();

        // Call the printFullName method.
        printFullName();
    }

    // Ask them to enter their first name.
    public static void askFirstName() {
        System.out.print("First Name: ");
        firstName = scanner.nextLine();
    }

    // Ask them to enter their middle name.
    public static void askMiddleName() {
        System.out.print("Middle Name: ");
        middleName = scanner.nextLine();
    }

    // Ask them to enter their last name.
    public static void askLastname() {
        System.out.print("Last Name: ");
        lastName = scanner.nextLine();
    }

    // Ask them to enter their suffix.
    public static void askSuffix() {
        System.out.print("Suffix: ");
        suffix = scanner.nextLine();
    }

    // Print out their full name.
    public static void printFullName() {
        // Initialize StringBuilder.
        StringBuilder nameBuilder = new StringBuilder();

        // Tell StringBuilder how to format the name.
        nameBuilder.append(firstName).append(" ").append(lastName);

        // If user didn't put a middle name.
        if(!middleName.isEmpty()) {
            nameBuilder.insert(firstName.length() + 1, middleName + " ");
        }

        // If user didn't put a suffix.
        if (!suffix.isEmpty()) {
            nameBuilder.append(", ").append(suffix);
        }

        // Initalize the variable that will hold the name.
        String fullName = nameBuilder.toString();

        // Print out the full name.
        System.out.println("Full Name: " + fullName);
    }
}