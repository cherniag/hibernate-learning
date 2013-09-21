package com.gc.test.hibernate;

import static org.hibernate.criterion.Restrictions.*;

import java.io.IOException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

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
		//criteria.add(eq("userName", "user10"));     // = " where userName = 'user10' "
		criteria.add(
				or(
						eq("userName", "user4"),
						eq("userName", "user10")
				   )
				);     // = " where userName = 'user10' or userName = 'user4' "
		System.out.println(criteria.list());
		s.getTransaction().commit();
		s.close();
	}
}
