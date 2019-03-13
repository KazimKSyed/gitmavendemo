package com.hbm.practice.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.Type;

import com.hbm.practice.entity.Address;
import com.hbm.practice.entity.StudentEntity;
import com.hbm.practice.util.UtilityClass;

public  class StudentTest{

	public static void main(String[] args)  {
		Address a1=new Address(101, "pune");
		Address a2=new Address(202, "pune");
		Address a3=new Address(303, "pune");
		Address a4=new Address(404, "pune");
		List<Address> list1=new ArrayList<Address>();
		List<Address> list2=new ArrayList<Address>();
		list1.add(a1);
		list1.add(a2);
		list2.add(a3);
		list2.add(a4);

	StudentEntity s1=new StudentEntity(1, "kazim", "syedkazim@gmail.com", new Date(), list1);
		
	StudentEntity s2=new StudentEntity(2, "syed", "syedkazim56@gmail.com", new Date(), list2);


			Session session=UtilityClass.getSessionFactory().openSession();
				Transaction tx=session.beginTransaction();
			
			session.save(s1);
			session.save(s2);
			System.out.println("student save successfully");
			UtilityClass.resourceCleanUp(session, tx);
	
	}





}
