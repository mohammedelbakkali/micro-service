package com.example.accountservice.model;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    Long id;
    String firstName;
    String lasName;
    String email;
    int age;
    String cne;


}
