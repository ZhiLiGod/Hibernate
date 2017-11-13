package com.zhi.hibernate.pojo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Items {
	
	@Id
	private int itemId;
	private String itemName;
	@ManyToMany(mappedBy="items")
	private Collection<UserDetail> users = new ArrayList<UserDetail>();
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Collection<UserDetail> getUsers() {
		return users;
	}
	public void setUsers(Collection<UserDetail> users) {
		this.users = users;
	}
	
}
