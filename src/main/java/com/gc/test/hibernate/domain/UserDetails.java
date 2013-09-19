package com.gc.test.hibernate.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	@OneToOne(cascade={CascadeType.ALL}) //UserDetails is owner of relationship - it has column with vehicle_id
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;
	
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
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName
				+ ", vehicle=" + vehicle + "]";
	}

}
