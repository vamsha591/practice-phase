package com.example.employee.service.services;

import java.util.List;

import com.example.employee.service.dto.EmployeeDto;
import com.example.employee.service.entities.Employee;

public interface EmployeeService {
	Employee createEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(String ssn);
	List<Employee> getAllEmployeeByName(String name);
	Employee updateEmployee(String ssn,EmployeeDto employeeDto);
	String deleteEmployee(String ssn);
}
