package com.example.spring_boot_junit.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min = 2,max = 30,message = "within range 2-30")
	@NotBlank(message = "Id is needed")
	private String name;
	
	
	public Customer(int id,
			@Size(min = 2, max = 30, message = "within range 2-30") @NotBlank(message = "Id is needed") String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	 
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
