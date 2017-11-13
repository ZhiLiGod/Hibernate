package com.zhi.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zhi.hibernate.pojo.NewUser;

public class HibernateTest3 {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		NewUser user = null;
		user = session.get(NewUser.class, 12);
		System.out.println(user);
		session.delete(user);
		session.getTransaction().commit();

		session.close();
	}
}
