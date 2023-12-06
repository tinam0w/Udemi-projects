package com.example.medicframe_test;

import com.example.medicframe_test.entity.Account;
import com.example.medicframe_test.entity.Transaction;
import com.example.medicframe_test.entity.enums.TransactionType;
import com.example.medicframe_test.repository.AccountRepository;
import com.example.medicframe_test.repository.TransactionRepository;
import com.example.medicframe_test.service.AccountService;
import com.example.medicframe_test.service.TransactionService;
import com.example.medicframe_test.service.impl.AccountServiceImpl;
import com.example.medicframe_test.service.impl.TransactionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MedicframeTestApplicationTests {
    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private AccountService accountService = new AccountServiceImpl(accountRepository);

    @InjectMocks
    private TransactionService transactionService = new TransactionServiceImpl(transactionRepository, accountService);

   @Test
    public void getAccountBalanceByIdTest(){
        Account account = new Account("001", BigDecimal.TEN);

        when(accountRepository.findById("001"))
                .thenReturn(Optional.of(account));

        Double balance = accountService.getAccountBalanceById("001");

        assertEquals(10, balance);
    }

    @Test
    public void saleTransactionTest() {
        Account account = new Account("001");

        when(accountRepository.findById("001"))
                .thenReturn(Optional.of(account));

        Transaction transaction = new Transaction(
                "asd",
                "001",
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

        when(accountRepository.findById("001"))
                .thenReturn(Optional.of(account));

        Transaction transaction = new Transaction(
                "asd",
                "001",
                "qwe",
                TransactionType.CREDIT,
                BigDecimal.valueOf(3),
                "EUR",
                "desc");

        transactionService.saveTransaction(transaction);

        assertEquals(BigDecimal.valueOf(7), account.getBalance());
    }
}
