/**
 * 
 */
package com.openappengine.service.fms;

import com.openappengine.model.fms.FleetVehicleType;

/**
 * @author hrishi
 *
 */
public interface FleetVehicleRepository {

	/**
	 * Save Fleet Vehicle Type.
	 * @param fleetVehicleType
	 * @throws FleetVehicleRepositoryException 
	 */
	void saveFleetVehicleType(FleetVehicleType fleetVehicleType) throws FleetVehicleRepositoryException;
	
	void updateFleetVehicleType(FleetVehicleType fleetVehicleType);
	
}
