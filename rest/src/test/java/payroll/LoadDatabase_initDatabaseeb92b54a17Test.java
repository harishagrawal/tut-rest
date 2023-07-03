// Corrected Test Case:

package payroll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class LoadDatabaseInitDatabaseTest {

    @InjectMocks
    private LoadDatabase loadDatabase;

    @Mock
    private EmployeeRepository repository;

    @BeforeEach
    public void setUp() {
        when(repository.save(any(Employee.class))).thenAnswer(i -> i.getArguments()[0]);
    }

    @Test
    public void testInitDatabase_Success() throws Exception {
        CommandLineRunner runner = loadDatabase.initDatabase(repository);
        runner.run();

        verify(repository, times(2)).save(any(Employee.class));
    }

    @Test
    public void testInitDatabase_Failure() throws Exception {
        when(repository.save(any(Employee.class))).thenThrow(new RuntimeException());

        CommandLineRunner runner = loadDatabase.initDatabase(repository);

        try {
            runner.run();
        } catch (Exception e) {
            // Expected exception
        }

        verify(repository, times(1)).save(any(Employee.class));
    }
}
