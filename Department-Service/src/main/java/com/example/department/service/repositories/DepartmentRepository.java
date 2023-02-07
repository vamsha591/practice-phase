package com.example.department.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.department.service.entities.Department;
import com.example.department.service.entities.Location;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	Department findByLocation(Location location);
}
