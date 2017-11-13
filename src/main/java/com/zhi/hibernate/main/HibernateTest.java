package com.zhi.hibernate.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zhi.hibernate.pojo.Address;
import com.zhi.hibernate.pojo.Users;

public class HibernateTest {
	
	public static void main(String[] args) {
		
		Users user = new Users();
		Address addr = new Address();
		addr.setCity("Beijing");
		addr.setStreet("Street");
		addr.setPincode("110");
		addr.setState("BJ");
		
		Address addr1 = new Address();
		addr1.setCity("Beijing1");
		addr1.setStreet("Street1");
		addr1.setPincode("1101");
		addr1.setState("BJ1");
		//user.setUserId(100);
		user.setUserName("Danny");		
		user.setAddress("My Address");
		user.setJoinDate(new Date());
		user.setDescription("My Desc");
		user.setAdd(addr);
		user.getListOfAddresses().add(addr1);
		user.getListOfAddresses().add(addr);
		SessionFactory sessionFactory = new Configuration()
							.configure()
							.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
//		user = null;
//		Session session1 = sessionFactory.openSession();
//		session1.beginTransaction();
//		user = session1.get(Users.class, 100);
//		System.out.println(user);
//		session1.close();
	}
}
