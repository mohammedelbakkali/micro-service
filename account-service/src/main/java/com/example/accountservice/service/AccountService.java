package com.example.accountservice.service;


import com.example.accountservice.clients.CustomerRestClient;
import com.example.accountservice.entitys.Account;
import com.example.accountservice.model.Customer;
import com.example.accountservice.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    AccountRepository accountRepository;
    private CustomerRestClient customerRestClient;

    public AccountService(AccountRepository accountRepository,CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient=customerRestClient;
    }

    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts = this.accountRepository.findAll();
        accounts.forEach(acc->{
             acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    public ResponseEntity<Account> getOneAccount(String id){
        Account account=this.accountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

}
