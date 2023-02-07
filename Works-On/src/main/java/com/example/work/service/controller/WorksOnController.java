package com.example.work.service.controller;

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

import com.example.work.service.entity.WorksOn;
import com.example.work.service.services.WorksOnService;

@RestController
@RequestMapping("/WorksOn")
public class WorksOnController {
	@Autowired
	private WorksOnService worksOnService;
	@PostMapping
	public ResponseEntity<WorksOn> assignWork(@RequestBody WorksOn worksOn) {
		return ResponseEntity.status(HttpStatus.CREATED).body(worksOnService.assignWork(worksOn));
	}
	@GetMapping("/users/{ssn}")
	public ResponseEntity<List<WorksOn>>getByUserId(@PathVariable String ssn){
		return ResponseEntity.ok(worksOnService.getByUserId(ssn));
	}
	@GetMapping("/dept/{dno}")
	public ResponseEntity<List<WorksOn>> getByDeptId(@PathVariable int dno){
		return ResponseEntity.ok(worksOnService.getByDeptId(dno));
	}
}
