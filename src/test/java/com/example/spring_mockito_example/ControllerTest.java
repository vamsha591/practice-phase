package com.example.spring_mockito_example;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.spring_mockito_example.dto.Customer;
import com.example.spring_mockito_example.repo.CustomerRepo;
import com.fasterxml.jackson.databind.ObjectMapper;



@ExtendWith(MockitoExtension.class)
public class ControllerTest {

	@Mock
	CustomerRepo customerRepo;
	
	@InjectMocks
	com.example.spring_mockito_example.control.CustomerController controller;
	
	
	MockMvc mockMvc;
	
	ObjectMapper objectMapper=new ObjectMapper();
	
	
	@BeforeEach
	public void setUp()
	{
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void testSave() throws Exception
	{
		
		Customer customer=new Customer();
		customer.setId(1);
		customer.setName("xyz");
		customer.setEmail("xy@gmil.com");
		String json=objectMapper.writeValueAsString(customer);
		MvcResult mvcResult=(MvcResult) mockMvc.perform(post("/Customer")
				
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
				
				)
				
				.andExpect(status().is(200))
				.andReturn()
				;
	}
	
	@Test
	public void testDisplayAll() throws Exception
	{
		MvcResult mvcResult=mockMvc.perform(get("/Customer")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn()
				
				;
		
		
	}
	
	
	
}
