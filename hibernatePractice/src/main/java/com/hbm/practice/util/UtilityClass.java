package com.hbm.practice.util;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UtilityClass {
	public static SessionFactory sessioFactory=null;
	@SuppressWarnings("deprecation")
	public static SessionFactory getSessionFactory() {
		if(sessioFactory==null) {
			Configuration con=new Configuration();
			sessioFactory=con.configure().buildSessionFactory();
		}
		return sessioFactory;
	}
	
	public static void resourceCleanUp(Session session,Transaction tx) {
		if(session!=null) {
			session.flush();
			
			if(tx!=null)
				tx.commit();
		}
		session.close();
	}


}
