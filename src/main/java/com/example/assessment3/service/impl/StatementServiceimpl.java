package com.example.assessment3.service.impl;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.assessment3.dto.StatementResponseDto;
import com.example.assessment3.repo.TransactionRepository;
import com.example.assessment3.service.StatementService;

@Service
public class StatementServiceimpl implements StatementService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	
	@Override
	public List<StatementResponseDto> getStatement2(String date1, long account)  {
		// TODO Auto-generated method stub
		DateConverter converter=new DateConverter();
		int month1= converter.getMonth(date1);
		int year1=converter.getYear(date1);
		
		List<LocalDate> dates=transactionRepository.Date(month1,year1);
		List<StatementResponseDto> crediteStatements = new ArrayList<>();
		List<StatementResponseDto> debitStatements = new ArrayList<>();
		
		if (!(dates.isEmpty())) {
			
			for(LocalDate date:dates)
			{
				crediteStatements.addAll(transactionRepository.findByDateAndToaccount1(account,date));
					for(StatementResponseDto c1:crediteStatements)
						c1.setStatus("Credited From acc.no :"+c1.getAccount());
				debitStatements.addAll(transactionRepository.findByDateAndFromaccount1(account,date));
					for(StatementResponseDto c1:debitStatements)
						c1.setStatus("Withdrawn by acc no:"+c1.getAccount());
			}
			crediteStatements.addAll(debitStatements);
			
		}
		
		return crediteStatements;
	}

}
