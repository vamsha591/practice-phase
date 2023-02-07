package com.example.work.service.services;

import java.util.List;

import com.example.work.service.entity.WorksOn;

public interface WorksOnService {
	WorksOn assignWork(WorksOn worksOn);
	List<WorksOn> getByUserId(String ssn);
	List<WorksOn> getByDeptId(int dno);
}
