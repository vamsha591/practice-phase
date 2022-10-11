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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyControl {
	@Autowired
	CustomerRepo customerRepo;
	@GetMapping("/")
	public String anyRequest()
	{
		return "register";
	}
	@RequestMapping("/save")
	public String save(Customer c)
	{
		customerRepo.save(c);
		return "display";
	}
	@PostMapping("/display")
	public String display(@RequestParam("cid")int cid,@RequestParam("cname") String cname)
	{
		System.out.println(cid+"-->"+cname);
		return "display";
	}
	
	@RequestMapping("/getDetails")
	public ModelAndView getDetail(@RequestParam("cid") int cid)
	{
		Optional<Customer> customer=customerRepo.findById(cid);
		ModelAndView view=new ModelAndView();
		view.addObject("customer",customer);
		view.setViewName("getDetails");
		return view;
	}
	
	
	
	
	
	@GetMapping("/customer1")
	@ResponseBody
	public List<Customer> getCustomer5()
	{
	
		Customer customer=(Customer) customerRepo.findAll();
		
		return (List<Customer>) customer;
	}
	@GetMapping("/customer1/{cid}")
	@ResponseBody
	public Optional<Customer> getCustomer55(@PathVariable int cid)
	{
		Optional<Customer> customer=customerRepo.findById(cid);
		
		return customer;
	}
	
	
	
	
	
	@GetMapping("/customer")
	@ResponseBody
	public String getCustomer()
	{

		Customer customer=(Customer) customerRepo.findAll();
		
		return customer.toString();
	}
	@GetMapping("/customer/{cid}")
	@ResponseBody
	public String getCustomer1(@PathVariable int cid)
	{
		Optional<Customer> customer=customerRepo.findById(cid);
		
		return customer.toString();
	}
	@PostMapping("/customer")
	@ResponseBody
	public String save1(@RequestBody Customer customer)
	{
		customerRepo.save(customer);
		
		return "Done!!";
	}
	@DeleteMapping("/customer420/{cid}")
	@ResponseBody
	public Customer delete(@PathVariable int cid)
	{
		Customer customer=customerRepo.getOne(cid);
		customerRepo.delete(customer);
		return customer;
	}
	@PutMapping(path="/customer",consumes = {"application/json"})
	public String update(@RequestBody Customer customer)
	{
		customerRepo.save(customer);
		return "Updated!..";
	}
	@DeleteMapping("/customer/{cid}")
	@ResponseBody
	public String delete1(@PathVariable int cid)
	{
		Customer customer=customerRepo.getById(cid);
		customerRepo.delete(customer);
		return "Done!";
	}
}

