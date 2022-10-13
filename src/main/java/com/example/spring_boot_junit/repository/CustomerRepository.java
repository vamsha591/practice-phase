package com.example.spring_boot_junit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot_junit.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
