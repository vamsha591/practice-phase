package org.alvas.service;

import java.util.List;

import javax.persistence.Query;

import org.alvas.dao.TeacherDao;
import org.alvas.dto.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherService {

	@Autowired
	TeacherDao dao;

	public Teacher saveTecher(Teacher teacher) {

		return dao.saveTeacher(teacher);
	}

	public List<Teacher> getAllData() {

		return dao.getAllData();
	}

	public Teacher getById(int id) {

		return dao.getById(id);
	}

	public Teacher deleteById(int id) {

		return dao.deleteById(id);
	}
	
	public Teacher updateTeacher(Teacher teacher) {
		
		return dao.updateTeacher(teacher);
	}
}
