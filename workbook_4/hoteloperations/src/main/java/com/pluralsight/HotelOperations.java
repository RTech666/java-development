package com.pluralsight;
import java.text.DecimalFormat;

public class HotelOperations {
    // Set double to print with only 2 decimal places.
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        // Create a room.
        Room room = new Room(2, 139.00);

        // Print room information.
        System.out.println("Number of beds in room: " + room.getNumberOfBeds());
        System.out.println("Price per night: $" + room.getPrice());
        System.out.println("Is room occupied? " + room.isOccupied());
        System.out.println("Is room dirty? " + room.isDirty());
        System.out.println("Is room available? " + room.isAvailable());

        // Create a reservation with weekend stay.
        Reservation reservation = new Reservation("king", 3, true);

        // Print reservation information.
        System.out.println("\nRoom type: " + reservation.getRoomType());
        System.out.println("Price per night: $" + reservation.getPricePerNight());
        System.out.println("Number of nights: " + reservation.getNumberOfNights());
        System.out.println("Is weekend stay? " + reservation.isWeekend());
        System.out.println("Total reservation cost: $" + df.format(reservation.getReservationTotal()));

        // Create employee with overtime hours.
        Employee employee = new Employee(1001, "John Doe", "Engineering", 25.00, 45.5);

        // Print employee information.
        System.out.println("\nEmployee ID: " + employee.getEmployeeId());
        System.out.println("Employee name: " + employee.getName());
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Pay rate: $" + employee.getPayRate() + " per hour");
        System.out.println("Hours worked: " + employee.getHoursWorked() + " hours");
        System.out.println("Gross pay: $" + employee.calculateGrossPay());

        // Overtime payrate calculation.
        double overtimeRate = 1.5 * employee.getPayRate();

        // Overtime pay calculation.
        double overtimePay = employee.calculateOvertimePay(overtimeRate);

        // Print overtime pay.
        System.out.println("Overtime pay: $" + overtimePay);
    }
}
