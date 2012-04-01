

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the fms_fleet_vehicle_std_cost_type database table.
 * 
 */
@Entity
@Table(name="fms_fleet_vehicle_std_cost_type")
public class FmsFleetVehicleStdCostType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="CT_FLEET_STD_COST_TYPE_ID")
	private int ctFleetStdCostTypeId;

	@Column(name="CT_FLEET_STD_COST_TYPE_DESC")
	private String ctFleetStdCostTypeDesc;

	@Column(name="CT_HAS_TABLE")
	private String ctHasTable;

	@Column(name="CT_TABLE_NAME")
	private String ctTableName;

	//bi-directional many-to-one association to FmsFleetVehicleStdCost
	@OneToMany(mappedBy="fmsFleetVehicleStdCostType")
	private Set<FmsFleetVehicleStdCost> fmsFleetVehicleStdCosts;

    public FmsFleetVehicleStdCostType() {
    }

	public int getCtFleetStdCostTypeId() {
		return this.ctFleetStdCostTypeId;
	}

	public void setCtFleetStdCostTypeId(int ctFleetStdCostTypeId) {
		this.ctFleetStdCostTypeId = ctFleetStdCostTypeId;
	}

	public String getCtFleetStdCostTypeDesc() {
		return this.ctFleetStdCostTypeDesc;
	}

	public void setCtFleetStdCostTypeDesc(String ctFleetStdCostTypeDesc) {
		this.ctFleetStdCostTypeDesc = ctFleetStdCostTypeDesc;
	}

	public String getCtHasTable() {
		return this.ctHasTable;
	}

	public void setCtHasTable(String ctHasTable) {
		this.ctHasTable = ctHasTable;
	}

	public String getCtTableName() {
		return this.ctTableName;
	}

	public void setCtTableName(String ctTableName) {
		this.ctTableName = ctTableName;
	}

	public Set<FmsFleetVehicleStdCost> getFmsFleetVehicleStdCosts() {
		return this.fmsFleetVehicleStdCosts;
	}

	public void setFmsFleetVehicleStdCosts(Set<FmsFleetVehicleStdCost> fmsFleetVehicleStdCosts) {
		this.fmsFleetVehicleStdCosts = fmsFleetVehicleStdCosts;
	}
	
}