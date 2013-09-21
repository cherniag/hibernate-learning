package com.gc.test.hibernate.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2w")
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
