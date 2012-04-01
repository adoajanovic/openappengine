

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the fms_fleet_vehicle_type database table.
 * 
 */
@Entity
@Table(name="fms_fleet_vehicle_type")
public class FmsFleetVehicleType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="FT_FLEET_VEHICLE_TYPE_ID")
	private int ftFleetVehicleTypeId;

	@Column(name="FT_FLEET_TYPE_DESC")
	private String ftFleetTypeDesc;

	//bi-directional many-to-one association to FmsFleetVehicle
	@OneToMany(mappedBy="fmsFleetVehicleType")
	private Set<FmsFleetVehicle> fmsFleetVehicles;

    public FmsFleetVehicleType() {
    }

	public int getFtFleetVehicleTypeId() {
		return this.ftFleetVehicleTypeId;
	}

	public void setFtFleetVehicleTypeId(int ftFleetVehicleTypeId) {
		this.ftFleetVehicleTypeId = ftFleetVehicleTypeId;
	}

	public String getFtFleetTypeDesc() {
		return this.ftFleetTypeDesc;
	}

	public void setFtFleetTypeDesc(String ftFleetTypeDesc) {
		this.ftFleetTypeDesc = ftFleetTypeDesc;
	}

	public Set<FmsFleetVehicle> getFmsFleetVehicles() {
		return this.fmsFleetVehicles;
	}

	public void setFmsFleetVehicles(Set<FmsFleetVehicle> fmsFleetVehicles) {
		this.fmsFleetVehicles = fmsFleetVehicles;
	}
	
}