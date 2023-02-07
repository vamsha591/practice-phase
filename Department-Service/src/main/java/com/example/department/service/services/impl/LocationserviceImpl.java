package com.example.department.service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.department.service.entities.Department;
import com.example.department.service.entities.Location;
import com.example.department.service.repositories.DepartmentRepository;
import com.example.department.service.repositories.LocationRepository;
import com.example.department.service.services.LocationService;
@Service
public class LocationserviceImpl implements LocationService {
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Override
	public List<Department> findByLocation(String location) {
		List<Location> locations=locationRepository.findByNameContains(location);
		return locations.stream().map(loc->departmentRepository.findByLocation(loc)).toList(); 
	}
	@Override
	public Location updateLocation(int id, Location location) {
		Location location2=locationRepository.findById(id).orElseThrow();
		location2.setName(location.getName());
		return location2;
	}

}
