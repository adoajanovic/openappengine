/**
 * 
 */
package com.openappengine.service.fms;

import java.sql.SQLException;

/**
 * @author hrishi
 *
 */
public class FleetVehicleRepositoryException extends SQLException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public FleetVehicleRepositoryException() {
		
	}

	/**
	 * @param reason
	 */
	public FleetVehicleRepositoryException(String reason) {
		super(reason);
		
	}

	/**
	 * @param cause
	 */
	public FleetVehicleRepositoryException(Throwable cause) {
		super(cause);
		
	}

	/**
	 * @param reason
	 * @param SQLState
	 */
	public FleetVehicleRepositoryException(String reason, String SQLState) {
		super(reason, SQLState);
		
	}

	/**
	 * @param reason
	 * @param cause
	 */
	public FleetVehicleRepositoryException(String reason, Throwable cause) {
		super(reason, cause);
		
	}

	/**
	 * @param reason
	 * @param SQLState
	 * @param vendorCode
	 */
	public FleetVehicleRepositoryException(String reason, String SQLState,
			int vendorCode) {
		super(reason, SQLState, vendorCode);
		
	}

	/**
	 * @param reason
	 * @param sqlState
	 * @param cause
	 */
	public FleetVehicleRepositoryException(String reason, String sqlState,
			Throwable cause) {
		super(reason, sqlState, cause);
		
	}

	/**
	 * @param reason
	 * @param sqlState
	 * @param vendorCode
	 * @param cause
	 */
	public FleetVehicleRepositoryException(String reason, String sqlState,
			int vendorCode, Throwable cause) {
		super(reason, sqlState, vendorCode, cause);
	}

}
