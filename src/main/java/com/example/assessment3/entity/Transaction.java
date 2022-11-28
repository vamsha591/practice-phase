package com.example.assessment3.entity;





import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	private long toaccount;
	
	private long fromaccount; 
	
	double amount;
	
	private LocalDate date;

	


	 
	
}
