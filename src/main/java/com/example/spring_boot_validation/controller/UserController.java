package com.example.spring_boot_validation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring_boot_validation.dto.User;
import com.example.spring_boot_validation.service.UserService;

@Controller
//@RequestMapping("/api/")
public class UserController {
	@Autowired
	private UserService service;
	@PostMapping("/user")

	public ResponseEntity<User> save(@Valid @RequestBody User user)
	{
		User user2=service.createUser(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
		
	}
	

	
	@PostMapping("/save")

	public ResponseEntity<User> save1(@Valid  User user)
	{
		User user2=service.createUser(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
		
	}
}
