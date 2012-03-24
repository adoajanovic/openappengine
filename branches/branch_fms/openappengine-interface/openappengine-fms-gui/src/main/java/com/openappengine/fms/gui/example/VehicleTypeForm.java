/**
 * 
 */
package com.openappengine.fms.gui.example;

import java.net.URL;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.Form;
import org.apache.pivot.wtk.TextInput;

import com.openappengine.model.fms.FleetVehicleType;
import com.openappengine.service.api.ServiceDispatcher;
import com.openappengine.service.api.ServiceEngineContext;
import com.openappengine.service.api.ServiceException;

/**
 * @author hrishi
 *
 */
public class VehicleTypeForm extends Form implements Bindable {

	private static final String PARAM_FLEET_VEHICLE_TYPE = "fleetVehicleType";

	@BXML
	private TextInput vehicleTypeTextInput;
	
	@BXML
	private Button saveButton;
	
	@BXML
	private Button resetButton;
	
	@Override
	public void initialize(final Map<String, Object> context, URL url, Resources resources) {
		
		context.put(PARAM_FLEET_VEHICLE_TYPE, new FleetVehicleType());

		saveButton.setAction(new Action() {
			
			@Override
			public void perform(Component component) {
				System.out.println(vehicleTypeTextInput.getText());
				
				FleetVehicleType fleetVehicleType = (FleetVehicleType) context.get(PARAM_FLEET_VEHICLE_TYPE);
				
				try {
					ServiceDispatcher defaultServiceDispatcher = ServiceEngineContext.getDefaultServiceDispatcher();
					java.util.Map<String, Object> params = new HashMap<String, Object>();
					fleetVehicleType.setFleetVehicleTypeDesc(vehicleTypeTextInput.getText());
					params.put(PARAM_FLEET_VEHICLE_TYPE, fleetVehicleType);
					
					
					java.util.Map<String, Object> resultMap;
					String serviceName;
					if(fleetVehicleType.getFleetVehicleTypeId() == 0) {
						serviceName = "fms.addFleetVehicleType";
					} else {
						serviceName = "fms.updateFleetVehicleType";
					}
					
					resultMap = defaultServiceDispatcher.runSync(serviceName, params);
					if(resultMap != null) {
						fleetVehicleType = (FleetVehicleType) resultMap.get(PARAM_FLEET_VEHICLE_TYPE);
						context.put(PARAM_FLEET_VEHICLE_TYPE, fleetVehicleType);
					}
				} catch (ServiceException e) {
					//TODO
				}
			}
		});
		
		resetButton.setAction(new Action() {
			
			@Override
			public void perform(Component arg0) {
				vehicleTypeTextInput.setText("");
			}
		});
		
	}
	
}
