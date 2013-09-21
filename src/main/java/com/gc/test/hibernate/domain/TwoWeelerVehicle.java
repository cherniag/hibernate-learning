package com.gc.test.hibernate.domain;

import javax.persistence.Entity;

@Entity
public class TwoWeelerVehicle extends Vehicle {
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

	@Override
	public String toString() {
		return "TwoWeelerVehicle [steeringHandle=" + steeringHandle + "]";
	}
	
}
