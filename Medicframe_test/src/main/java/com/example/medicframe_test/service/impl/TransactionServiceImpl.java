package com.example.medicframe_test.service.impl;

import com.example.medicframe_test.entity.Account;
import com.example.medicframe_test.entity.Transaction;
import com.example.medicframe_test.exception.AccountNotFoundException;
import com.example.medicframe_test.exception.TransactionAlreadyExistsException;
import com.example.medicframe_test.repository.AccountRepository;
import com.example.medicframe_test.repository.TransactionRepository;
import com.example.medicframe_test.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        if (transactionRepository.findById(transaction.getTransactionId()).isPresent()){
            throw new TransactionAlreadyExistsException(transaction.getTransactionId());
        }

        Account account;
        Optional<Account> accountOptional = accountRepository.findById(transaction.getAccountId());
        if (accountOptional.isPresent()){
            account = accountOptional.get();
        } else {
            throw new AccountNotFoundException(transaction.getAccountId());
        }

        switch (transaction.getTransactionType()){
            case SALE -> account.setBalance(account.getBalance().add(transaction.getAmount()));
            case REFUND, CREDIT -> account.setBalance(account.getBalance().subtract(transaction.getAmount()));
        }

        accountRepository.save(account);
        return transactionRepository.save(transaction);
    }
}
