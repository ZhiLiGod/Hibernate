package com.zhi.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zhi.hibernate.pojo.NewUser;

public class HibernateTest4 {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int minUserId = 15;
		//select username from NewUser where userId > 15
		//from NewUser where userId = :minUserId
		//setInteger("minUserId", minUserId);
		Query query = session.createQuery("from NewUser where userId = ?");
		query.setInteger(0, minUserId);
		//query.setString(1, null);Set String
//		query.setFirstResult(0);
//		query.setMaxResults(3);
		List<NewUser> users = query.list();
		System.out.println(users);
		session.getTransaction().commit();
		session.close();
		
	}
	
}
