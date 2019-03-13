package com.hbm.practice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table
public class Address {
	@Id
	private int pinNo;
	private String city;
	@ManyToOne
	private StudentEntity st;
	public int getPinNo() {
		return pinNo;
	}
	public void setPinNo(int pinNo) {
		this.pinNo = pinNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [pinNo=" + pinNo + ", city=" + city + "]";
	}
	public Address(int pinNo, String city) {
		super();
		this.pinNo = pinNo;
		this.city = city;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

}
