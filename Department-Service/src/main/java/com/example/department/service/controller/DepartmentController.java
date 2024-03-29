package com.example.department.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.department.service.entities.Department;
import com.example.department.service.services.DepartmentService;

@RestController
@RequestMapping("/Department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@PostMapping
	ResponseEntity<Department> createDepartment(@RequestBody Department department) {
		return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.createDepartment(department));
	}
	@GetMapping
	ResponseEntity<List<Department>> findAllDepartment(){
		return ResponseEntity.ok(departmentService.findAllDepartment());
	}
	@GetMapping("/{dno}")
	ResponseEntity<Department> findDepartmentById(@PathVariable int dno) {
		return ResponseEntity.ok(departmentService.findDepartmentById(dno));
	}
}
