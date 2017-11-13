package com.zhi.hibernate.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Vehicle1 {
	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE)//当找不到user时
	@JoinColumn(name="user_id")
	private UserDetail user;
	
	public UserDetail getUser() {
		return user;
	}
	public void setUser(UserDetail user) {
		this.user = user;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
}
