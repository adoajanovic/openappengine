/**
 * 
 */
package com.openappengine.service.fms;

import com.openappengine.model.fms.FleetVehicleType;

/**
 * @author hrishi
 *
 */
public class FleetVehicleService {
	
	private FleetVehicleRepository fleetVehicleRepository = new FleetVehicleRepositoryImpl();
	
	private FleetVehicleType fleetVehicleType;
	
	public void addFleetVehicleType() {
		try {
			fleetVehicleRepository.saveFleetVehicleType(fleetVehicleType);
		} catch (FleetVehicleRepositoryException e) {
			//TODO.
		}
	}
	
	public void addFleetVehicle() {
		
	}
	
	public void updateFleetVehicleInfo() {
		
	}
	
	public void discontinueFleetVehicle() {
		
	}

	public FleetVehicleType getFleetVehicleType() {
		return fleetVehicleType;
	}

	public void setFleetVehicleType(FleetVehicleType fleetVehicleType) {
		this.fleetVehicleType = fleetVehicleType;
	}

}
