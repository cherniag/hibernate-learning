package com.gc.test.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gc.test.hibernate.domain.Action;
import com.gc.test.hibernate.domain.Address;
import com.gc.test.hibernate.domain.UserDetails;

public class Test {

	@SuppressWarnings({"deprecation"})
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction transaction = s.beginTransaction();
		s.save(new UserDetails().setUserName("johnsmith")
				.setDescription("some kind of users")
				.setAddresses(getAddress()));
		
		s.save(Action.getNewAction());
		transaction.commit();
		s.close();
		
		s = sf.openSession();
		s.beginTransaction();
		UserDetails retreived = (UserDetails) s.get(UserDetails.class, 1);
		System.out.println(retreived);
		s.getTransaction().commit();
		s.close();
	}

	private static Set<Address> getAddress(){
		Set<Address> set = new HashSet<Address>();
		Address address = new Address();
		address.setCity("Kyiv");
		address.setStreet("Radyscheva");
		set.add(address);
		address = new Address();
		address.setCity("Dnepr");
		address.setStreet("Guli Korolyovoy");
		set.add(address);
		return set;
	}
}

