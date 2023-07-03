// Regenerated test case

package payroll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Employee_hashCode9d4c18a96dTest {

    private Employee employee1;
    private Employee employee2;
    private Employee employee3;

    @BeforeEach
    public void setUp() {
        employee1 = new Employee();
        employee1.setId(1L);
        employee1.setName("John Doe");
        employee1.setRole("Developer");

        employee2 = new Employee();
        employee2.setId(1L);
        employee2.setName("John Doe");
        employee2.setRole("Developer");

        employee3 = new Employee();
        employee3.setId(2L);
        employee3.setName("Jane Doe");
        employee3.setRole("Manager");
    }

    @Test
    public void testHashCode_sameObject() {
        int expected = employee1.hashCode();
        int actual = employee1.hashCode();
        assertEquals(expected, actual, "Hash codes of same object should be equal");
    }

    @Test
    public void testHashCode_differentObjectsSameData() {
        int expected = employee1.hashCode();
        int actual = employee2.hashCode();
        assertEquals(expected, actual, "Hash codes of different objects with same data should be equal");
    }

    @Test
    public void testHashCode_differentObjectsDifferentData() {
        int expected = employee1.hashCode();
        int actual = employee3.hashCode();
        assertEquals(expected, actual, "Hash codes of different objects with different data should not be equal");
    }
}
