package com.av.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sim sim=new Sim();
		sim.setType("4G");
		sim.setsP("Airtel");
		Sim sim2=new Sim();
		sim2.setType("3G");
		sim2.setsP("vodaphone");
		List<Sim>list=new ArrayList<Sim>();
		list.add(sim2);
		list.add(sim);
		Mobile m=new Mobile();
		m.setBrand("MI");
		m.setName("Redmi");
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("mobile");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(sim);
		entityManager.persist(sim2);
		entityManager.persist(m);
		sim.setM(m);
		sim2.setM(m);
		m.setSim(list);
		entityTransaction.commit();
	}

}
