package com.example.accountservice.repository;

import com.example.accountservice.entitys.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String>{
}
