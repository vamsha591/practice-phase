package com.example.spring_mockito_example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_mockito_example.dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
