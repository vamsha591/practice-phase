package com.example.spring_mockito_example.control;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring_mockito_example.dto.Customer;
import com.example.spring_mockito_example.dto.Response;
import com.example.spring_mockito_example.repo.CustomerRepo;

@Controller
public class CustomerController {
	@Autowired
	private CustomerRepo customerRepo;
	@PostMapping("/Customer")
	@ResponseBody
	public Response save(@Valid @RequestBody Customer customer)
	{
		customerRepo.save(customer);
		return new Response("insertion status", Boolean.TRUE);
		
	}
	@GetMapping("/Customer")
	@ResponseBody
	public List<Customer> getall()
	{
		return customerRepo.findAll();
	}
	
	@GetMapping("/Customer/{cid}")
	@ResponseBody
	public Optional<Customer> getbyId(@PathVariable int cid)
	{
		return customerRepo.findById(cid);
	}
	
	@DeleteMapping("/Customer/{cid}")
	@ResponseBody
	public Response delete(@PathVariable int cid)
	{
		
		
		if(customerRepo.existsById(cid))
		{
			customerRepo.deleteById(cid);
			return  new Response("Deletion status", Boolean.TRUE);
		}
		else
				return  new Response("Deletion status", Boolean.FALSE);
	}
	
	
	@PutMapping("/Customer/{cid}")
	@ResponseBody
	public Response update(@Valid@RequestBody Customer customer, @PathVariable int cid)
	{
		
		
		if(customerRepo.existsById(cid))
		{
			customer=customerRepo.getOne(cid);
			customerRepo.save(customer);
			return  new Response("Update status", Boolean.TRUE);
		}
		else
				return  new Response("Update status", Boolean.FALSE);
	}
	
	
}
