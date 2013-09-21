package com.gc.test.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gc.test.hibernate.domain.FourWeelerVehicle;
import com.gc.test.hibernate.domain.TwoWeelerVehicle;
import com.gc.test.hibernate.domain.UserDetails;
import com.gc.test.hibernate.domain.Vehicle;

public class Test {

	@SuppressWarnings({"deprecation"})
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle("Car");
		
		TwoWeelerVehicle twoWeelerVehicle = new TwoWeelerVehicle();
		twoWeelerVehicle.setVechicleName("bike");
		twoWeelerVehicle.setSteeringHandle("handle");
		
		FourWeelerVehicle fourWeelerVehicle = new FourWeelerVehicle();
		fourWeelerVehicle.setVechicleName("bus");
		fourWeelerVehicle.setSteeringWheel("wheel");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction transaction = s.beginTransaction();
		s.persist(vehicle);
		s.persist(twoWeelerVehicle);
		s.persist(fourWeelerVehicle);
//		s.save(vehicle1);
//		s.save(vehicle2);
		transaction.commit();
		s.close();
		
		
		
		
		s = sf.openSession();
		s.beginTransaction();
		System.out.println(s.createQuery("from Vehicle").list());
		Vehicle retreived = (Vehicle) s.get(Vehicle.class, 3);
		System.out.println(retreived);
		s.getTransaction().commit();
		s.close();
	}

	
}

