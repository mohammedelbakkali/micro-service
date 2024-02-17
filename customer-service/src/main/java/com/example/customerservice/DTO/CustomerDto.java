package com.example.customerservice.DTO;

import com.example.customerservice.entitys.Customer;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.example.customerservice.entitys.Customer}
 *  @Value, Lombok générera automatiquement les méthodes equals, hashCode, toString,
 */

@Value
@Builder
@Setter
@Getter

public class CustomerDto implements Serializable {
    Long id;
    String firstName;
    String lasName;
    String email;
    int age;
    String cne;

    public static CustomerDto toCustomerDto(Customer entity){
         return CustomerDto.builder()
                 .id(entity.getId())
                 .firstName(entity.getFirstName())
                 .lasName(entity.getLasName())
                 .email(entity.getEmail())
                 .age(entity.getAge())
                 .cne(entity.getCne())
                 .build();
    }
}

