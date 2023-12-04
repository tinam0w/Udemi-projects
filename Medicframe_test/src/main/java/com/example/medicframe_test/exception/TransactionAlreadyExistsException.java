package com.example.medicframe_test.exception;

public class TransactionAlreadyExistsException extends RuntimeException{
    public TransactionAlreadyExistsException(String id){
        super("Transaction " + id + " already exists.");
    }
}
