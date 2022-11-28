package com.example.assessment3.controller;


import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.assessment3.dto.ResponseDto;
import com.example.assessment3.dto.StatementResponseDto;
import com.example.assessment3.dto.TransactionRequestDto;
import com.example.assessment3.service.StatementService;
import com.example.assessment3.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionControl {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionControl.class);
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	StatementService statementService;
	
	@PostMapping("/MakeATransaction")
	public ResponseDto transfer(@Valid @RequestBody TransactionRequestDto transactionDto)
	{
		logger.info("Transfer fund ");
		logger.warn("Please enter valid transaction details");
		return transactionService.transfer(transactionDto);
	}
		
	
	@GetMapping("/ShowTransaction")
	public List<StatementResponseDto> getStatement1(@RequestParam("Enter date in formate jan-2022") String date,@RequestParam("Enter your account no") long account) 
	{
		logger.info("View all the transaction of that month");
		logger.warn("Please enter valid Customer informations");
		return statementService.getStatement2(date,account);
	}
	
	
}
