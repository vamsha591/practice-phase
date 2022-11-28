package com.example.assessment3.service;


import java.util.List;


import com.example.assessment3.dto.StatementResponseDto;

public interface StatementService {
	
	

	List<StatementResponseDto> getStatement2(String date, long account);
	

}
