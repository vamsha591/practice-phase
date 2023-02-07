package com.example.work.service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.work.service.entity.WorksOn;
import com.example.work.service.repositories.WorksOnRepository;
import com.example.work.service.services.WorksOnService;
@Service
public class WorksOnServiceImpl implements WorksOnService{
	@Autowired
	private WorksOnRepository worksOnRepository;
	@Override
	public WorksOn assignWork(WorksOn worksOn) {
		return worksOnRepository.save(worksOn);
	}
	@Override
	public List<WorksOn> getByUserId(String ssn) {
		return worksOnRepository.findBySsn(ssn);
	}
	@Override
	public List<WorksOn> getByDeptId(int dno) {
		return worksOnRepository.findByDno(dno);
	}

}
