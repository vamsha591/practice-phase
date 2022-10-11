package com.av.dto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDelete {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("mobile");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Mobile m=entityManager.find(Mobile.class,1);
		List<Sim>list=m.getSim();
		
		entityTransaction.begin();
		entityManager.remove(m);
		for(Sim s1:list)
		{
			entityManager.remove(s1);
		}
		entityTransaction.commit();
	}
}
