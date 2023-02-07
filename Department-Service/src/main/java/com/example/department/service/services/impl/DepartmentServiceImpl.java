package com.example.department.service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.department.service.entities.Department;
import com.example.department.service.exceptions.ResourceNotFoundException;
import com.example.department.service.repositories.DepartmentRepository;
import com.example.department.service.services.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentRepository departmentRepository;
	@Override
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}
	@Override
	public List<Department> findAllDepartment() {
		return departmentRepository.findAll();
	}

	@Override
	public Department findDepartmentById(int dno) {
		return departmentRepository.findById(dno).orElseThrow(()->new ResourceNotFoundException("Not found"));
	}

}