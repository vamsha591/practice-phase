package com.telisko.manyToon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mobile {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
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
