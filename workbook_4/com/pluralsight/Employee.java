package workbook_4.com.pluralsight;
import java.time.LocalDateTime;

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

    // Create punchIn method.
    public void punchIn(double time) {
        if (startTime == 0.0) {
            // Set the time, then print out messsage.
            startTime = time;
            System.out.println("Punched in at " + time + " o'clock.");
        // If they already punched in, print message.
        } else {
            System.out.println("Cannot punch in. Already punched in.");
        }
    }

    // Create overloaded punchIn method.
    public void punchIn() {
        // Get the current time and then punch in using the currentTime.
        LocalDateTime now = LocalDateTime.now();
        double currentTime = now.getHour() + now.getMinute() / 60.0;
        punchIn(currentTime);
    }

    // Create punchOut method.
    public void punchOut(double time) {
        if (startTime != 0.0) {
            // Calculate how long they worked for and print out the information.
            double hoursWorkedThisShift = time - startTime;
            hoursWorked += hoursWorkedThisShift;
            System.out.println("Punched out at " + time + " o'clock. Worked " + hoursWorkedThisShift + " hours this shift.");

            // Reset time.
            startTime = 0.0;
        // If they never punched in, print message.
        } else {
            System.out.println("Cannot punch out. Not punched in.");
        }
    }

    // Create overloaded punchOut method.
    public void punchOut() {
        // Get the current time and then punch out using the currentTime.
        LocalDateTime now = LocalDateTime.now();
        double currentTime = now.getHour() + now.getMinute() / 60.0;
        punchOut(currentTime);
    }
}