/**
 * 
 */
package com.openappengine.fms.form;

import java.net.URL;
import java.util.HashMap;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.Form;
import org.apache.pivot.wtk.TextInput;

import com.openappengine.fms.facade.FleetManagerFacade;
import com.openappengine.fms.facade.FleetManagerFacadeImpl;
import com.openappengine.model.fms.FleetVehicleType;
import com.openappengine.service.api.ServiceDispatcher;
import com.openappengine.service.api.ServiceEngineContext;
import com.openappengine.service.api.ServiceException;

/**
 * @author hrishi
 *
 */
public class VehicleTypeDetailForm extends Form implements Bindable {

	protected static final String PARAM_FLEET_VEHICLE_TYPE = "fleetVehicleType";

	private FleetManagerFacade fleetManagerFacade = new FleetManagerFacadeImpl();
	
	@BXML
	private TextInput fleetVehicleTypeDesc;
	
	@BXML
	private Button saveButton;
	
	@Override
	public void initialize(final Map<String, Object> namespace, URL location,Resources resources) {
		int vehicleTypeId = (Integer) namespace.get("VehicleTypeId");
		FleetVehicleType fleetVehicleType = fleetManagerFacade.findFleetVehicleType(vehicleTypeId);
		if(fleetVehicleType != null) {
			namespace.put(PARAM_FLEET_VEHICLE_TYPE, fleetVehicleType);
			fleetVehicleTypeDesc.setText(fleetVehicleType.getFleetVehicleTypeDesc());
		}
		
		saveButton.setAction(new Action() {
			
			@Override
			public void perform(Component component) {
				FleetVehicleType fleetVehicleType = (FleetVehicleType) namespace.get(PARAM_FLEET_VEHICLE_TYPE);
				
				try {
					ServiceDispatcher defaultServiceDispatcher = ServiceEngineContext.getDefaultServiceDispatcher();
					java.util.Map<String, Object> params = new HashMap<String, Object>();
					fleetVehicleType.setFleetVehicleTypeDesc(fleetVehicleTypeDesc.getText());
					params.put(PARAM_FLEET_VEHICLE_TYPE, fleetVehicleType);
					
					
					java.util.Map<String, Object> resultMap;
					String serviceName;
					serviceName = "fms.updateFleetVehicleType";
					
					resultMap = defaultServiceDispatcher.runSync(serviceName, params);
					if(resultMap != null) {
						fleetVehicleType = (FleetVehicleType) resultMap.get(PARAM_FLEET_VEHICLE_TYPE);
						namespace.put(PARAM_FLEET_VEHICLE_TYPE, fleetVehicleType);
					}
				} catch (ServiceException e) {
					//TODO
				}
			}
		});
	}

}
