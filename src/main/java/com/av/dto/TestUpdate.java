package com.av.dto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("mobile");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Mobile m=entityManager.find(Mobile.class,2);
		m.setBrand("Apple");
		m.setName("xyz");
		List<Sim>list=m.getSim();
	
		
		
		entityTransaction.begin();
		entityManager.merge(m);
		for(Sim s:list)
		{
			s.setsP("JIO-5G");
			s.setType("5G");
			entityManager.merge(s);
		}
		entityTransaction.commit();
	
	}

}
