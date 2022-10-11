package com.telisko.manyToon;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sim {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@ManyToOne(fetch = FetchType.EAGER)
private Mobile m;
public Mobile getM() {
	return m;
}
public void setM(Mobile m) {
	this.m = m;
}
public int getId() {
	return id;
}

public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
private String brand;
}
