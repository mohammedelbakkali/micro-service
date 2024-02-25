package com.example.customerservice.controllers;


import com.example.customerservice.DTO.CustomerDto;
import com.example.customerservice.entitys.Customer;
import com.example.customerservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class CustomerController {


     CustomerService customerService;

     CustomerController(CustomerService _customerService){
          this.customerService=_customerService;
     }

     @GetMapping("")
     public String test(){
          return "hello world !";
     }
     @GetMapping("/customer/{id}")
     public CustomerDto getCustomer(@PathVariable Long id){

         return this.customerService.getOneCustomer(id);
     }

    @GetMapping("/customers")
    public List<CustomerDto> getAllCustomers(){
        return this.customerService.getAllCustomers();
    }

    @PostMapping("/customer")
    public ResponseEntity<String> saveCustomer(@RequestBody CustomerDto customerDto){
              this.customerService.saveCustomer(customerDto);
              return new ResponseEntity<>("Objet créé avec succès", HttpStatus.CREATED);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<String> putCustomer(
            @PathVariable  Long id,
            @RequestBody Customer customer
    ){
      return this.customerService.putCustomer(id,customer);
    }

    @PatchMapping("/customer/{id}")
    public ResponseEntity<String> patchEntite(@PathVariable Long id, @RequestBody Customer customer) {
      return this.customerService.patchCustomer(id,customer);
    }

    @DeleteMapping("/custemer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        return this.customerService.deleteCustomer(id);
    }


}
