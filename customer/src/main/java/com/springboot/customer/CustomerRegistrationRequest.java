package com.springboot.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
