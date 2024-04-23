package workbook_4.com.pluralsight;

public class Employee {
    // Create the variables, as private.
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double startTime;

    // Create the constrcutor.
    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = 0.0;
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

    // Create punchTimeCard method.
    public void punchTimeCard(double time) {
        if (startTime == 0.0) {
            // Set start time and print out message.
            startTime = time;
            System.out.println("Punched in at " + time + " o'clock.");
        } else {
            // Calculate how many hours they worked.
            double hoursWorkedThisShift = time - startTime;
            hoursWorked += hoursWorkedThisShift;

            // Print message.
            System.out.println("Punched out at " + time + " o'clock. Worked " + hoursWorkedThisShift + " hours this shift.");

            // Reset time.
            startTime = 0.0;
        }
    }
}
