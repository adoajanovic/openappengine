/**
 * 
 */
package com.openappengine.fms.gui.example;

import java.net.URL;
import java.util.HashMap;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.List;
import org.apache.pivot.collections.Map;
import org.apache.pivot.collections.Sequence;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.ComponentDataListener;
import org.apache.pivot.wtk.ComponentMouseButtonListener;
import org.apache.pivot.wtk.Container;
import org.apache.pivot.wtk.Form;
import org.apache.pivot.wtk.LinkButton;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.Span;
import org.apache.pivot.wtk.TabPane;
import org.apache.pivot.wtk.TableView;
import org.apache.pivot.wtk.TableViewRowListener;
import org.apache.pivot.wtk.TableViewSelectionListener;
import org.apache.pivot.wtk.TextInput;
import org.apache.pivot.wtk.Window;
import org.apache.pivot.wtk.content.TableViewRowEditor;

import com.openappengine.fms.facade.FleetManagerFacade;
import com.openappengine.fms.facade.FleetManagerFacadeImpl;
import com.openappengine.fms.util.PivotUtils;
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
	
	@BXML
	private TableView vehicleTypeTableView;
	
	private FleetManagerFacade fleetManagerFacade = new FleetManagerFacadeImpl();
	
	@Override
	public void initialize(final Map<String, Object> context, URL url, Resources resources) {
		
		populateFleetVehicleTypesTableData();
		
		vehicleTypeTableView.getTableViewSelectionListeners().add(new TableViewSelectionListener() {
			
			@Override
			public void selectedRowChanged(TableView tableView,Object previousSelectedRow) {
				Map<String, Object> selectedRow = (Map<String, Object>) tableView.getSelectedRow();
				if(selectedRow == null) {
					return;
				}
				
				org.apache.pivot.collections.HashMap<String, Object> namespace = new org.apache.pivot.collections.HashMap<String, Object>();
				namespace.put("VehicleTypeId", selectedRow.get("VehicleTypeId"));
				PivotUtils.addTab(VehicleTypeForm.this, "VehicleTypeDetail.bxml",namespace,(String) selectedRow.get("VehicleType"));
			}

			@Override
			public void selectedRangesChanged(TableView tableView,Sequence<Span> previousSelectedRanges) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void selectedRangeRemoved(TableView tableView, int rangeStart,int rangeEnd) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void selectedRangeAdded(TableView tableView, int rangeStart,int rangeEnd) {
				// TODO Auto-generated method stub
			}
		});
		
		saveButton.setAction(new Action() {
			
			@Override
			public void perform(Component component) {
				FleetVehicleType fleetVehicleType = new FleetVehicleType();
				
				try {
					ServiceDispatcher defaultServiceDispatcher = ServiceEngineContext.getDefaultServiceDispatcher();
					java.util.Map<String, Object> params = new HashMap<String, Object>();
					fleetVehicleType.setFleetVehicleTypeDesc(vehicleTypeTextInput.getText());
					params.put(PARAM_FLEET_VEHICLE_TYPE, fleetVehicleType);
					
					
					java.util.Map<String, Object> resultMap;
					String serviceName;
					serviceName = "fms.addFleetVehicleType";
					
					resultMap = defaultServiceDispatcher.runSync(serviceName, params);
					if(resultMap != null) {
						fleetVehicleType = (FleetVehicleType) resultMap.get(PARAM_FLEET_VEHICLE_TYPE);
						context.put(PARAM_FLEET_VEHICLE_TYPE, fleetVehicleType);
					}
					populateFleetVehicleTypesTableData();
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

	private void populateFleetVehicleTypesTableData() {
		List<org.apache.pivot.collections.HashMap<String, Object>> tableData = new ArrayList<org.apache.pivot.collections.HashMap<String, Object>>();
		
		java.util.List<FleetVehicleType> fleetVehicleTypes = fleetManagerFacade.getAllFleetVehicleTypes();
		if(fleetVehicleTypes != null) {
			for (FleetVehicleType fleetVehicleType : fleetVehicleTypes) {
				org.apache.pivot.collections.HashMap<String, Object> rowData = new org.apache.pivot.collections.HashMap<String, Object>();
				rowData.put("VehicleTypeId", fleetVehicleType.getFleetVehicleTypeId());
				rowData.put("VehicleType", fleetVehicleType.getFleetVehicleTypeDesc());
				tableData.add(rowData);
			}
		}
		vehicleTypeTableView.setTableData(tableData);
	}
	
}
