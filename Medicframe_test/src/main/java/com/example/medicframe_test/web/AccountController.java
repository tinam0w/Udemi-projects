package com.example.medicframe_test.web;

import com.example.medicframe_test.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Account Controller", description = "Return balance of an account")
@RestController
public class AccountController {

    AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Operation(summary = "Get account balance", description = "Provides the balance of an account by id")
    @GetMapping(value = "account/{id}")
    public ResponseEntity<Double> getAccountBalanceById(@PathVariable String id) {
        return new ResponseEntity<>(accountService.getAccountBalanceById(id), HttpStatus.OK);
    }

}
