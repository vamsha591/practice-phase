package com.telisko.HibRelation.Hibernate_Relation;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Laptop lap=new Laptop();
      
       lap.setBrand("Lenovo");
       lap.setPrice(55000.5);
       Student std=new Student();
//       std.setUSN(10000);
       std.setStdName("Vamsha");
//       std.setLap(lap);
       std.getLap().add(lap);
       Configuration configuration=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
       SessionFactory sf=configuration.buildSessionFactory();
       Session session=sf.openSession();
       Transaction tx=session.beginTransaction();
       session.save(lap);
       session.save(std);
       tx.commit();
//       updateStudent();
//       mergeStudent();
       
//       deleteStudent();
//       getStudentByID();
//       getStudentByName();
    }
//    private static void getStudentByName() {
//		Configuration configuration=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
//		SessionFactory sessionFactory=configuration.buildSessionFactory();
//		Session session=sessionFactory.openSession();
//		Transaction transaction=session.beginTransaction();
//		Query query=session.createQuery("select s from student s");
//		List<Student>ls=((org.hibernate.query.Query) query).list();
//		for(Student s:ls)
//		{
//			System.out.println("Student ID:"+s.getUSN());
//			System.out.println("Student Name:"+s.getStdName());
//			System.out.println("Laptop Brand "+s.getLap().getBrand());
//			System.out.println("Laptop ID"+s.getLap().getId());
//			System.out.println("Laptop price"+s.getLap().getPrice());
//			System.out.println();
//		}
//		transaction.commit();
//	}
	private static void getStudentByID() {
		Configuration configuration=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Student std=session.get(Student.class,1);
		System.out.println("Student ID:"+std.getUSN());
		System.out.println("Student Name:"+std.getStdName());
		System.out.println("Laptop Brand "+((Laptop) std.getLap()).getBrand());
		System.out.println("Laptop ID"+((Laptop) std.getLap()).getId());
		System.out.println("Laptop price"+((Laptop) std.getLap()).getPrice());
		transaction.commit();
		
	}
	private static void deleteStudent() {
		
    	Configuration con=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
    	SessionFactory sessionFactory=con.buildSessionFactory();
    	Session session=sessionFactory.openSession();
    	Transaction transaction=session.beginTransaction();
    	Student std=session.get(Student.class, 1);
    	std.setStdName("Vamsha S");
    	session.delete(std);
    	transaction.commit();
	}
	private static void mergeStudent() {
    	Configuration con=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
    	SessionFactory sessionFactory=con.buildSessionFactory();
    	Session session=sessionFactory.openSession();
    	Transaction transaction=session.beginTransaction();
    	Student std=session.get(Student.class, 100);
    	std.setStdName("Vamsha S");
    	session.merge(std);
    	transaction.commit();
		
	}
	public static void updateStudent()
    {
    	Configuration con=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
    	SessionFactory sessionFactory=con.buildSessionFactory();
    	Session session=sessionFactory.openSession();
    	Transaction transaction=session.beginTransaction();
    	Student std=session.get(Student.class, 3);
    	std.setStdName("Vamsha S");
    	session.update(std);
    	transaction.commit();
    }
    
}
