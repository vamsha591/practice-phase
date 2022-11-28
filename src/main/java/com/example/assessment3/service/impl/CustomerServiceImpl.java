package com.example.assessment3.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.assessment3.dto.ResponseDto;
import com.example.assessment3.entity.Account;
import com.example.assessment3.repo.AccountRepository;
import com.example.assessment3.repo.CustomerRepository;
import com.example.assessment3.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public ResponseDto createAccount(Account account) {
		// TODO Auto-generated method stub
		if(account.getAccounttype().compareTo("Current")==0 &&  ! (customerRepository.findByMobileNoOrEmail((account.getCustomer()).getMobileNo(), (account.getCustomer()).getEmail()).isEmpty()))
		
			return new ResponseDto("Failed to create account");
			
		
		
	
		accountRepository.save(account);
		return new ResponseDto("Account Successfully Created");
		
	}

	
	
	
}
