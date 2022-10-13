package com.example.spring_boot_junit.controller;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring_boot_junit.dto.Customer;
import com.example.spring_boot_junit.repository.CustomerRepository;


@Controller
public class myController {
	@Autowired
	CustomerRepository customerRepository;
	
	public myController(CustomerRepository customerRepository) {
	
		this.customerRepository = customerRepository;
	}


	@GetMapping("/Customer")
	@ResponseBody
	public List<Customer> display()
	{
		return customerRepository.findAll();
	}
	
	
	@GetMapping("/Customer/{id}")
	@ResponseBody
	public Optional<Customer> display1(@PathVariable int id)
	{
		return customerRepository.findById(id);
	}
	
	@PostMapping("/Customer")

	public ResponseEntity<Customer> save(@Valid @RequestBody Customer customer)
	{
		customerRepository.save(customer);
		return new ResponseEntity<Customer>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/Customer")
	public Customer update(@Valid @RequestBody Customer customer) throws Exception
	{
		if(customer == null)
			throw new NotFoundException();
		Optional<Customer> optional= customerRepository.findById(customer.getId());
		if(!optional.isPresent())
			throw new NotFoundException();
		Customer existingCustomer = optional.get();
		existingCustomer.setName(customer.getName());
		return customerRepository.save(existingCustomer);
		
	}
	
}
