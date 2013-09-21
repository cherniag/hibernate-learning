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
		/*
		 	select userName from UserDetails					- list of String
		 	select userName, userId from UserDetails 			- list of Object[]
		 	select max(userName) from UserDetails				- max userName - user9
		 	select new UserDetails(userName) from UserDetails   - list of UserDetails (can be others classes with 
		 															constructors)
		*/
		Query query = s.createQuery("from UserDetails");
		query.setFirstResult(0);// start from
		query.setMaxResults(3); // results count
		System.out.println(query.list());
		s.getTransaction().commit();
		s.close();

	}

}
