package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyControl {
	@Autowired
	CustomerRespository respository;
	@GetMapping("/customer")
	@ResponseBody
	public String getAll()
	{
		Customer customer=(Customer) respository.findAll();
		List<Customer> customer2=respository.findAll();
		return customer2.toString();
	}
	
	
	@GetMapping("/customer/{cid}")
	@ResponseBody
	public Optional<Customer> getCustomer55(@PathVariable int cid)
	{
		Optional<Customer> customer=respository.findById(cid);
		
		return customer;
	}
	
	@PostMapping("/customer")
	@ResponseBody
	public String save(@RequestBody Customer customer)
	{
		respository.save(customer);
		return "Done";
	}
	
	@DeleteMapping("/customer/{cid}")
	@ResponseBody
	public String delete(@PathVariable int cid)
	{
		respository.deleteById(cid);
		return "Successfully Deleted ";
	}
	
	@PutMapping(path = "/customer",consumes = {"application/json"})
	@ResponseBody
	public String update(@RequestBody Customer customer)
	{
		respository.save(customer);
		return "Updated!..";
	}
	
	
	
	
}
