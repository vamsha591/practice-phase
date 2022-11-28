package com.example.assessment3.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatementResponseDto {
	double amount;
	LocalDate date;
	long account;
	String status;
	public StatementResponseDto(double amount,LocalDate date,long account) {
		super();
		this.amount = amount;
		this.date = date;
		this.account=account;
	}
	
	
}
