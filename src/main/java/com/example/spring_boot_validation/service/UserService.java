package com.example.spring_boot_validation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_validation.dto.User;
import com.example.spring_boot_validation.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public User createUser(User user)
	{
		return repository.save(user);
	}
	
}
