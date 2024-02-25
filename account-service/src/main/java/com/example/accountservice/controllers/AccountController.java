package com.example.accountservice.controllers;


import com.example.accountservice.clients.CustomerRestClient;
import com.example.accountservice.entitys.Account;
import com.example.accountservice.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    AccountService accountService;
    private CustomerRestClient customerRestClient;

    public AccountController(AccountService accountService,CustomerRestClient customerRestClient) {
        this.accountService = accountService;
        this.customerRestClient=customerRestClient;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts(){
        return this.accountService.getAllAccounts();
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getOneAccount(@PathVariable String id){
        return this.accountService.getOneAccount(id);
    }


}
