/**
 * 
 */
package com.openappengine.service.fms;

import java.util.List;

import com.openappengine.model.fms.FleetVehicle;
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
	
	List<FleetVehicleType> fetchAllFleetVehicleTypes();
	
	FleetVehicleType findFleetVehicleTypeById(Integer vehicleTypeId);
	
	void saveFleetVehicle(FleetVehicle fleetVehicle) throws FleetVehicleRepositoryException;
	
	List<FleetVehicle> fetchAllFleetVehicles();
}
