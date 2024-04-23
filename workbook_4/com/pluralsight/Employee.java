package workbook_4.com.pluralsight;

public class Employee {
    // Create the variables, as private.
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    // Create the constrcutor.
    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    // Create the getters and setters.
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // Create derived getters
    public double calculateGrossPay() {
        return payRate * hoursWorked;
    }
    
    public double calculateOvertimePay(double overtimeRate) {
        // Hours up to 20 are regular hours
        double regularHours = Math.min(hoursWorked, 20);

        // Hours exceeding 20 are overtime
        double overtimeHours = Math.max(hoursWorked - 20, 0);
        return (regularHours * payRate) + (overtimeHours * overtimeRate);
    }
}
