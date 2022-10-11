package com.av.dto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mobile");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Mobile mobile = entityManager.find(Mobile.class, 2);
		if (mobile != null) {
			System.out.println("Mobile Brand:" + mobile.getBrand());
			System.out.println("Mobile Id:" + mobile.getId());
			System.out.println("Mobile Name:" + mobile.getName());
			List<Sim> list = mobile.getSim();
			for (Sim s : list) {
				System.out.println("Sim Id:" + s.getId());
				System.out.println("Service:" + s.getsP());
				System.out.println("Sim Type:" + s.getType());
				System.out.println("*****************************************************************");
			}
		}

	}

}
