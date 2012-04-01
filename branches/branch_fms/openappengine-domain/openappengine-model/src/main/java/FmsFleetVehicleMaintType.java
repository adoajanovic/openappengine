

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the fms_fleet_vehicle_maint_type database table.
 * 
 */
@Entity
@Table(name="fms_fleet_vehicle_maint_type")
public class FmsFleetVehicleMaintType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="VMT_FLEET_MAINT_TYPE_ID")
	private int vmtFleetMaintTypeId;

	@Column(name="VMT_FLEET_MAINT_TYPE_DESC")
	private String vmtFleetMaintTypeDesc;

	@Column(name="VMT_HAS_TABLE")
	private String vmtHasTable;

	@Column(name="VMT_TABLE_NAME")
	private String vmtTableName;

	//bi-directional many-to-one association to FmsFleetVehicleMaint
	@OneToMany(mappedBy="fmsFleetVehicleMaintType")
	private Set<FmsFleetVehicleMaint> fmsFleetVehicleMaints;

    public FmsFleetVehicleMaintType() {
    }

	public int getVmtFleetMaintTypeId() {
		return this.vmtFleetMaintTypeId;
	}

	public void setVmtFleetMaintTypeId(int vmtFleetMaintTypeId) {
		this.vmtFleetMaintTypeId = vmtFleetMaintTypeId;
	}

	public String getVmtFleetMaintTypeDesc() {
		return this.vmtFleetMaintTypeDesc;
	}

	public void setVmtFleetMaintTypeDesc(String vmtFleetMaintTypeDesc) {
		this.vmtFleetMaintTypeDesc = vmtFleetMaintTypeDesc;
	}

	public String getVmtHasTable() {
		return this.vmtHasTable;
	}

	public void setVmtHasTable(String vmtHasTable) {
		this.vmtHasTable = vmtHasTable;
	}

	public String getVmtTableName() {
		return this.vmtTableName;
	}

	public void setVmtTableName(String vmtTableName) {
		this.vmtTableName = vmtTableName;
	}

	public Set<FmsFleetVehicleMaint> getFmsFleetVehicleMaints() {
		return this.fmsFleetVehicleMaints;
	}

	public void setFmsFleetVehicleMaints(Set<FmsFleetVehicleMaint> fmsFleetVehicleMaints) {
		this.fmsFleetVehicleMaints = fmsFleetVehicleMaints;
	}
	
}