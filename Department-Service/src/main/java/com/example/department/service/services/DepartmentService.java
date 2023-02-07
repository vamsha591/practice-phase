package com.example.department.service.services;

import java.util.List;

import com.example.department.service.entities.Department;

public interface DepartmentService {
	Department createDepartment(Department department);
	List<Department> findAllDepartment();
	Department findDepartmentById(int dno);
}
