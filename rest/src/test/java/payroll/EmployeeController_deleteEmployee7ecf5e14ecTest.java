package payroll;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeControllerDeleteEmployeeTest {

    @InjectMocks
    EmployeeController employeeController;

    @Mock
    EmployeeRepository repository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeleteEmployee_success() {
        Long id = 1L;
        Employee employee = new Employee();
        employee.setName("John");
        employee.setRole("Doe");
        employee.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(employee));

        employeeController.deleteEmployee(id);

        verify(repository, times(1)).deleteById(id);
    }

    @Test
    public void testDeleteEmployee_failure() {
        Long id = 1L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        try {
            employeeController.deleteEmployee(id);
        } catch (EmployeeNotFoundException ex) {
            // Expected exception
        }

        verify(repository, times(0)).deleteById(id);
    }
}
