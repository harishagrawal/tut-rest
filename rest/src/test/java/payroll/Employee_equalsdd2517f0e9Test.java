package payroll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    @Test
    public void testSetRole() {
        Employee employee = new Employee();
        employee.setRole("Manager");
        assertEquals("Manager", employee.getRole());
    }

    @Test
    public void testEquals() {
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setName("John");
        employee1.setRole("Manager");

        Employee employee2 = new Employee();
        employee2.setId(1L);
        employee2.setName("John");
        employee2.setRole("Manager");

        assertEquals(employee1, employee2);
    }
}
