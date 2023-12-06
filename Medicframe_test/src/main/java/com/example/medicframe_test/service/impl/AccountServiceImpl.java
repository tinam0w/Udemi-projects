package com.example.medicframe_test.service.impl;

import com.example.medicframe_test.entity.Account;
import com.example.medicframe_test.exception.AccountNotFoundException;
import com.example.medicframe_test.repository.AccountRepository;
import com.example.medicframe_test.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
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
