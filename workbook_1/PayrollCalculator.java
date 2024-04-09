package workbook_1;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        // Initalize the scanner.
        Scanner scanner = new Scanner(System.in);

        // Tell the user to input their name.
        System.out.println("Please input your name.");
        String name = scanner.next();

        // Tell the user to input their hours worked.
        System.out.println("Please input your hours worked.");
        int hoursWorked = scanner.nextInt();

        // Tell the user to input their pay rate.
        System.out.println("Please input your pay rate.");
        double payRate = scanner.nextDouble();

        // Calculate the gross pay.
        double grossPay = hoursWorked * payRate;

        // Print out the information.
        System.out.println(name + "'s" + " Gross Pay: $" + grossPay);
    }
}
