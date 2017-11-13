package com.zhi.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zhi.hibernate.pojo.UserDetail;
import com.zhi.hibernate.pojo.Vehicle;
import com.zhi.hibernate.pojo.Vehicle1;

public class HibernateTest1 {
	public static void main(String[] args) {
		
		UserDetail user = new UserDetail();
		Vehicle vehicle = new Vehicle();
		Vehicle1 vehicle1 = new Vehicle1();
		vehicle1.setVehicleName("haha1");
		vehicle1.setUser(user);
		user.setUserName("lizhi1");
		vehicle.setVehicleName("car1");
		user.setVehicle(vehicle);
		user.getVehicle1().add(vehicle1);
		SessionFactory sessionFactory = new Configuration()
							.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(vehicle1);
		session.getTransaction().commit();
		session.close();
	}
}
