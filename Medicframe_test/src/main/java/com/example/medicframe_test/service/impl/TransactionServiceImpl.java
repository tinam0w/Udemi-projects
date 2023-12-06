package com.example.medicframe_test.service.impl;

import com.example.medicframe_test.entity.Account;
import com.example.medicframe_test.entity.Transaction;
import com.example.medicframe_test.exception.TransactionAlreadyExistsException;
import com.example.medicframe_test.repository.TransactionRepository;
import com.example.medicframe_test.service.AccountService;
import com.example.medicframe_test.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {


    TransactionRepository transactionRepository;
    AccountService accountService;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        if (transactionRepository.findById(transaction.getTransactionId()).isPresent()){
            throw new TransactionAlreadyExistsException(transaction.getTransactionId());
        }

        Account account = accountService.findById(transaction.getAccountId());

        switch (transaction.getTransactionType()){
            case SALE -> account.setBalance(account.getBalance().add(transaction.getAmount()));
            case REFUND, CREDIT -> account.setBalance(account.getBalance().subtract(transaction.getAmount()));
        }

        return transactionRepository.save(transaction);
    }
}
