package com.example.medicframe_test.repository;

import com.example.medicframe_test.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository  extends CrudRepository<Transaction, String> {
    //or extends JpaRepository<Transaction, String>
}
