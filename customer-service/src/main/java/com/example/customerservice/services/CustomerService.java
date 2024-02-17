package com.example.customerservice.services;

import com.example.customerservice.DTO.CustomerDto;
import com.example.customerservice.entitys.Customer;
import com.example.customerservice.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerDto> getAllCustomers(){
           List<CustomerDto> customerDtos = new ArrayList<>();
           List<Customer> customers = this.customerRepository.findAll();
           for(Customer value : customers ){
                customerDtos.add(CustomerDto.toCustomerDto(value));
           }
           return customerDtos;
    }

    public CustomerDto getOneCustomer(Long id){
         Customer obj = this.customerRepository.findById(id).get();
         return CustomerDto.toCustomerDto(obj);
    }

    public void saveCustomer(Customer customer){
         this.customerRepository.save(customer);

    }

    public ResponseEntity<String> deleteCustomer(Long id){
        this.customerRepository.deleteById(id);
        return ResponseEntity.ok("customer a supprimé avec succés");

    }


    public ResponseEntity<String> putCustomer(Long id , Customer customer ){
      this.customerRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entité non trouvée avec l'ID : " + id));
      this.customerRepository.save(customer);
      return ResponseEntity.ok("Entité mise à jour avec succès");
    }


    public ResponseEntity<String> patchCustomer(Long id,Customer customerPartielle){
        Customer entiteExistante = this.customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entité non trouvée avec l'ID : " + id));

        // Utilisation de BeanUtils.copyProperties pour copier uniquement les propriétés non nulles
        copyNonNullProperties(customerPartielle, entiteExistante);

        // Sauvegarder l'entité existante mise à jour
        this.customerRepository.save(entiteExistante);

        return ResponseEntity.ok("Entité partiellement mise à jour avec succès");
    }


    // Méthode utilitaire pour obtenir les noms des propriétés nulles
    public String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> propertiesToIgnore = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) propertiesToIgnore.add(pd.getName());
        }

        return propertiesToIgnore.toArray(new String[0]);
    }


    public void copyNonNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }


}
