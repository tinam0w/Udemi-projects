package com.example.medicframe_test.repository;

import com.example.medicframe_test.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {
    //or extends JpaRepository<Account, Long>
}
