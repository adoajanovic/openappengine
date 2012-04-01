

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fms_fleet_task_action database table.
 * 
 */
@Entity
@Table(name="fms_fleet_task_action")
public class FmsFleetTaskAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="FA_ACTION_ID")
	private int faActionId;

	@Column(name="FA_ACTION_NAME")
	private String faActionName;

	//bi-directional many-to-one association to FmsFleetTask
    @ManyToOne
	@JoinColumn(name="FA_TASK_ID")
	private FmsFleetTask fmsFleetTask;

    public FmsFleetTaskAction() {
    }

	public int getFaActionId() {
		return this.faActionId;
	}

	public void setFaActionId(int faActionId) {
		this.faActionId = faActionId;
	}

	public String getFaActionName() {
		return this.faActionName;
	}

	public void setFaActionName(String faActionName) {
		this.faActionName = faActionName;
	}

	public FmsFleetTask getFmsFleetTask() {
		return this.fmsFleetTask;
	}

	public void setFmsFleetTask(FmsFleetTask fmsFleetTask) {
		this.fmsFleetTask = fmsFleetTask;
	}
	
}