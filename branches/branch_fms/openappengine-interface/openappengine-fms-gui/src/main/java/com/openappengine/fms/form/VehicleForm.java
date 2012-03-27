/**
 * 
 */
package com.openappengine.fms.form;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.CalendarButton;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.Form;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.TextInput;

import com.openappengine.fms.facade.FleetManagerFacade;
import com.openappengine.fms.facade.FleetManagerFacadeImpl;
import com.openappengine.model.fms.FleetVehicle;
import com.openappengine.model.fms.FleetVehicleType;
import com.openappengine.service.api.ServiceDispatcher;
import com.openappengine.service.api.ServiceEngineContext;
import com.openappengine.service.api.ServiceException;
import com.openappengine.utility.DateTimeUtil;

/**
 * @author hrishi
 *
 */
public class VehicleForm extends Form implements Bindable {

	private FleetManagerFacade fleetManagerFacade = new FleetManagerFacadeImpl();
	
	@BXML
	private ListButton vehicleType;
	@BXML
	private CalendarButton fromDate;
	@BXML
	private CalendarButton toDate;
	@BXML
	private TextInput licencePlateNumberTextInput;
	@BXML
	private TextInput makeTextInput;
	@BXML
	private TextInput vehicleModelTextInput;
	@BXML
	private Button saveButton;

	private List<FleetVehicleType> vehicleTypes;
	
	@Override
	public void initialize(Map<String, Object> namespace, URL location,Resources resources) {

		if(namespace.get("VehicleId") != null) {
			Integer vehicleId = (Integer) namespace.get("VehicleId");
			FleetVehicle fleetVehicle = fleetManagerFacade.getFleetVehicle(vehicleId);
			if(fleetVehicle != null) {
				vehicleType.setButtonData(fleetVehicle.getType().getFleetVehicleTypeDesc());
				fromDate.setSelectedDate(DateTimeUtil.toDateString(fleetVehicle.getFromDate(), "yyyy-MM-dd"));
				toDate.setSelectedDate(DateTimeUtil.toDateString(fleetVehicle.getToDate(), "yyyy-MM-dd"));
				licencePlateNumberTextInput.setText(fleetVehicle.getLicensePlateNumber());
				makeTextInput.setText(fleetVehicle.getVehicleMake());
				vehicleModelTextInput.setText(fleetVehicle.getVehicleModel());
			}
		} else {
			populateForm_NewMode();
		}


		//Save
		initSaveButton();
	}

	private void populateForm_NewMode() {
		//vehicleType - ListButton
		ArrayList<String> listData = new ArrayList<String>();
		vehicleTypes = fleetManagerFacade.getAllFleetVehicleTypes();
		if(vehicleTypes != null) {
			for (FleetVehicleType fleetVehicleType : vehicleTypes) {
				listData.add(fleetVehicleType.getFleetVehicleTypeDesc());
			}
		}
		vehicleType.setListData(listData);
		
		//fromDate
		Date fromDt = new Date();
		Date toDt = DateUtils.addYears(fromDt, 1);
		fromDate.setSelectedDate(DateTimeUtil.toDateString(fromDt, "yyyy-MM-dd"));
		
		//toDate
		toDate.setSelectedDate(DateTimeUtil.toDateString(toDt, "yyyy-MM-dd"));
	}

	private void initSaveButton() {
		saveButton.setAction(new Action() {
					
					@Override
					public void perform(Component component) {
						FleetVehicle fleetVehicle = new FleetVehicle();
						
						ServiceDispatcher defaultServiceDispatcher = ServiceEngineContext.getDefaultServiceDispatcher();
						java.util.Map<String, Object> params = new HashMap<String, Object>();
						
						fleetVehicle.setFromDate(fromDate.getSelectedDate().toCalendar().getTime());
						fleetVehicle.setToDate(toDate.getSelectedDate().toCalendar().getTime());
						fleetVehicle.setLicensePlateNumber(licencePlateNumberTextInput.getText());
						fleetVehicle.setVehicleMake(makeTextInput.getText());
						fleetVehicle.setVehicleModel(vehicleModelTextInput.getText());
						
						int idx = vehicleType.getSelectedIndex();
						if(idx >= -1) {
							FleetVehicleType fleetVehicleType = vehicleTypes.get(idx);
							fleetVehicle.setType(fleetVehicleType);
						} else {
							//TODO
						}
						fleetVehicle.setStatus("ACTIVE");
						
						params.put("fleetVehicle", fleetVehicle);
						try {
							defaultServiceDispatcher.runSync("fms.addFleetVehicle", params);
						} catch (ServiceException e) {
							//TODO
							e.printStackTrace();
						}
					}
				});
	}

}
