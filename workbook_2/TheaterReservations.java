package workbook_2;
import java.util.Scanner;

public class TheaterReservations {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Create the variables.
    static String name;
    static String date;
    static int tickets;
    static String firstName;
    static String lastName;
    static int year;
    static int month;
    static int day;

    public static void main(String[] args) {
        // Call the enterName method.
        enterName();

        // Call the enterDate method.
        enterDate();

        // Call the enterTickets method.
        enterTickets();

        // Call the parseInputs method.
        parseInputs();

        // Call the printInformation method.
        printInformation();
    }

    // Ask user to input their name.
    public static void enterName() {
        System.out.print("Please enter your name: ");
        name = scanner.nextLine();
    }

    // Ask user to input the date they will be comming.
    public static void enterDate() {
        System.out.print("What date will you be coming (MM/DD/YYYY): ");
        date = scanner.nextLine();
    }

    // Ask user to input many tickets they want.
    public static void enterTickets() {
        System.out.print("How many tickets would you like?: ");
        tickets = scanner.nextInt();
    }

    // Parse the input.
    public static void parseInputs() {
        // Split the name into two parts.
        String[] ticketName = name.split(" ");
        firstName = ticketName[0];
        lastName = ticketName[1];
        // Put it in last name, first name format.
        name = lastName + ", " + firstName;

        // Split the date into parts.
        String[] ticketDate = date.split("/");
        day = Integer.parseInt(ticketDate[0]);
        month = Integer.parseInt(ticketDate[1]);
        year = Integer.parseInt(ticketDate[2]);
        // Put it in the YYYY-MM-DD format.
        date = year + "-" + month + "-" + day;
    }

    // Print out the reservation information.
    public static void printInformation() {
        // If user is reserving 1 ticket.
        if (tickets == 1) {
            System.out.println(tickets + " ticket reserved for " + date + " under " + name);
        }

        // If user is reserving more than 1 ticket.
        if (tickets > 1) {
            System.out.println(tickets + " tickets reserved for " + date + " under " + name);
        }
    }
}
