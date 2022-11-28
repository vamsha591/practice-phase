package com.example.assessment3.controller;



import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assessment3.dto.ResponseDto;
import com.example.assessment3.entity.Account;
import com.example.assessment3.entity.Customer;
import com.example.assessment3.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerControl {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerControl.class);
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/CreateAccount1")
	public ResponseDto createAccount(@RequestBody @Valid Account account)
	{
		logger.info("Creation of new account for the customer with id"+account.getCustomer());
		logger.warn("Please enter valid Customer informations");
		logger.debug("In the method createAccount");
		return customerService.createAccount(account);

	}
}
