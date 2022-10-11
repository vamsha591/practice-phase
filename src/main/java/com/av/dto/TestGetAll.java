package com.av.dto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestGetAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mobile");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select m from Mobile m");
		List<Mobile> list = query.getResultList();
		for (Mobile mobile : list) {
			System.out.println("Mobile Brand:" + mobile.getBrand());
			System.out.println("Mobile Id:" + mobile.getId());
			System.out.println("Mobile Name:" + mobile.getName());
			List<Sim> list1 = mobile.getSim();
			for (Sim s : list1) {
				System.out.println("Sim Id:" + s.getId());
				System.out.println("Service:" + s.getsP());
				System.out.println("Sim Type:" + s.getType());

			}
			System.out.println("*****************************************************************");
		}

	}

}
