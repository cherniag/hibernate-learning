package com.gc.test.hibernate.domain;

import javax.persistence.Entity;

@Entity
public class FourWeelerVehicle extends Vehicle {
	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

	@Override
	public String toString() {
		return "FourWeelerVehicle [steeringWheel=" + steeringWheel + "]";
	}
	
}
