package com.gc.test.hibernate;

import java.io.IOException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	@SuppressWarnings({ "deprecation" })
	private static SessionFactory sf = new Configuration().configure()
			.buildSessionFactory();

	public static void main(String[] args) throws IOException {

		Session s /*
				 * = sf.openSession(); s.beginTransaction(); for(int
				 * i=0;i<10;i++){ UserDetails user = new
				 * UserDetails().setUserName("user" + i); s.save(user); }
				 * s.getTransaction().commit(); s.close()
				 */;

		s = sf.openSession();
		s.beginTransaction();
		Query query = s.getNamedQuery("userdetails.byName");
		query.setString(0, "user7"); 
		System.out.println(query.list());
		s.getTransaction().commit();
		s.close();
	}
}
