package com.zhi.hibernate.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.zhi.hibernate.pojo.NewUser;

public class HibernateTest5 {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//user criteria
		Criteria criteria = session.createCriteria(NewUser.class)
				.setProjection(Projections.property("userId"))//only one property instead of all properties
				.addOrder(Order.desc("userId"));
				//.max("userId");
				//.count("userId");
		criteria.add(Restrictions.eq("username", "user5"))
				.add(Restrictions.gt("userId", 2))
				.add(Restrictions.like("username", "%user%"));//greater
		
		List<NewUser> users = criteria.list();
		System.out.println(users);
		session.getTransaction().commit();
		session.close();
		
	}
	
}
