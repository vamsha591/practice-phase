package com.example.work.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.work.service.entity.WorksOn;

public interface WorksOnRepository extends JpaRepository<WorksOn, Integer> {
	List<WorksOn> findBySsn(String ssn);
	List<WorksOn> findByDno(int dno);
}
