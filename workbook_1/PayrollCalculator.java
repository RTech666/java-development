package workbook_1;
import java.util.Scanner;

public class PayrollCalculator {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Create the variables.
    static String name;
    static int hoursWorked;
    static double payRate;
    static String overtime;
    static double grossPay;

    public static void main(String[] args) {
        // Tell the user to input their name.
        System.out.println("Please input your name.");
        name = scanner.nextLine();

        // Tell the user to input their hours worked.
        System.out.println("Please input your hours worked.");
        hoursWorked = scanner.nextInt();

        // Tell the user to input their pay rate.
        System.out.println("Please input your pay rate.");
        payRate = scanner.nextDouble();
        scanner.nextLine();

        // Ask user if they worked overtime.
        System.out.println("Did you work overtime this week? (Yes/No)");
        overtime = scanner.nextLine();

        // If user worked overtime.
        if (overtime.equalsIgnoreCase("yes")) {
            didOvertime();
        // If user did not work overtime.
        } else if (overtime.equalsIgnoreCase("no")) {
            noOvertime();
        }

        // Print out gross pay.
        printGrossPay();
    }

    public static void didOvertime() {
        // Ask user how many hours did they work overtime.
        System.out.println("How many hours did you work overtime?");
        int overtimeHours = scanner.nextInt();

        // Calculate the overtime payrate.
        double overtimePayRate = payRate * 1.5;

        // Calculate the total gross pay with the overtime pay + regular pay.
        grossPay = (overtimeHours + overtimePayRate) + (hoursWorked * payRate);
    }

    public static void noOvertime() {
        // Calculate the gross pay.
        grossPay = hoursWorked * payRate;
    }

    // What to print for gross pay.
    public static void printGrossPay() {
        System.out.println(name + "'s" + " Gross Pay: $" + grossPay);
    }
}
