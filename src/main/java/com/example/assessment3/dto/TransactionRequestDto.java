package com.example.assessment3.dto;



import javax.validation.constraints.Min;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequestDto {
	
	
	
	private long fromaccount;
	
	
	private long toaccount;
	
	@Min(value = 1,message = "minimum transaction is 1")
	private double amount;

   private LocalDate date;
	
}
