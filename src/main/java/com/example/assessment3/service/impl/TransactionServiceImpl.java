package com.example.assessment3.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assessment3.dto.ResponseDto;
import com.example.assessment3.dto.TransactionRequestDto;
import com.example.assessment3.entity.Account;
import com.example.assessment3.entity.Transaction;
import com.example.assessment3.repo.AccountRepository;
import com.example.assessment3.repo.TransactionRepository;
import com.example.assessment3.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public ResponseDto transfer(TransactionRequestDto transactionDto) {
		// TODO Auto-generated method stub
		
		if(transactionDto.getFromaccount()!=transactionDto.getToaccount()) {
			
	
			Account creditAccount=accountRepository.findByAccountnumber(transactionDto.getToaccount());
			Account debitAccount=accountRepository.findByAccountnumber(transactionDto.getFromaccount());
			if((debitAccount.getBalance()-transactionDto.getAmount())>500) {
				Transaction transaction=new Transaction();
		
			creditAccount.setBalance(transactionDto.getAmount()+creditAccount.getBalance());
			debitAccount.setBalance(debitAccount.getBalance()-transactionDto.getAmount());
		
			transaction.setFromaccount(transactionDto.getFromaccount());
			transaction.setToaccount(transactionDto.getToaccount());
			transaction.setAmount(transactionDto.getAmount());
			transaction.setDate(transactionDto.getDate());
		
			accountRepository.save(creditAccount);
			accountRepository.save(debitAccount);
		
			transactionRepository.save(transaction);
		
			return new ResponseDto("Successful Transaction");
		}
		}
		return new ResponseDto("Transaction failed!..");
	}
	
	
	
	
}
