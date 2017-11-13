package com.zhi.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zhi.hibernate.pojo.NewUser;

public class HibernateTest6 {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//first level cache
		NewUser user = session.get(NewUser.class, 15);
		user.setUsername("updated username");
		NewUser user1 = session.get(NewUser.class, 15);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
}
