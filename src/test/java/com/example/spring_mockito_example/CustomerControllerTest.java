package com.example.spring_mockito_example;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.lenient;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.spring_mockito_example.control.CustomerController;
import com.example.spring_mockito_example.dto.Customer;
import com.example.spring_mockito_example.dto.Response;
import com.example.spring_mockito_example.repo.CustomerRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
	
	
	@Mock
	CustomerRepo customerRepo;
	
	@InjectMocks
	CustomerController customerController;
	
	
	MockMvc mockMvc;
	
	ObjectMapper objectMapper=new ObjectMapper();
	
	
	@BeforeEach
	public void setUp()
	{
		this.mockMvc=MockMvcBuilders.standaloneSetup(customerController).build();
	}
	@Test
	public void saveTest1() throws Exception
	{
		Customer customer=new Customer();
		customer.setId(10);
		customer.setName("Vamsha");
		customer.setEmail("v@gmail.com");
		String json= objectMapper.writeValueAsString(customer);
		
		MvcResult mvcResult=mockMvc.perform(post("/Customer")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
				
				)
				.andExpect(status().isOk())
				.andReturn()
				;
	}
	
	
	
	@Test
	public void getAll1() throws Exception
	{
		Customer stub1=new Customer();
		stub1.setId(10);
		stub1.setName("Vamsha");
		stub1.setEmail("v@gmail.com");
		
		List<Customer> list=new ArrayList<>(Arrays.asList(stub1));
		when(customerController.getall()).thenReturn(list);
		
		
		MvcResult mvcResult=mockMvc.perform(get("/Customer")
			.contentType(MediaType.APPLICATION_JSON)	
				)
			
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").isNumber())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Vamsha"))
				.andReturn()
				
				
				;
	}
	

	
	@Test
	public void getById() throws Exception
	{
		
		Optional<Customer> cust=Optional.of(new Customer(1,"Vamsha","v@gmail.com"));
		lenient().when(customerController.getbyId(1)).thenReturn(cust);
		Customer customer=cust.get();
		assertEquals(1, customer.getId());
		assertEquals("Vamsha", customer.getName());
	
		
	
		
	}

@Test
public void deleteTest() throws Exception
{
	MvcResult mvcResult=mockMvc.perform(delete("/Customer/{cid}",1)
			.contentType(MediaType.APPLICATION_JSON)
			
			)
			
			.andExpect(status().isOk())
			.andReturn()
			;
}
	
@Test
public void updateTest() throws Exception
{
	Customer customer=new Customer();
	customer.setId(1);
	customer.setName("Vamsha");
	customer.setEmail("v@gmail.com");
	String json=objectMapper.writeValueAsString(customer);
	
	
	
	MvcResult mvcResult=mockMvc.perform(put("/Customer/{cid}",1)
			.content(json)
			.contentType(MediaType.APPLICATION_JSON)
			
			
			
			)
			
			.andExpect(status().isOk())
					.andReturn()
			;
}


	
}
