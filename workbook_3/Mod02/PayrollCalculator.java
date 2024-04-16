package workbook_3.Mod02;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Create the variables.
    static String fileName = "employees.csv";
    static int employeeId;
    static String name;
    static double hoursWorked;
    static double payRate;
    static boolean firstLine = true;
    static String inputName;
    static String outputName;

    public static void main(String[] args) {
        System.out.print("Enter the name of the file employee file to process: ");
        inputName = scanner.nextLine();

        System.out.print("Enter the name of the payroll file to create: ");
        outputName = scanner.nextLine();

        // Call the parseData method.
        parseData();
    }

    // Create the parseData method.
    public static void parseData() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            List<Employee> employees = new ArrayList<>();
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

                // Add employees to the array.
                employees.add(employee);
            }

            // Create the file in JSON.
            if (outputName.endsWith(".json")) {
                writeJSON(employees, outputName);
            // Create the file in CSV.
            } else {
                writeCSV(employees, outputName);
            }

            System.out.println("Payroll report generated successfully.");
        // Print error message if it cannot read or write to file.
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        // Print error message if it cannot parse data.
        } catch (NumberFormatException e) {
            System.err.println("Error parsing data: " + e.getMessage());
        }
    }
    
    // Create the writeCSV method.
    private static void writeCSV(List<Employee> employees, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Format to write the data in.
            writer.write("id|name|gross pay\n");

            // Write the data.
            for (Employee employee : employees) {
                writer.write(String.format("%d|%s|%.2f\n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay()));
            }
        }
    }

    // Create the writeJSON method.
    private static void writeJSON(List<Employee> employees, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write the [ in the first line.
            writer.write("[\n");

            // Write the data with the proper format.
            for (int i = 0; i < employees.size(); i++) {
                Employee employee = employees.get(i);
                writer.write(String.format("{ \"id\" : %d, \"name\" : \"%s\", \"grossPay\" : %.2f }",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay()));
                if (i < employees.size() - 1) {
                    writer.write(",\n");
                }
            }

            // Write the ] in the last line.
            writer.write("\n]");
        }
    }
}
