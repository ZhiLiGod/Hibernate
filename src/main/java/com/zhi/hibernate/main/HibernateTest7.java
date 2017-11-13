package com.zhi.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zhi.hibernate.pojo.NewUser;

public class HibernateTest7 {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//second level cache
		NewUser user = session.get(NewUser.class, 15);
		
		Query query = session.createQuery("from NewUser user where user.userID = 12");
		query.setCacheable(true);
		//query2yeyao设置
		List<NewUser> users = query.list();
		
		
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		//second level cache
		NewUser user2 = session2.get(NewUser.class, 15);
		
		session2.getTransaction().commit();
		session2.close();
	}
	
}
