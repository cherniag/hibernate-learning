package com.gc.test.hibernate;

import java.io.IOException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

import com.gc.test.hibernate.domain.UserDetails;

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
		
		UserDetails exampleUserDetails = new UserDetails();
		/* 
		 	exampleUserDetails.setUserId(5) - Hibernate ignores @Id and null values
		 	exampleUserDetails.setUserName("user1%") = LIKE 'user1%' //need Example.create(...).enableLike();
		 */
		exampleUserDetails.setUserName("user1%"); 
		Example example = Example.create(exampleUserDetails).enableLike();
		Criteria criteria = s.createCriteria(UserDetails.class);
		criteria.add(example);
		
		System.out.println(criteria.list());
		s.getTransaction().commit();
		s.close();
	}
}
