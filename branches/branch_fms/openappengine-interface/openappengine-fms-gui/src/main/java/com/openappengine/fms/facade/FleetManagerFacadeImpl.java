package com.openappengine.fms.facade;

import java.util.List;

import com.openappengine.model.fms.FleetVehicle;
import com.openappengine.model.fms.FleetVehicleType;
import com.openappengine.service.api.ServiceDispatcher;
import com.openappengine.service.api.ServiceEngineContext;
import com.openappengine.service.fms.FleetVehicleRepository;
import com.openappengine.service.fms.FleetVehicleRepositoryImpl;

public class FleetManagerFacadeImpl implements FleetManagerFacade {
	
	private ServiceDispatcher serviceDispatcher = ServiceEngineContext.getDefaultServiceDispatcher();
	
	private FleetVehicleRepository fleetVehicleRepository = new FleetVehicleRepositoryImpl();
	
	@Override
	public List<FleetVehicleType> getAllFleetVehicleTypes() {
		List<FleetVehicleType> vehicleTypes = fleetVehicleRepository.fetchAllFleetVehicleTypes();
		return vehicleTypes;
	}

	@Override
	public FleetVehicleType findFleetVehicleType(Integer vehicletTypeId) {
		FleetVehicleType fleetVehicleType = fleetVehicleRepository.findFleetVehicleTypeById(vehicletTypeId);
		return fleetVehicleType;
	}
	
	@Override
	public List<FleetVehicle> getAllFleetVehicles() {
		return fleetVehicleRepository.fetchAllFleetVehicles();
	}

	@Override
	public FleetVehicle getFleetVehicle(int fleetVehicleId) {
		Runtime runtime = Runtime.getRuntime();
		runtime.totalMemory();
		runtime.freeMemory();
		return fleetVehicleRepository.getFleetVehicleById(fleetVehicleId);
	}
}