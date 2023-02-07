package com.example.employee.service.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.employee.service.dto.EmployeeDto;
import com.example.employee.service.entities.Department;
import com.example.employee.service.entities.Employee;
import com.example.employee.service.entities.WorksOn;
import com.example.employee.service.exceptions.ResourceNotFoundException;
import com.example.employee.service.repositories.EmployeeRepository;
import com.example.employee.service.services.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public Employee createEmployee(Employee employee) {
		employee.setSsn(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll().stream().map(employee->{
			WorksOn[] worksOns= restTemplate.getForObject("http://WORKS-ON-SERVICE/WorksOn/users/"+employee.getSsn(),WorksOn[].class);
			List<WorksOn> workList=Arrays.stream(worksOns).toList();
			employee.setWorksOns(workList);
			List<Department>departments =workList.stream().map(work->{
			return restTemplate.getForObject("http://DEPARTMENT-SERVICE/Department/"+work.getDno(),Department.class);
			}).toList();
			employee.setDno(departments);
			return employee;
		}).toList();
	}
	@Override
	public Employee getEmployeeById(String ssn) {
		Employee employee =employeeRepository.findById(ssn).orElseThrow(()->new ResourceNotFoundException("Employee with ssn "+ssn+" not found"));
		WorksOn[] worksOns= restTemplate.getForObject("http://WORKS-ON-SERVICE/WorksOn/users/"+employee.getSsn(),WorksOn[].class);
		List<WorksOn> workList=Arrays.stream(worksOns).toList();
		employee.setWorksOns(workList);
		List<Department>departments =workList.stream().map(work->{
		return restTemplate.getForObject("http://DEPARTMENT-SERVICE/Department/"+work.getDno(),Department.class);
		}).toList();
		employee.setDno(departments);
		return employee;
	}
	@Override
	public List<Employee> getAllEmployeeByName(String name) {
		return employeeRepository.findByNameContains(name).stream().map(employee->{
			WorksOn[] worksOns= restTemplate.getForObject("http://WORKS-ON-SERVICE/WorksOn/users/"+employee.getSsn(),WorksOn[].class);
			List<WorksOn> workList=Arrays.stream(worksOns).toList();
			employee.setWorksOns(workList);
			List<Department>departments =workList.stream().map(work->{
			return restTemplate.getForObject("http://DEPARTMENT-SERVICE/Department/"+work.getDno(),Department.class);
			}).toList();
			employee.setDno(departments);
			return employee;
		}).toList();
	}
	@Override
	public Employee updateEmployee(String ssn,EmployeeDto employeeDto) {
		Employee employee=employeeRepository.findById(ssn).orElseThrow(()->new ResourceNotFoundException("Employee with ssn "+ssn+" not found"));
		BeanUtils.copyProperties(employeeDto, employee);
		return employee;
	}
	@Override
	public String deleteEmployee(String ssn) {
		employeeRepository.deleteById(ssn);
		return "Done";
	}
}
