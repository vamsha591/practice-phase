package com.example.department.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.department.service.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
	List<Location> findByNameContains(String location);

}
