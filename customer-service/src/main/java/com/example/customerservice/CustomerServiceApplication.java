package com.example.customerservice;

import com.example.customerservice.config.GlobalConfig;
import com.example.customerservice.entitys.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
		// chaque fonction declarer par l'annotation bean , il va s'exécuer au demarage
		// et la methode declarer par @bean il va returne un obj
	CommandLineRunner commandLineRunner (CustomerRepository customerRepository){
        return args -> {

			Customer customer1 = 	Customer.builder()
				 .cne("P135291177")
				 .age(20)
				 .email("mohammed@gmail.com")
				 .firstName("mohammed")
				 .lasName("bakkali")
				 .build();
			Customer customer2 = 	Customer.builder()
					.cne("P135291177")
					.age(20)
					.email("mohammed@gmail.com")
					.firstName("mohammed")
					.lasName("bakkali")
					.build();

			Customer customer3 = 	Customer.builder()
					.cne("P135291177")
					.age(20)
					.email("mohammed@gmail.com")
					.firstName("mohammed")
					.lasName("bakkali")
					.build();
			List<Customer> customersList = List.of(customer1,customer2,customer3);
			customerRepository.saveAll(customersList);
         };
    }
}
