package com.gc.test.hibernate;

import java.io.IOException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

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
		Criteria criteria = s.createCriteria(UserDetails.class); // = " from UserDetails "
		/*
		 		Projections.max("userId")
		 		Projections.count("userId")
		 		Projections.property("userId")  = select userId from UserDetails
		 		Projections.property("userId")
		 				   .setOrder(Order.desc("userId")); = select userId from UserDetails order by userId desc
		 */
		criteria.setProjection(Projections.property("userId"))
				.addOrder(Order.desc("userId")); // Projections.max("userId")
		
		/*criteria.add(like("userName", "user%"))
				  .add(gt("userId", 6));     // = " where userName like 'user%' AND userId > 6"
		*/
		
		
		System.out.println(criteria.list());
		s.getTransaction().commit();
		s.close();
	}
}
