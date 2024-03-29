package com.example.employee.service.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	private String ssn;
	private String name;
	private double salary;
	private LocalDate dob;
	private LocalDate doj;
	private String gender;
	private boolean isManager;
	@Transient
	private List<Department> dno;
	@Transient
	private List<WorksOn> worksOns;
}
