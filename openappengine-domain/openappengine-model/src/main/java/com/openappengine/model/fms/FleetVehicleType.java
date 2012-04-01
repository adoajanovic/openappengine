/**
 * 
 */
package com.openappengine.model.fms;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class FleetVehicleType implements Serializable {
	
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
	
}
