/**
 * 
 */
package com.openappengine.service.fms;

import com.openappengine.model.fms.FleetVehicleType;
import com.openappengine.repository.GenericRepository;

/**
 * @author hrishi
 *
 */
public class FleetVehicleRepositoryImpl extends GenericRepository implements FleetVehicleRepository {

	@Override
	public void saveFleetVehicleType(FleetVehicleType fleetVehicleType) throws FleetVehicleRepositoryException {
		String sqlInsertFleetVehicleType = "INSERT INTO fms_fleet_vehicle_type(FT_FLEET_VEHICLE_TYPE_ID, FT_FLEET_TYPE_DESC) VALUES(?,?)";
		int fleetVehicleTypeId = incrementer.nextValue("fms_fleet_vehicle_type_sequence");
		int rowsUpdated = jdbcTemplate.update(sqlInsertFleetVehicleType, new Object[]{fleetVehicleTypeId,fleetVehicleType.getFleetVehicleTypeDesc()});
		if(rowsUpdated > 0) {
			logger.debug("FleetVehicleType inserted.");
			fleetVehicleType.setFleetVehicleTypeId(fleetVehicleTypeId);
		}
	}

	@Override
	public void updateFleetVehicleType(FleetVehicleType fleetVehicleType) {
		// TODO Auto-generated method stub
	}

	
}
