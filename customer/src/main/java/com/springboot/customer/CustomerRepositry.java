package com.springboot.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositry extends JpaRepository<Customer,Integer> {
}
