/**
 * 
 */
package com.openappengine.fms.form;

import java.net.URL;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.HashMap;
import org.apache.pivot.collections.List;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Form;
import org.apache.pivot.wtk.TableView;

import com.openappengine.fms.facade.FleetManagerFacade;
import com.openappengine.fms.facade.FleetManagerFacadeImpl;
import com.openappengine.model.fms.FleetVehicle;

/**
 * @author hrishikesh.joshi
 * @since  Mar 26, 2012
 *
 */
public class VehicleListingForm extends Form implements Bindable {
	
	@BXML
	private TableView vehicleTableView;

	private FleetManagerFacade fleetManagerFacade = new FleetManagerFacadeImpl();
	
	@Override
	public void initialize(Map<String, Object> namespace, URL location,
			Resources resources) {
		
		List<HashMap<String, Object>> tableData = new ArrayList<HashMap<String,Object>>();
		java.util.List<FleetVehicle> fleetVehicles = fleetManagerFacade.getAllFleetVehicles();
		if(fleetVehicles != null) {
			for (FleetVehicle f : fleetVehicles) {
				HashMap<String, Object> row = new HashMap<String, Object>();
				row.put("VehicleId", f.getVehicleId());
				row.put("VehicleType", f.getType().getFleetVehicleTypeDesc());
				row.put("Model", f.getVehicleModel());
				row.put("Make", f.getVehicleMake());
				row.put("LicensePlateNo", f.getLicensePlateNumber());
				row.put("FromDate", f.getFromDate());
				row.put("ToDate", f.getToDate());
				row.put("Status", f.getStatus());

				tableData.add(row);
			}
		}
		vehicleTableView.setTableData(tableData);
	}
	
	

}
