package com.example.assessment3.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assessment3.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	List<Customer> findByMobileNoOrEmail(String mobileNo,String email);
}
