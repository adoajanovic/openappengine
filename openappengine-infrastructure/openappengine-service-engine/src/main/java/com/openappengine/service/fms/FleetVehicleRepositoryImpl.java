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

	@Override
	public List<FleetVehicle> fetchAllFleetVehicles() {
		String sqlFetch = "SELECT FV_VEHICLE_ID, FT_FLEET_TYPE_DESC, FV_TYPE_ID, FV_VEHICLE_MODEL, FV_VEHICLE_MAKE, FV_LICENCE_PLATE_NUMBER, FV_FROM_DATE, FV_TO_DATE, FV_STATUS FROM fms_fleet_vehicle INNER JOIN fms_fleet_vehicle_type ON FT_FLEET_VEHICLE_TYPE_ID = FV_TYPE_ID WHERE FV_STATUS = ?";
		List<FleetVehicle> list = jdbcTemplate.query(sqlFetch, new Object[]{"ACTIVE"}, new RowMapper<FleetVehicle>() {

			@Override
			public FleetVehicle mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				FleetVehicle f = new FleetVehicle();
				f.setFromDate(rs.getDate("FV_FROM_DATE"));
				f.setToDate(rs.getDate("FV_TO_DATE"));
				f.setLicensePlateNumber(rs.getString("FV_LICENCE_PLATE_NUMBER"));
				f.setStatus(rs.getString("FV_STATUS"));
				FleetVehicleType type = new FleetVehicleType();
				type.setFleetVehicleTypeDesc(rs.getString("FT_FLEET_TYPE_DESC"));
				type.setFleetVehicleTypeId(rs.getInt("FV_TYPE_ID"));
				f.setType(type);
				f.setVehicleId(rs.getInt("FV_VEHICLE_ID"));
				f.setVehicleMake(rs.getString("FV_VEHICLE_MAKE"));
				f.setVehicleModel(rs.getString("FV_VEHICLE_MODEL"));
				return f;
			}
		});
		return list;
	}
	
}
