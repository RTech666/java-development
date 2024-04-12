package workbook_2;
import java.util.Scanner;

class CellPhone {
    // Create the variables, as private.
    private int serialNumber = 0;
    private String model = "";
    private String carrier = "";
    private String phoneNumber = "";
    private String owner = "";

    // Create the constrcutor.
    public CellPhone(int serialNumber, String model, String carrier, String phoneNumber, String owner) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.carrier = carrier;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }

    // Create the setter and getters.
    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return this.owner;
    }

    // Create the dial method.
    public void dial(String phoneNumber) {
        System.out.println(owner + "'s phone is calling " + phoneNumber);
    }

    // Create the overloaded dial method.
    public void dial(CellPhone phone) {
        System.out.println(owner + "'s phone is calling " + phone.getPhoneNumber());
    }
}

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

        // Second enterInformation gets saved as cellPhone2.
        enterInformation();
        parseInformation();
        CellPhone cellPhone2 = phone;

        // Third enterInformation gets saved as newPhone.
        enterInformation();
        parseInformation();
        CellPhone newPhone = phone;

        // Show the information for both phones.
        display(cellPhone1);
        display(cellPhone2);
        display(newPhone);

        // Dial the phones.
        cellPhone1.dial(cellPhone2.getPhoneNumber());
        cellPhone2.dial(cellPhone1.getPhoneNumber());

        // Calls the overloaded dial method. Dials newPhone using cellPhone1
        dialNewPhone(newPhone, cellPhone1);
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

    // Create the overloaded dial method.
    public static void dialNewPhone(CellPhone newPhone, CellPhone callingPhone) {
        callingPhone.dial(newPhone);
    }
}