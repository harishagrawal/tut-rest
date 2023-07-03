package payroll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class Employee_getIdecd3bcfdc5Test {

    @MockBean
    private Employee employee;

    @Test
    public void testGetIdSuccess() {
        Long expectedId = 123L;
        Mockito.when(employee.getId()).thenReturn(expectedId);
        Long actualId = employee.getId();
        assertEquals(expectedId, actualId, "Returned ID should match the expected ID.");
    }

    @Test
    public void testGetIdFailure() {
        Long unexpectedId = 456L;
        Mockito.when(employee.getId()).thenReturn(123L);
        Long actualId = employee.getId();
        assertNotEquals(unexpectedId, actualId, "Returned ID should not match the unexpected ID.");
    }

    @Test
    public void testGetIdNull() {
        Mockito.when(employee.getId()).thenReturn(null);
        assertNull(employee.getId(), "Returned ID should be null.");
    }
}
