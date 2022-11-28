package com.example.assessment3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@NotBlank(message="First name required")
	@Size(min=2,max=30)
	String fname;
	
	@Size(min=0,max=30)
	String lname;
	
	@Min(value = 18, message = "Age should not be less than 18")
	int age;
	
	
	@Pattern(regexp = "^(?:Male|Female|Others)$",message = "please enter gender")
	String gender;
	
	@Pattern(regexp="(^$|[0-9]{12})")
	@Size(min=12,max=12,message = "Enter 12 digit Aadhar number")
	 private String aadhar;
	
	@NotEmpty
	@Email
	String email;
	
	@Pattern(regexp="(^$|[0-9]{10})")
	 @Size(min=10,max=10,message = "Enter 10 digit phone number")
	 private String mobileNo;
}
