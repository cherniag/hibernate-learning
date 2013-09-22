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

		Query query = s.createQuery("from UserDetails user where user.userId = 2");
		query.setCacheable(true);//need to be cacheable
		query.list();
		
		s.getTransaction().commit();
		s.close();
		
		s = sf.openSession();
		s.beginTransaction();
		Query query2 = s.createQuery("from UserDetails user where user.userId = 2");
		query2.setCacheable(true);//need to be cacheable
		query2.list();//only 1 select
		s.getTransaction().commit();
		s.close();
	}
}
