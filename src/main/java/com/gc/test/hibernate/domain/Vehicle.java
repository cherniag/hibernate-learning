package com.gc.test.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Vehicle {
	@Id
	@GeneratedValue(generator="hilo-gen")
	@GenericGenerator(name="hilo-gen", strategy="hilo")
	@Column(name="ID")
	private int vehicleId;
	
	@Column(name="NAME")
	private String vehicleName;
	
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

}
