package com.example.spring_mockito_example;




import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;





import org.springframework.test.web.servlet.MvcResult;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.spring_mockito_example.control.CustomerController;
import com.example.spring_mockito_example.dto.Customer;
import com.example.spring_mockito_example.dto.Response;
import com.example.spring_mockito_example.repo.CustomerRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class SpringMockitoExampleApplicationTests {
	@Mock
	CustomerRepo repo;
	@InjectMocks
	CustomerController customerController;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	MockMvc mockMvc;
	ObjectMapper mapper=new ObjectMapper();

	@BeforeEach
	void setUp()
	{
		 this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}
	
	@Test
	public void test1() throws Exception
	{
		Customer customer=new Customer();
		customer.setId(1);
		customer.setName("abc");
		customer.setEmail("abc@gmail.com");
		
		String jsonRequest=mapper.writeValueAsString(customer);
		MvcResult result=(MvcResult) mockMvc.perform( post("/Customer")
				.content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is(200))
				.andReturn();
	}
	
	
	@Test
	public void test2() throws Exception
	{
		MvcResult result = mockMvc
				.perform(get("/Customer").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
	}
}
