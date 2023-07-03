import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {
    @Test
    public void testSetRole() {
        Employee employee = new Employee();
        String role = "Manager";
        employee.setRole(role);
        assertEquals(role, employee.getRole());
    }

    @Test(expected = NullPointerException.class)
    public void testSetRoleNull() {
        Employee employee = new Employee();
        employee.setRole(null);
    }
}
