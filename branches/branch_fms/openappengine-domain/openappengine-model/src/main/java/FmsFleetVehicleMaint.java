

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the fms_fleet_vehicle_maint database table.
 * 
 */
@Entity
@Table(name="fms_fleet_vehicle_maint")
public class FmsFleetVehicleMaint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="FM_MAINT_ID")
	private int fmMaintId;

	@Column(name="FM_MAINT_COST")
	private BigDecimal fmMaintCost;

	@Column(name="FM_MAINT_ORDER_ID")
	private int fmMaintOrderId;

	@Column(name="FM_MAINT_STATUS")
	private String fmMaintStatus;

	@Column(name="FM_VEHICLE_ID")
	private int fmVehicleId;

	//bi-directional many-to-one association to FmsFleetVehicleMaintType
    @ManyToOne
	@JoinColumn(name="FM_MAINT_TYPE_ID")
	private FmsFleetVehicleMaintType fmsFleetVehicleMaintType;

    public FmsFleetVehicleMaint() {
    }

	public int getFmMaintId() {
		return this.fmMaintId;
	}

	public void setFmMaintId(int fmMaintId) {
		this.fmMaintId = fmMaintId;
	}

	public BigDecimal getFmMaintCost() {
		return this.fmMaintCost;
	}

	public void setFmMaintCost(BigDecimal fmMaintCost) {
		this.fmMaintCost = fmMaintCost;
	}

	public int getFmMaintOrderId() {
		return this.fmMaintOrderId;
	}

	public void setFmMaintOrderId(int fmMaintOrderId) {
		this.fmMaintOrderId = fmMaintOrderId;
	}

	public String getFmMaintStatus() {
		return this.fmMaintStatus;
	}

	public void setFmMaintStatus(String fmMaintStatus) {
		this.fmMaintStatus = fmMaintStatus;
	}

	public int getFmVehicleId() {
		return this.fmVehicleId;
	}

	public void setFmVehicleId(int fmVehicleId) {
		this.fmVehicleId = fmVehicleId;
	}

	public FmsFleetVehicleMaintType getFmsFleetVehicleMaintType() {
		return this.fmsFleetVehicleMaintType;
	}

	public void setFmsFleetVehicleMaintType(FmsFleetVehicleMaintType fmsFleetVehicleMaintType) {
		this.fmsFleetVehicleMaintType = fmsFleetVehicleMaintType;
	}
	
}