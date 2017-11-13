package com.zhi.hibernate.pojo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//配合single——table
//@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {
	
	private String SteeringHandler;

	public String getSteeringHandler() {
		return SteeringHandler;
	}

	public void setSteeringHandler(String steeringHandler) {
		SteeringHandler = steeringHandler;
	}
	
	
}
