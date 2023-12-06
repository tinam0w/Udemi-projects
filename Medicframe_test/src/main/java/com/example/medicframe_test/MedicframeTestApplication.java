package com.example.medicframe_test;

import com.example.medicframe_test.entity.Account;
import com.example.medicframe_test.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MedicframeTestApplication implements CommandLineRunner {

    @Autowired
    AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(MedicframeTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //for the sake of example:
        List<Account> ACCOUNTS = Arrays.asList(
                new Account("001"),
                new Account("002"),
                new Account("003")
        );
        accountRepository.saveAll(ACCOUNTS);
    }
}
