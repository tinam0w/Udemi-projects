package com.example.medicframe_test.exception;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String id) {
        super("Account " + id + " not found.");
    }
}
