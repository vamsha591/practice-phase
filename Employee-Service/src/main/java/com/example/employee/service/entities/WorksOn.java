package com.example.employee.service.entities;

import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WorksOn {
	
	private int id;
	private String ssn;
	private int  dno;
	private int hrs;
}
