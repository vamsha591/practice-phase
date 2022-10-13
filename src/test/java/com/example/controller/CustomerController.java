package com.example.controller;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.spring_boot_junit.controller.myController;
import com.example.spring_boot_junit.dto.Customer;
import com.example.spring_boot_junit.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerController {
	 @Mock 
	 private CustomerRepository customerRepository;
	 	@InjectMocks
	    private myController controller;
	 
	    @BeforeEach 
	    void setUp()
	    {
	        this.controller = new myController(this.customerRepository);
	    }
	 
	    @Test 
	    void getAllCustomer()
	    {
	        controller.display();
	        verify(customerRepository).findAll();
	    }
	    
	    @Test
	    void getbyId()
	    {
	    	controller.display1(1);
	    	verify(customerRepository).findById(1);
	    }
	    
	    @Test
	    void save()
	    {
	    	Customer record=new Customer(1,"ABC");
	    	controller.save(record);
	    	verify(customerRepository).save(record);
	    }
	    
	  
	    
}
