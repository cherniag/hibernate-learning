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
		Query query = s.createQuery("from UserDetails where userId > ? and userName = :name");
		query.setInteger(0, 5); //position driven placeholder - for "?"
		query.setString("name", "user6");  //name driven placeholder - for ":name"
		System.out.println(query.list());
		s.getTransaction().commit();
		s.close();

	}

}
