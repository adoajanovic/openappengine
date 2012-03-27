/**
 * 
 */
package com.openappengine.service.fms;

import org.apache.commons.lang.StringUtils;

import com.openappengine.model.fms.FleetVehicle;
import com.openappengine.model.fms.FleetVehicleType;
import com.openappengine.service.AbstractDomainService;

/**
 * @author hrishi
 *
 */
public class FleetVehicleService extends AbstractDomainService {
	
	private FleetVehicleRepository fleetVehicleRepository = new FleetVehicleRepositoryImpl();
	
	private FleetVehicleType fleetVehicleType;

	private FleetVehicle fleetVehicle;
	
	public void addFleetVehicleType() {
		try {
			fleetVehicleRepository.saveFleetVehicleType(fleetVehicleType);
		} catch (FleetVehicleRepositoryException e) {
			//TODO.
		}
	}
	
	public void addFleetVehicle() {
		try {
			if(StringUtils.isEmpty(getFleetVehicle().getStatus())) {
				getFleetVehicle().setStatus(FleetVehicle.FleetVehicleStatus.ACTIVE.toString());
			}
			fleetVehicleRepository.saveFleetVehicle(getFleetVehicle());
		} catch (FleetVehicleRepositoryException e) {
			// TODO
		}	
	}
	
	public void updateFleetVehicleInfo() {
		fleetVehicleRepository.updateFleetVehicleType(fleetVehicleType);
	}
	
	public void discontinueFleetVehicle() {
		
	}

	public FleetVehicleType getFleetVehicleType() {
		return fleetVehicleType;
	}

	public void setFleetVehicleType(FleetVehicleType fleetVehicleType) {
		this.fleetVehicleType = fleetVehicleType;
	}

	public FleetVehicle getFleetVehicle() {
		return fleetVehicle;
	}

	public void setFleetVehicle(FleetVehicle fleetVehicle) {
		this.fleetVehicle = fleetVehicle;
	}

}
