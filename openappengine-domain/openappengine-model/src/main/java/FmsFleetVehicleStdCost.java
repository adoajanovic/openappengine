

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the fms_fleet_vehicle_std_cost database table.
 * 
 */
@Entity
@Table(name="fms_fleet_vehicle_std_cost")
public class FmsFleetVehicleStdCost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="SC_VEHICLE_STD_COST_ID")
	private int scVehicleStdCostId;

	@Column(name="SC_AMOUNT")
	private BigDecimal scAmount;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="SC_FROM_DATE")
	private Date scFromDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="SC_TO_DATE")
	private Date scToDate;

	@Column(name="SC_VEHICLE_ID")
	private int scVehicleId;

	//bi-directional many-to-one association to FmsFleetVehicleStdCostType
    @ManyToOne
	@JoinColumn(name="SC_VEHICLE_STD_COST_TYPE_ID")
	private FmsFleetVehicleStdCostType fmsFleetVehicleStdCostType;

    public FmsFleetVehicleStdCost() {
    }

	public int getScVehicleStdCostId() {
		return this.scVehicleStdCostId;
	}

	public void setScVehicleStdCostId(int scVehicleStdCostId) {
		this.scVehicleStdCostId = scVehicleStdCostId;
	}

	public BigDecimal getScAmount() {
		return this.scAmount;
	}

	public void setScAmount(BigDecimal scAmount) {
		this.scAmount = scAmount;
	}

	public Date getScFromDate() {
		return this.scFromDate;
	}

	public void setScFromDate(Date scFromDate) {
		this.scFromDate = scFromDate;
	}

	public Date getScToDate() {
		return this.scToDate;
	}

	public void setScToDate(Date scToDate) {
		this.scToDate = scToDate;
	}

	public int getScVehicleId() {
		return this.scVehicleId;
	}

	public void setScVehicleId(int scVehicleId) {
		this.scVehicleId = scVehicleId;
	}

	public FmsFleetVehicleStdCostType getFmsFleetVehicleStdCostType() {
		return this.fmsFleetVehicleStdCostType;
	}

	public void setFmsFleetVehicleStdCostType(FmsFleetVehicleStdCostType fmsFleetVehicleStdCostType) {
		this.fmsFleetVehicleStdCostType = fmsFleetVehicleStdCostType;
	}
	
}