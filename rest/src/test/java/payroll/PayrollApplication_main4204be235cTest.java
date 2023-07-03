package payroll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PayrollApplicationMainTest {
    
    @MockBean
    private SpringApplication springApplication;

    @BeforeEach
    public void setUp() {
        Mockito.when(springApplication.run(PayrollApplication.class, new String[]{})).thenReturn(null);
    }

    @Test
    public void testMain_success() {
        PayrollApplication.main(new String[]{});
        Mockito.verify(springApplication, Mockito.times(1)).run(PayrollApplication.class, new String[]{});
    }

    @Test
    public void testMain_failure() {
        Mockito.doThrow(new RuntimeException()).when(springApplication).run(PayrollApplication.class, new String[]{"error"});
        try {
            PayrollApplication.main(new String[]{"error"});
        } catch (Exception e) {
            Mockito.verify(springApplication, Mockito.times(1)).run(PayrollApplication.class, new String[]{"error"});
        }
    }
}
