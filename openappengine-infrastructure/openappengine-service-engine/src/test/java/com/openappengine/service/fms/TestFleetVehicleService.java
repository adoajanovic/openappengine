/**
 * 
 */
package com.openappengine.service.fms;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.openappengine.model.fms.FleetVehicleType;
import com.openappengine.service.fms.FleetVehicleService;

/**
 * @author hrishi
 *
 */
public class TestFleetVehicleService {
	
	private FleetVehicleService fleetVehicleService;
	
	@Before
	public void init() {
		new ClassPathXmlApplicationContext("service-engine-context.xml");
		fleetVehicleService = new FleetVehicleService();
	}
	
	@Test
	public void testAddFleetVehicleType() {
		FleetVehicleType fleetVehicleType = new FleetVehicleType();
		fleetVehicleType.setFleetVehicleTypeDesc("School Bus");
		fleetVehicleService.setFleetVehicleType(fleetVehicleType);
		fleetVehicleService.addFleetVehicleType();
	}
	
}
