package com.example.medicframe_test.web;

import com.example.medicframe_test.entity.Transaction;
import com.example.medicframe_test.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("`/transaction")
public class TransactionController {

    private final TransactionService service;

    @Autowired
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Transaction> saveTransaction(@RequestBody @Valid Transaction transaction) {
        return new ResponseEntity<>(service.saveTransaction(transaction), HttpStatus.CREATED);
    }

}
