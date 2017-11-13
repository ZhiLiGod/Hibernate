package com.zhi.hibernate.pojo;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//继承关系表现在同一个表 子类和父类在一个表
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(
//		name="vehicle_type",
//		discriminatorType=DiscriminatorType.STRING
//		)
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy=InheritanceType.JOINED)
public class Vehicle {
	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
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
