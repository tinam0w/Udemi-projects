package com.example.medicframe_test;

        import com.example.medicframe_test.entity.Account;
        import com.example.medicframe_test.entity.Transaction;
        import com.example.medicframe_test.entity.enums.TransactionType;
        import com.example.medicframe_test.repository.AccountRepository;
        import com.example.medicframe_test.repository.TransactionRepository;
        import com.example.medicframe_test.service.AccountService;
        import com.example.medicframe_test.service.TransactionService;
        import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.springframework.boot.test.context.SpringBootTest;

        import java.math.BigDecimal;
        import java.util.Optional;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.mockito.Mockito.when;

@SpringBootTest
class MedicframeTestApplicationTests {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionService transactionService;

    @Mock
    AccountService accountService;

    @Test
    public void saleTransactionTest() {
        Account account = new Account("001");
        accountRepository.save(account);

        when(accountRepository.findById("001"))
                .thenReturn(Optional.of(account));

        Transaction transaction = new Transaction(
                "001",
                "asd",
                "qwe",
                 TransactionType.SALE,
                 BigDecimal.TEN,
                "EUR",
                "desc");

        transactionService.saveTransaction(transaction);

        assertEquals(BigDecimal.TEN, account.getBalance());
    }

    @Test
    public void creditTransactionTest() {
        Account account = new Account("001", BigDecimal.TEN);
        accountRepository.save(account);

        when(accountRepository.findById("001"))
                .thenReturn(Optional.of(account));

        Transaction transaction = new Transaction(
                "001",
                "asd",
                "qwe",
                TransactionType.CREDIT,
                BigDecimal.valueOf(3),
                "EUR",
                "desc");

        transactionService.saveTransaction(transaction);

        assertEquals(BigDecimal.valueOf(7), account.getBalance());
    }

    @Test
    public void getAccountBalanceByIdTest(){
        Account account = new Account("001", BigDecimal.TEN);
        accountRepository.save(account);

        Double balance = accountService.getAccountBalanceById("001");

        assertEquals(10, balance);
    }
}
