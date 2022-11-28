package com.example.assessment3.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

public class Account {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	long accountnumber=(long)(Math.floor(Math.random()*98988998)+787887878);
	
	@Pattern(regexp = "^(?:Business|Current|Saving)$",message = "please enter valid account type")
	String accounttype;
	
	@OneToOne(cascade = CascadeType.ALL)
	private  Customer customer ;
	
	@Min(value = 499)
	 double balance;


}
