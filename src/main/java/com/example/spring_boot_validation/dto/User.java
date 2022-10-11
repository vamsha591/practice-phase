package com.example.spring_boot_validation.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Student")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id",nullable = false)
	
	private int id;
	
	@Column(name = "Name",nullable = false)
	
	@NotBlank(message = "Username Required")
	@Size(min = 2,max=30,message = "exceeds Size")
	private String name;

	@Column(name = "Email",nullable = false)
	@NotBlank
	@Email
	private String email;
	public int getId() {
		return id;
	}
	
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
	public User(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public User() {
	
	}
	
}
