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
import org.apache.pivot.collections.Sequence;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Form;
import org.apache.pivot.wtk.Span;
import org.apache.pivot.wtk.TableView;
import org.apache.pivot.wtk.TableViewSelectionListener;

import com.openappengine.fms.facade.FleetManagerFacade;
import com.openappengine.fms.facade.FleetManagerFacadeImpl;
import com.openappengine.fms.util.PivotUtils;
import com.openappengine.model.fms.FleetVehicle;

/**
 * @author hrishi
 *
 */
public class VehicleListingForm extends Form implements Bindable {
	
	@BXML
	private TableView vehicleTableView;
	
	private FleetManagerFacade fleetManagerFacade = new FleetManagerFacadeImpl();

	@Override
	public void initialize(Map<String, Object> namespace, URL location,Resources resources) {
		List<HashMap<String, Object>> tableData = new ArrayList<HashMap<String,Object>>();
		
		java.util.List<FleetVehicle> fleetVehicles = fleetManagerFacade.getAllFleetVehicles();
		if(fleetVehicles != null) {
			for (FleetVehicle fleetVehicle : fleetVehicles) {
				HashMap<String, Object> row = new HashMap<String, Object>();
				row.put("FromDate", fleetVehicle.getFromDate());
				row.put("ToDate", fleetVehicle.getToDate());
				row.put("VehicleId", fleetVehicle.getVehicleId());
				row.put("VehicleType", fleetVehicle.getType().getFleetVehicleTypeDesc());
				row.put("LicensePlateNo", fleetVehicle.getLicensePlateNumber());
				row.put("Make", fleetVehicle.getVehicleMake());
				row.put("Model", fleetVehicle.getVehicleModel());
				tableData.add(row);
			}
		}
		vehicleTableView.setTableData(tableData);
		
		vehicleTableView.getTableViewSelectionListeners().add(new TableViewSelectionListener() {
			
			@Override
			public void selectedRowChanged(TableView tableView,
					Object previousSelectedRow) {
				HashMap<String, Object> selectedRow = (HashMap<String, Object>) tableView.getSelectedRow();
				Integer vehicleId = (Integer) selectedRow.get("VehicleId");
				
				HashMap<String, Object> namespace = new HashMap<String, Object>();
				namespace.put("VehicleId", vehicleId);
				PivotUtils.addTab(VehicleListingForm.this, "Vehicle.bxml",namespace,(String) selectedRow.get("LicensePlateNo"));
			}
			
			@Override
			public void selectedRangesChanged(TableView tableView,
					Sequence<Span> previousSelectedRanges) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void selectedRangeRemoved(TableView tableView, int rangeStart,
					int rangeEnd) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void selectedRangeAdded(TableView tableView, int rangeStart,
					int rangeEnd) {
				// TODO Auto-generated method stub
			}
		});
	}

}
