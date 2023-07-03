package payroll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeRepository repository;

    @Test
    public void testNewEmployee_success() {
        Employee emp = new Employee();
        emp.setName("John Doe");
        emp.setRole("developer");
        when(repository.save(any(Employee.class))).thenReturn(emp);

        Employee result = employeeController.newEmployee(emp);
        assertEquals(emp, result);
        verify(repository, times(1)).save(emp);
    }

    @Test
    public void testNewEmployee_failure() {
        Employee emp = new Employee();
        emp.setName("John Doe");
        emp.setRole("developer");
        when(repository.save(any(Employee.class))).thenThrow(new RuntimeException("Exception occurred"));

        try {
            employeeController.newEmployee(emp);
        } catch (Exception e) {
            assertEquals("Exception occurred", e.getMessage());
        }
    }
}
