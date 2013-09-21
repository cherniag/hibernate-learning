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
		Vehicle vehicle1 = new Vehicle("Car");
		user.getVehicles().add(vehicle1);
		Vehicle vehicle2 = new Vehicle("Jeep");
		user.getVehicles().add(vehicle2);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction transaction = s.beginTransaction();
		s.persist(user);
//		s.save(vehicle1);
//		s.save(vehicle2);
		transaction.commit();
		s.close();
		
		
		s = sf.openSession();
		s.beginTransaction();
		UserDetails retreived = (UserDetails) s.get(UserDetails.class, 1);
		System.out.println(retreived);
		s.getTransaction().commit();
		s.close();
		
		//if(true)return;
		s = sf.openSession();
		s.beginTransaction();
		retreived = (UserDetails) s.get(UserDetails.class, 1);
		s.delete(retreived);
		//retreived.getVehicles().clear();
		s.getTransaction().commit();
		s.close();
	}

	
}

