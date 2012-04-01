

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fms_fleet_task_driver database table.
 * 
 */
@Entity
@Table(name="fms_fleet_task_driver")
public class FmsFleetTaskDriver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="FTD_FLEET_TASK_DRIVER_ID")
	private int ftdFleetTaskDriverId;

	//bi-directional many-to-one association to FmsDriver
    @ManyToOne
	@JoinColumn(name="FTD_DRIVER_ID")
	private FmsDriver fmsDriver;

	//bi-directional many-to-one association to FmsFleetTask
    @ManyToOne
	@JoinColumn(name="FTD_TASK_ID")
	private FmsFleetTask fmsFleetTask;

    public FmsFleetTaskDriver() {
    }

	public int getFtdFleetTaskDriverId() {
		return this.ftdFleetTaskDriverId;
	}

	public void setFtdFleetTaskDriverId(int ftdFleetTaskDriverId) {
		this.ftdFleetTaskDriverId = ftdFleetTaskDriverId;
	}

	public FmsDriver getFmsDriver() {
		return this.fmsDriver;
	}

	public void setFmsDriver(FmsDriver fmsDriver) {
		this.fmsDriver = fmsDriver;
	}
	
	public FmsFleetTask getFmsFleetTask() {
		return this.fmsFleetTask;
	}

	public void setFmsFleetTask(FmsFleetTask fmsFleetTask) {
		this.fmsFleetTask = fmsFleetTask;
	}
	
}