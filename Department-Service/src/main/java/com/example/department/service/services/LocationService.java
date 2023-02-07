package com.example.department.service.services;

import java.util.List;

import com.example.department.service.entities.Department;
import com.example.department.service.entities.Location;

public interface LocationService {
	List<Department> findByLocation(String location);
	Location updateLocation(int id,Location location);
}
