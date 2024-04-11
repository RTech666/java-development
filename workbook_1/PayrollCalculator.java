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

    public static void main(String[] args) {
        // Tell the user to input their name.
        System.out.println("Please input your name.");
        String name = scanner.nextLine();

        // Tell the user to input their hours worked.
        System.out.println("Please input your hours worked.");
        int hoursWorked = scanner.nextInt();

        // Tell the user to input their pay rate.
        System.out.println("Please input your pay rate.");
        double payRate = scanner.nextDouble();
        scanner.nextLine();

        // Ask user if they worked overtime.
        System.out.println("Did you work overtime this week? (Yes/No)");
        String overtime = scanner.nextLine();

        if (overtime.equalsIgnoreCase("yes")) {
            didOvertime();
        } else if (overtime.equalsIgnoreCase("no")) {
            noOvertime();
        }
    }

    public static void didOvertime() {
        // Ask user how many hours did they work overtime.
        System.out.println("How many hours did you work overtime?");
        int overtimeHours = scanner.nextInt();

        // Calculate the overtime payrate.
        double overtimePayRate = payRate * 1.5;

        // Calculate the total gross pay with the overtime pay + regular pay.
        double grossPay = (overtimeHours + overtimePayRate) + (hoursWorked * payRate);

        // Print out the information if user worked overtime.
        System.out.println(name + "'s" + " Gross Pay: $" + grossPay);
    }

    public static void noOvertime() {
        // Calculate the gross pay.
        double grossPay = hoursWorked * payRate;

        // Print out the information if user didn't work overtime.
        System.out.println(name + "'s" + " Gross Pay: $" + grossPay);
    }
}
