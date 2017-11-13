package com.zhi.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zhi.hibernate.pojo.FourWheeler;
import com.zhi.hibernate.pojo.TwoWheeler;
import com.zhi.hibernate.pojo.Vehicle;

public class HibernateTest2 {
	
	public static void main(String[] args) {
		
		Vehicle v = new  Vehicle();
		TwoWheeler bike = new TwoWheeler();
		FourWheeler car = new FourWheeler();
		
		v.setVehicleName("car");
		bike.setSteeringHandler("Bike Steering");
		bike.setVehicleName("Bike");
		car.setVehicleName("Porsche");
		car.setSteeringWheel("Porsche Steering");
		
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(v);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();
	}
	
}
