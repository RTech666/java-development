package workbook_2;
import workbook_2.com.pluralsight.CellPhoneService;
import java.util.Scanner;

public class CellPhoneApplication {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Create the variables.
    static int serialNumber;
    static String model;
    static String carrier;
    static String phoneNumber;
    static String owner;
    static CellPhoneService CellPhone;

    public static void main(String[] args) {
        // Call the enterInformation method.
        enterInformation();

        // Call the parseInformation method.
        parseInformation();

        // Call the printInformation method.
        printInformation();
    }

    // Ask the user to input the information for the phone.
    public static void enterInformation() {
        System.out.print("What is the serial number? ");
        serialNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("What model is the phone? ");
        model = scanner.nextLine();

        System.out.print("Who is the carrier? ");
        carrier = scanner.nextLine();

        System.out.print("What is the phone number? ");
        phoneNumber = scanner.nextLine();

        System.out.print("Who is the owner of the phone? ");
        owner = scanner.nextLine();
    }

    // Create the CellPhone opject from CallPhoneService class.
    public static void parseInformation() {
        CellPhone = new CellPhoneService(serialNumber, model, carrier, phoneNumber, owner);
    }

    // Print out the information provided.
    public static void printInformation() {
        System.out.println("\nPhone Information:");
        System.out.println("Serial Number: " + CellPhone.getSerialNumber());
        System.out.println("Phone Model: " + CellPhone.getModel());
        System.out.println("Carrier: " + CellPhone.getCarrier());
        System.out.println("Phone Number: " + CellPhone.getPhoneNumber());
        System.out.println("Owner: " + CellPhone.getOwner());
    }
}
