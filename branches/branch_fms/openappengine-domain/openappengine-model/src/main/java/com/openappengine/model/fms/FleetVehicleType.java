/**
 * 
 */
package com.openappengine.model.fms;

import com.openappengine.model.valueobject.ValueObject;

/**
 * @author hrishi
 *
 */
public class FleetVehicleType implements ValueObject<FleetVehicleType>{
	
	private int fleetVehicleTypeId;
	
	private String fleetVehicleTypeDesc;

	public int getFleetVehicleTypeId() {
		return fleetVehicleTypeId;
	}

	public void setFleetVehicleTypeId(int fleetVehicleTypeId) {
		this.fleetVehicleTypeId = fleetVehicleTypeId;
	}

	public String getFleetVehicleTypeDesc() {
		return fleetVehicleTypeDesc;
	}

	public void setFleetVehicleTypeDesc(String fleetVehicleTypeDesc) {
		this.fleetVehicleTypeDesc = fleetVehicleTypeDesc;
	}

	@Override
	public boolean sameValueAs(FleetVehicleType other) {
		return this.equals(other);
	}

	
}
