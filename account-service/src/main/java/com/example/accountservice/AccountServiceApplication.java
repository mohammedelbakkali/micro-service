package com.example.accountservice;

import com.example.accountservice.entitys.Account;
import com.example.accountservice.enums.AccountType;
import com.example.accountservice.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository){
        return args -> {

            Account account = Account.builder()
                    .accountId(String.valueOf(UUID.randomUUID()))
                    .solde(50444)
                    .currency("MAD")
                    .createAt(LocalDate.now())
                    .type(AccountType.SAVING_ACCOUNT)
                    .customerId(Long.valueOf(1))
                    .build();
            Account account2 = Account.builder()
                    .accountId(String.valueOf(UUID.randomUUID()))
                    .solde(1000)
                    .currency("MAD")
                    .createAt(LocalDate.now())
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(Long.valueOf(2))
                    .build();
            Account account3 = Account.builder()
                    .accountId(String.valueOf(UUID.randomUUID()))
                    .solde(230)
                    .currency("MAD")
                    .createAt(LocalDate.now())
                    .type(AccountType.SAVING_ACCOUNT)
                    .customerId(Long.valueOf(3))
                    .build();
            accountRepository.save(account);
            accountRepository.save(account2);
            accountRepository.save(account3);

        };
    }
}
