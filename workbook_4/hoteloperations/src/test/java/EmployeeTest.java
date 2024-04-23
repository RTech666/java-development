import static org.junit.Assert.*;
import org.junit.Test;
import com.pluralsight.Employee;

public class EmployeeTest {
    // Create testPunchIn test method.
    @Test
    public void testPunchIn() {
        // Create employee.
        Employee employee = new Employee(1001, "John Doe", "Engineering", 25.00, 0.0);

        // Punch in at 8AM.
        employee.punchIn(8.0);

        // Verify the startTime.
        assertEquals(8.0, employee.startTime, 0.01);
    }

    // Create testPunchOut test method.
    @Test
    public void testPunchOut() {
        // Create employee.
        Employee employee = new Employee(1001, "John Doe", "Engineering", 25.00, 0.0);

        // Punch in at 8AM.
        employee.startTime = 8.0; // Simulate punching in at 8:00 am

        // Punch out at 5:30PM
        employee.punchOut(17.5);

        // Verify the hoursWorked.
        assertEquals(9.5, employee.hoursWorked, 0.01);
    }

    // Create testPunchOutWithoutIn test method.
    @Test
    public void testPunchOutWithoutIn() {
        // Create employee.
        Employee employee = new Employee(1001, "John Doe", "Engineering", 25.00, 0.0);

        // Punch out without punching in.
        employee.punchOut(17.5);

        // Verify the hoursWorked.
        assertEquals(0.0, employee.hoursWorked, 0.01);
    }

    // Create testPunchInOutCurrent test method.
    @Test
    public void testPunchInOutCurrent() {
        // Create employee.
        Employee employee = new Employee(1001, "John Doe", "Engineering", 25.00, 0.0);

        // Punch in at current time.
        employee.punchIn();

        // Punch out at current time.
        employee.punchOut();

        // Verify the hoursWorked.
        assertTrue(employee.hoursWorked > 0);
    }

}