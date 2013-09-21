package com.gc.test.hibernate.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int vehicleId;
	
	@Column(name="NAME")
	private String vehicleName;
	@ManyToMany(mappedBy="vehicles")
	private Collection<UserDetails> userDetails=new ArrayList<UserDetails>();
	
	public Vehicle() {
	}
	
	public Vehicle(String vechicleName) {
		this.vehicleName = vechicleName;
	}

	public int getVechicleId() {
		return vehicleId;
	}
	public void setVechicleId(int vechicleId) {
		this.vehicleId = vechicleId;
	}
	public String getVechicleName() {
		return vehicleName;
	}
	public void setVechicleName(String vechicleName) {
		this.vehicleName = vechicleName;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName="
				+ vehicleName + "]";
	}

	public Collection<UserDetails> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Collection<UserDetails> userDetails) {
		this.userDetails = userDetails;
	}
}
