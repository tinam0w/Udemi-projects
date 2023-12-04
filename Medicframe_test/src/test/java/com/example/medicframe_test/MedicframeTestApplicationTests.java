package com.example.medicframe_test;

        import com.example.medicframe_test.repository.TransactionRepository;
        import com.example.medicframe_test.service.TransactionService;
        import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MedicframeTestApplicationTests {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    public void saveTransactionTest() {
        
    }

}
