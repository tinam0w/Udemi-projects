package com.example.medicframe_test.web;

import com.example.medicframe_test.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Double> getAccountBalanceById(@PathVariable String id) {
        return new ResponseEntity<>(accountService.getAccountBalanceById(id), HttpStatus.OK);
    }

}
