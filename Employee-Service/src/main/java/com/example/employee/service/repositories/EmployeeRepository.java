package com.example.employee.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.service.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{
	List<Employee> findByNameContains(String name);
}
