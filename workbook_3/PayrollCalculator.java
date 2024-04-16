package workbook_3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Employee {
    // Create the variables, as private.
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    // Create the constrcutor.
    public Employee(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    // Create the setter and getters.
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    // Create getGrossPay method. Used to calculate gross pay.
    public double getGrossPay() {
        return hoursWorked * payRate;
    }
}

public class PayrollCalculator {
    // Create the variables.
    static String fileName = "employees.csv";
    static int employeeId;
    static String name;
    static double hoursWorked;
    static double payRate;
    static boolean firstLine = true;

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Skip the first line of the file.
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Split the lines.
                String[] tokens = line.split("\\|");

                // Set the values from the token.
                employeeId = Integer.parseInt(tokens[0]);
                name = tokens[1];
                hoursWorked = Double.parseDouble(tokens[2]);
                payRate = Double.parseDouble(tokens[3]);

                // Create a new employee.
                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                // Print employee information.
                System.out.printf("Employee ID: %d, Name: %s, Gross Pay: $%.2f%n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }
        // If file is not found, print error.
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
