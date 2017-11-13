package com.zhi.hibernate.pojo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//配合single——table
//@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {
	
	private String SteeringWheel;

	public String getSteeringWheel() {
		return SteeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		SteeringWheel = steeringWheel;
	}
	
	
}
