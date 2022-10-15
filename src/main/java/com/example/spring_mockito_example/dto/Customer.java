package com.example.spring_mockito_example.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Size;



@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, @Size(min = 2, max = 30, message = "size b/n 2-30") String name,
			@Size(min = 2, max = 30, message = "size b/n 2-30") String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Size(min = 2,max = 30,message = "size b/n 2-30")
	private String name;
	
	@Size(min=2,max=30,message = "size b/n 2-30")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}
}
