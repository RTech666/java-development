package workbook_2;
import workbook_2.com.pluralsight.CellPhone;
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
    static String dial;
    static CellPhone phone;

    public static void main(String[] args) {
        // First enterInformation gets saved as cellPhone1.
        enterInformation();
        parseInformation();
        CellPhone cellPhone1 = phone;

        // Second enterInformation gets saved as cellPhone2
        enterInformation();
        parseInformation();
        CellPhone cellPhone2 = phone;

        // Show the information for both phones.
        display(cellPhone1);
        display(cellPhone2);

        // Dial the phones.
        cellPhone1.dial(cellPhone2.getPhoneNumber());
        cellPhone2.dial(cellPhone1.getPhoneNumber());
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
        phone = new CellPhone(serialNumber, model, carrier, phoneNumber, owner);
    }

    // Print out the information provided.
    public static void display(CellPhone phone) {
        System.out.println("\nPhone Information:");
        System.out.println("Serial Number: " + phone.getSerialNumber());
        System.out.println("Phone Model: " + phone.getModel());
        System.out.println("Carrier: " + phone.getCarrier());
        System.out.println("Phone Number: " + phone.getPhoneNumber());
        System.out.println("Owner: " + phone.getOwner() + "\n");
    }

}
