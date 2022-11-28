package com.example.assessment3.service;


import com.example.assessment3.dto.ResponseDto;
import com.example.assessment3.entity.Account;

public interface CustomerService {


	ResponseDto createAccount(Account account);

	
}
