package com.telisko.HibRelation.Hibernate_Relation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	private String stdName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int USN;
//	@OneToOne
//	Laptop lap=new Laptop();
	@OneToMany
	List<Laptop> lap=new ArrayList<Laptop>();
	public String getStdName() {
		return stdName;
	}
//	public void setUSN(int USN)
//	{
//		this.USN=USN;
//	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public int getUSN() {
		return USN;
	}
	
	public List<Laptop> getLap() {
		return lap;
	}
	public void setLap(List<Laptop> lap) {
		this.lap = lap;
	}
	
	
	
}
