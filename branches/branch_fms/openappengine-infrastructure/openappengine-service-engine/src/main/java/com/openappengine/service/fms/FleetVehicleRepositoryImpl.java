/**
 * 
 */
package com.openappengine.service.fms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.openappengine.model.fms.FleetVehicle;
import com.openappengine.model.fms.FleetVehicleType;
import com.openappengine.repository.GenericRepository;

/**
 * @author hrishi
 *
 */
public class FleetVehicleRepositoryImpl extends GenericRepository implements FleetVehicleRepository {
	
	private RowMapper<FleetVehicleType> rowMapper = new RowMapper<FleetVehicleType>() {

		@Override
		public FleetVehicleType mapRow(ResultSet rs, int rowNum) throws SQLException {
			FleetVehicleType fleetVehicleType = new FleetVehicleType();
			fleetVehicleType.setFleetVehicleTypeId(rs.getInt("FT_FLEET_VEHICLE_TYPE_ID"));
			fleetVehicleType.setFleetVehicleTypeDesc(rs.getString("FT_FLEET_TYPE_DESC"));
			return fleetVehicleType;
		}
	};

	@Override
	public void saveFleetVehicleType(FleetVehicleType fleetVehicleType) throws FleetVehicleRepositoryException {
		String sqlInsertFleetVehicleType = "INSERT INTO fms_fleet_vehicle_type(FT_FLEET_VEHICLE_TYPE_ID, FT_FLEET_TYPE_DESC) VALUES(?,?)";
		int fleetVehicleTypeId = incrementer.nextValue("fms_fleet_vehicle_type_sequence");
		int rowsUpdated = jdbcTemplate.update(sqlInsertFleetVehicleType, new Object[]{fleetVehicleTypeId,fleetVehicleType.getFleetVehicleTypeDesc()});
		if(rowsUpdated > 0) {
			logger.debug("FleetVehicleType inserted.");
			fleetVehicleType.setFleetVehicleTypeId(fleetVehicleTypeId);
		}
	}

	@Override
	public void updateFleetVehicleType(FleetVehicleType fleetVehicleType) {
		String sqlInsertFleetVehicleType = "UPDATE fms_fleet_vehicle_type SET FT_FLEET_TYPE_DESC = ? WHERE FT_FLEET_VEHICLE_TYPE_ID = ?";
		int rowsUpdated = jdbcTemplate.update(sqlInsertFleetVehicleType, new Object[]{fleetVehicleType.getFleetVehicleTypeDesc(), fleetVehicleType.getFleetVehicleTypeId()});
		if(rowsUpdated > 0) {
			logger.debug("FleetVehicleType updated.");
		}
	}

	@Override
	public List<FleetVehicleType> fetchAllFleetVehicleTypes() {
		String sqlFetchAll = "SELECT FT_FLEET_VEHICLE_TYPE_ID, FT_FLEET_TYPE_DESC FROM fms_fleet_vehicle_type";
		List<FleetVehicleType> list = jdbcTemplate.query(sqlFetchAll, rowMapper);
		
		return list;
	}

	@Override
	public FleetVehicleType findFleetVehicleTypeById(Integer vehicleTypeId) {
		String sql = "SELECT FT_FLEET_VEHICLE_TYPE_ID, FT_FLEET_TYPE_DESC FROM fms_fleet_vehicle_type WHERE FT_FLEET_VEHICLE_TYPE_ID = ?";
		FleetVehicleType fleetVehicleType = jdbcTemplate.queryForObject(sql, new Object[]{vehicleTypeId} ,rowMapper);
		return fleetVehicleType;
	}

	@Override
	public void saveFleetVehicle(FleetVehicle fleetVehicle)
			throws FleetVehicleRepositoryException {
		
		int fleetVehicleTypeId = incrementer.nextValue("fms_fleet_vehicle_sequence");
		fleetVehicle.setVehicleId(fleetVehicleTypeId);
		
		String sqlInsertVehicle = "INSERT INTO fms_fleet_vehicle(FV_VEHICLE_ID, FV_TYPE_ID, FV_VEHICLE_MODEL, FV_VEHICLE_MAKE, FV_LICENCE_PLATE_NUMBER, FV_FROM_DATE, FV_TO_DATE, FV_STATUS) ";
		sqlInsertVehicle += " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsertVehicle, new Object[]{
			fleetVehicle.getVehicleId(),
			fleetVehicle.getType().getFleetVehicleTypeId(),
			fleetVehicle.getVehicleModel(),
			fleetVehicle.getVehicleMake(),
			fleetVehicle.getLicensePlateNumber(),
			fleetVehicle.getFromDate(),
			fleetVehicle.getToDate(),
			fleetVehicle.getStatus()
		});
	}
	
}
