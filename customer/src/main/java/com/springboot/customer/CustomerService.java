package com.springboot.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepositry customerRepositry;

    private final RestTemplate restTemplate; // made this in CustomerConfig

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();

        customerRepositry.saveAndFlush(customer); //Flush so that id is loaded and not null
        System.out.println("-------"+customer);
        FraudCheckResponse response = restTemplate.getForObject(
//                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
        if(response.isFrauster()){
            throw new IllegalStateException("FRAUDSTER");
        }

    }
}
