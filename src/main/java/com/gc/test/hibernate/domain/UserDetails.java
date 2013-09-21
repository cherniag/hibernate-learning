package com.gc.test.hibernate.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserDetails {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int userId;
	@Column(name = "USER_NAME")
	private String userName;
	
	@OneToMany(mappedBy="userDetails")
//	@JoinTable(name="USER_VEHICLES",
//			joinColumns=@JoinColumn(name="USER_ID"),
//			inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public UserDetails setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicle) {
		this.vehicles = vehicle;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName
				+ ", vehicle=" + vehicles + "]";
	}

}
