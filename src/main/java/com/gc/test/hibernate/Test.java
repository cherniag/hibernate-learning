package com.gc.test.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gc.test.hibernate.domain.UserDetails;
import com.gc.test.hibernate.domain.Vehicle;

public class Test {

	@SuppressWarnings({"deprecation"})
	public static void main(String[] args) {
		UserDetails user = new UserDetails().setUserName("johnsmith");
		Vehicle vehicle = new Vehicle("Car");
		user.setVehicle(vehicle);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction transaction = s.beginTransaction();
		int id = (Integer) s.save(user);
		//s.save(vehicle);
		transaction.commit();
		s.close();
		
		
		s = sf.openSession();
		s.beginTransaction();
		UserDetails retreived = (UserDetails) s.get(UserDetails.class, id);
		System.out.println(retreived);
		s.getTransaction().commit();
		s.close();
		
		s = sf.openSession();
		s.beginTransaction();
		retreived = (UserDetails) s.get(UserDetails.class, id);
		s.delete(retreived);
		s.getTransaction().commit();
		s.close();
	}

	
}

