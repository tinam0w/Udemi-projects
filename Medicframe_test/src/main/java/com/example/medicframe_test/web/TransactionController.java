package com.example.medicframe_test.web;

import com.example.medicframe_test.entity.Transaction;
import com.example.medicframe_test.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Listener for a transactions", description = "Saves and manages transactions")
@RestController
public class TransactionController {

    TransactionService service;

    @Autowired
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @Operation(summary = "Saves transactions")
    @PostMapping(value = "/transaction")
    public ResponseEntity<Transaction> saveTransaction(@RequestBody @Valid Transaction transaction) {
        return new ResponseEntity<>(service.saveTransaction(transaction), HttpStatus.CREATED);
    }

}
