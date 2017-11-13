package com.zhi.hibernate.pojo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class UserDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	@OneToOne
	@JoinColumn(name="vehicleId")
	private Vehicle vehicle;
	@OneToMany(mappedBy="user", cascade=CascadeType.PERSIST)//创建在一个表中 不是两个表
//	@JoinTable(name="user_vehicle", joinColumns=@JoinColumn(name="user_id"),
//				inverseJoinColumns=@JoinColumn(name="vehicle_id"))
	private Collection<Vehicle1> vehicle1 = new ArrayList<Vehicle1>();
	
	@ManyToMany
	private Collection<Items> items = new ArrayList<Items>();
	
	public Collection<Items> getItems() {
		return items;
	}
	public void setItems(Collection<Items> items) {
		this.items = items;
	}
	public Collection<Vehicle1> getVehicle1() {
		return vehicle1;
	}
	public void setVehicle1(Collection<Vehicle1> vehicle1) {
		this.vehicle1 = vehicle1;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


	
}
