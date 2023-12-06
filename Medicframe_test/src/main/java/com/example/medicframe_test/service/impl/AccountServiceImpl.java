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

    //for the sake of example:
    private static final List<Account> ACCOUNTS = Arrays.asList(
            new Account("001"),
            new Account("002"),
            new Account("003")
    );

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        accountRepository.saveAll(ACCOUNTS);
    }

    @Override
    public Account findById(String id){
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()){
            return accountOptional.get();
        } else {
            throw new AccountNotFoundException(id);
        }
    }

    @Override
    public Double getAccountBalanceById(String id) {
        return findById(id).getBalance().doubleValue();
    }
}
