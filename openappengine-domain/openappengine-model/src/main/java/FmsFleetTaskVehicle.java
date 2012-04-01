

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fms_fleet_task_vehicle database table.
 * 
 */
@Entity
@Table(name="fms_fleet_task_vehicle")
public class FmsFleetTaskVehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="FVH_FLEET_TASK_VEHICLE_ID")
	private int fvhFleetTaskVehicleId;

	//bi-directional many-to-one association to FmsFleetTask
    @ManyToOne
	@JoinColumn(name="FVH_TASK_ID")
	private FmsFleetTask fmsFleetTask;

	//bi-directional many-to-one association to FmsFleetVehicle
    @ManyToOne
	@JoinColumn(name="FVH_VEHICLE_ID")
	private FmsFleetVehicle fmsFleetVehicle;

    public FmsFleetTaskVehicle() {
    }

	public int getFvhFleetTaskVehicleId() {
		return this.fvhFleetTaskVehicleId;
	}

	public void setFvhFleetTaskVehicleId(int fvhFleetTaskVehicleId) {
		this.fvhFleetTaskVehicleId = fvhFleetTaskVehicleId;
	}

	public FmsFleetTask getFmsFleetTask() {
		return this.fmsFleetTask;
	}

	public void setFmsFleetTask(FmsFleetTask fmsFleetTask) {
		this.fmsFleetTask = fmsFleetTask;
	}
	
	public FmsFleetVehicle getFmsFleetVehicle() {
		return this.fmsFleetVehicle;
	}

	public void setFmsFleetVehicle(FmsFleetVehicle fmsFleetVehicle) {
		this.fmsFleetVehicle = fmsFleetVehicle;
	}
	
}