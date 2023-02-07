package com.example.department.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.department.service.entities.Department;
import com.example.department.service.entities.Location;
import com.example.department.service.services.LocationService;

@RestController
@RequestMapping("/Location")
public class LocationController {
	@Autowired
	private LocationService locationService;
	@GetMapping("/{location}")
	public ResponseEntity<List<Department>> findByLocation(@PathVariable String location){
		return ResponseEntity.ok(locationService.findByLocation(location));
	}
	@PutMapping("/{id}")
	public ResponseEntity<Location> updateLocation(@PathVariable int id,@RequestBody Location location){
		return ResponseEntity.ok(locationService.updateLocation(id, location));
	}
	
}