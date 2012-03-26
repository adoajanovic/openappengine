/**
 * 
 */
package com.openappengine.model.fms;

import java.util.Date;

/**
 * @author hrishi
 *
 */
public class FleetVehicle {
	
	public static enum FleetVehicleStatus {
		ACTIVE,
		SUSPENDED,
	}
	
	private int vehicleId;
	
	private FleetVehicleType type;
	
	private String fleetVehicleType;
	
	private String status;
	
	private Date fromDate;
	
	private Date toDate;
	
	private String licensePlateNumber;
	
	private String vehicleModel;
	
	private String vehicleMake;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public FleetVehicleType getType() {
		return type;
	}

	public void setType(FleetVehicleType type) {
		this.type = type;
	}

	public String getFleetVehicleType() {
		return fleetVehicleType;
	}

	public void setFleetVehicleType(String fleetVehicleType) {
		this.fleetVehicleType = fleetVehicleType;
	}

}
