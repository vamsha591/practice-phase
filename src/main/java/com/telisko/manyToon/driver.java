package com.telisko.manyToon;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mobile m= new  Mobile();
		m.setBrand("xyz");
		Sim sim=new Sim();
		sim.setBrand("A");
		sim.setM(m);
		Sim sim1=new Sim();
		sim1.setBrand("A");
		sim1.setM(m);
		Configuration con=new Configuration().configure().addAnnotatedClass(Mobile.class).addAnnotatedClass(Sim.class);
		SessionFactory sessionFactory=con.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(m);
		session.save(sim1);
		sim1.setBrand("lenova");
		session.detach(sim1);
		session.save(sim);
		Sim s2=session.get(Sim.class,1);
		System.out.println(s2);
		System.out.println(s2.getM().getBrand());
		
		org.hibernate.query.Query query=session.createQuery("from Mobile where brand='xyz' ");
		List<Mobile>ls=query.list();
		for(Mobile list:ls)
		{
			System.out.println(list.getId());
			System.out.println(list.getBrand());
		}
		
		SQLQuery query1=session.createSQLQuery("select * from Mobile");
		List<Mobile>l=query1.getQueryReturns();
		for(Mobile mo:l)
		{
			System.out.println(mo.getId());
		}
		tx.commit();
	}

}
