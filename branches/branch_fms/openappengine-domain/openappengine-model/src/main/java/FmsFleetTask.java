

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the fms_fleet_task database table.
 * 
 */
@Entity
@Table(name="fms_fleet_task")
public class FmsFleetTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="FL_FLEET_TASK_ID")
	private int flFleetTaskId;

    @Temporal( TemporalType.DATE)
	@Column(name="FL_TASK_ADDED_DATE")
	private Date flTaskAddedDate;

    @Lob()
	@Column(name="FL_TASK_DESCRIPTION")
	private String flTaskDescription;

	@Column(name="FL_TASK_STATUS")
	private String flTaskStatus;

	@Column(name="FL_TASK_TITLE")
	private String flTaskTitle;

	//bi-directional many-to-one association to FmsFleetTaskAction
	@OneToMany(mappedBy="fmsFleetTask")
	private Set<FmsFleetTaskAction> fmsFleetTaskActions;

	//bi-directional many-to-one association to FmsFleetTaskDriver
	@OneToMany(mappedBy="fmsFleetTask")
	private Set<FmsFleetTaskDriver> fmsFleetTaskDrivers;

	//bi-directional many-to-one association to FmsFleetTaskSchedule
	@OneToMany(mappedBy="fmsFleetTask")
	private Set<FmsFleetTaskSchedule> fmsFleetTaskSchedules;

	//bi-directional many-to-one association to FmsFleetTaskUser
	@OneToMany(mappedBy="fmsFleetTask")
	private Set<FmsFleetTaskUser> fmsFleetTaskUsers;

	//bi-directional many-to-one association to FmsFleetTaskVehicle
	@OneToMany(mappedBy="fmsFleetTask")
	private Set<FmsFleetTaskVehicle> fmsFleetTaskVehicles;

    public FmsFleetTask() {
    }

	public int getFlFleetTaskId() {
		return this.flFleetTaskId;
	}

	public void setFlFleetTaskId(int flFleetTaskId) {
		this.flFleetTaskId = flFleetTaskId;
	}

	public Date getFlTaskAddedDate() {
		return this.flTaskAddedDate;
	}

	public void setFlTaskAddedDate(Date flTaskAddedDate) {
		this.flTaskAddedDate = flTaskAddedDate;
	}

	public String getFlTaskDescription() {
		return this.flTaskDescription;
	}

	public void setFlTaskDescription(String flTaskDescription) {
		this.flTaskDescription = flTaskDescription;
	}

	public String getFlTaskStatus() {
		return this.flTaskStatus;
	}

	public void setFlTaskStatus(String flTaskStatus) {
		this.flTaskStatus = flTaskStatus;
	}

	public String getFlTaskTitle() {
		return this.flTaskTitle;
	}

	public void setFlTaskTitle(String flTaskTitle) {
		this.flTaskTitle = flTaskTitle;
	}

	public Set<FmsFleetTaskAction> getFmsFleetTaskActions() {
		return this.fmsFleetTaskActions;
	}

	public void setFmsFleetTaskActions(Set<FmsFleetTaskAction> fmsFleetTaskActions) {
		this.fmsFleetTaskActions = fmsFleetTaskActions;
	}
	
	public Set<FmsFleetTaskDriver> getFmsFleetTaskDrivers() {
		return this.fmsFleetTaskDrivers;
	}

	public void setFmsFleetTaskDrivers(Set<FmsFleetTaskDriver> fmsFleetTaskDrivers) {
		this.fmsFleetTaskDrivers = fmsFleetTaskDrivers;
	}
	
	public Set<FmsFleetTaskSchedule> getFmsFleetTaskSchedules() {
		return this.fmsFleetTaskSchedules;
	}

	public void setFmsFleetTaskSchedules(Set<FmsFleetTaskSchedule> fmsFleetTaskSchedules) {
		this.fmsFleetTaskSchedules = fmsFleetTaskSchedules;
	}
	
	public Set<FmsFleetTaskUser> getFmsFleetTaskUsers() {
		return this.fmsFleetTaskUsers;
	}

	public void setFmsFleetTaskUsers(Set<FmsFleetTaskUser> fmsFleetTaskUsers) {
		this.fmsFleetTaskUsers = fmsFleetTaskUsers;
	}
	
	public Set<FmsFleetTaskVehicle> getFmsFleetTaskVehicles() {
		return this.fmsFleetTaskVehicles;
	}

	public void setFmsFleetTaskVehicles(Set<FmsFleetTaskVehicle> fmsFleetTaskVehicles) {
		this.fmsFleetTaskVehicles = fmsFleetTaskVehicles;
	}
	
}