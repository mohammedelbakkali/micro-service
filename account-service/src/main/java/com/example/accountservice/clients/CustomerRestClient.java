package com.example.accountservice.clients;


import com.example.accountservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/api/v1/customer/{id}")
    @CircuitBreaker(name="customerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @CircuitBreaker(name ="customerService",fallbackMethod = "getAllCustomers")
    @GetMapping("/api/v1/customers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id ,Exception e){
        Customer customer = new Customer();
        customer.setAge(0);
        customer.setId(id);
        customer.setCne("Not Vailable");
        customer.setEmail("Not Vailable");
        customer.setLasName("Not Vailable");
        customer.setFirstName("Not Vailable");
        return customer;
    }

    default List<Customer> getAllCustomers(Exception e){
        return List.of();
    }
}
