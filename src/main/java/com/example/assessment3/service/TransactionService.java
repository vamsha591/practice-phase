package com.example.assessment3.service;


import com.example.assessment3.dto.ResponseDto;
import com.example.assessment3.dto.TransactionRequestDto;

public interface TransactionService {
	
	ResponseDto transfer(TransactionRequestDto transactionDto);

	
}
