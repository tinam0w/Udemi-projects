package com.example.medicframe_test.repository;

import com.example.medicframe_test.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {
    //or extends JpaRepository<Account, String>
}
