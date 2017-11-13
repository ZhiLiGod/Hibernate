package com.zhi.hibernate.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
//@Table(name="User_Details")//只针对table的名 hql就不行
public class Users {
	@Id
	@GeneratedValue//ascending
	private int userId;
	//@Column(name="uname")//rename
	//@Transient//忽略此field
	private String userName;
	@Temporal(TemporalType.DATE)//只保存日期 不加后面的时间 TIME:保存时间
	private Date joinDate;
	@Embedded
	private String address;
	@Lob//大数据
	private String description;
	private Set<Address> listOfAddresses = new HashSet<Address>();
	private Address add;
	@ElementCollection(fetch=FetchType.EAGER)//设置一个集合
	@JoinTable(name="user_address", 
				joinColumns=@JoinColumn(name="userId"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, 
				generator = "hilo-gen", 
				type = @Type(type="long"))
	public Set<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Set<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName
				+ ", joinDate=" + joinDate + ", address=" + address
				+ ", description=" + description + "]";
	}

	
	
}
