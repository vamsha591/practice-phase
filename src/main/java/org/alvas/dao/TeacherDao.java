package org.alvas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.alvas.dto.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	EntityManager entityManager;
	EntityTransaction entityTransaction;
	
	public Teacher saveTeacher(Teacher teacher) {
		
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		entityManager.persist(teacher);
		
		entityTransaction.commit();
		
		return teacher;
	}
	
	public List<Teacher> getAllData(){
		
		String select = "Select t From Teacher t";
		
		entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createQuery(select);
		
		List<Teacher> teacher =  query.getResultList();
		
		return teacher;
	}
	
	public Teacher getById(int id) {
		
		entityManager = entityManagerFactory.createEntityManager();
		
	   return entityManager.find(Teacher.class,id);
	}
	
	public Teacher deleteById(int id) {
		
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		
		Teacher teacher = entityManager.find(Teacher.class, id);
		
		entityTransaction.begin();
		entityManager.remove(teacher);
		entityTransaction.commit();
		
		return teacher;
	}
	
	public Teacher updateTeacher(Teacher teacher) {
		
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(teacher);
		entityTransaction.commit();
		
		return teacher;
	}
}
