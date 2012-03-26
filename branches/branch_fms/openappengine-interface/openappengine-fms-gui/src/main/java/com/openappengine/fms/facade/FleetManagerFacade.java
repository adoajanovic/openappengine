/**
 * 
 */
package com.openappengine.fms.facade;

import java.util.List;

import com.openappengine.model.fms.FleetVehicle;
import com.openappengine.model.fms.FleetVehicleType;

/**
 * @author hrishi
 *
 */
public interface FleetManagerFacade {
	
	List<FleetVehicleType> getAllFleetVehicleTypes();
	
	FleetVehicleType findFleetVehicleType(Integer vehicletTypeId);

	List<FleetVehicle> getAllFleetVehicles();
}
