package com.example.customerservice.repository;

import com.example.customerservice.entitys.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


//@RepositoryRestResource // spring data rest deja il gere rest api de maniere genereque
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
