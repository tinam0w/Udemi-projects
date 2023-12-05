package com.example.medicframe_test.service.impl;

import com.example.medicframe_test.entity.Account;
import com.example.medicframe_test.exception.AccountNotFoundException;
import com.example.medicframe_test.repository.AccountRepository;
import com.example.medicframe_test.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;

        //for the sake of example:
        List<Account> accounts = Arrays.asList(
                new Account("001"),
                new Account("002"),
                new Account("003")
        );
        accountRepository.saveAll(accounts);

    }

    @Override
    public Double getAccountBalanceById(String id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()){
            return account.get().getBalance().doubleValue();
        } else {
            throw new AccountNotFoundException(id);
        }
    }
}
