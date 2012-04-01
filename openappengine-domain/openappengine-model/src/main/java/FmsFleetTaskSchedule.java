

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the fms_fleet_task_schedule database table.
 * 
 */
@Entity
@Table(name="fms_fleet_task_schedule")
public class FmsFleetTaskSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="FS_FLEET_TASK_SCHEDULE_ID")
	private int fsFleetTaskScheduleId;

    @Temporal( TemporalType.DATE)
	@Column(name="FS_FLEET_END_DATE")
	private Date fsFleetEndDate;

	@Column(name="FS_FLEET_END_TIME")
	private Time fsFleetEndTime;

    @Temporal( TemporalType.DATE)
	@Column(name="FS_FLEET_START_DATE")
	private Date fsFleetStartDate;

	@Column(name="FS_FLEET_START_TIME")
	private Time fsFleetStartTime;

	@Column(name="FS_PERIODICITY")
	private String fsPeriodicity;

	//bi-directional many-to-one association to FmsFleetTask
    @ManyToOne
	@JoinColumn(name="FS_FLEET_TASK_ID")
	private FmsFleetTask fmsFleetTask;

    public FmsFleetTaskSchedule() {
    }

	public int getFsFleetTaskScheduleId() {
		return this.fsFleetTaskScheduleId;
	}

	public void setFsFleetTaskScheduleId(int fsFleetTaskScheduleId) {
		this.fsFleetTaskScheduleId = fsFleetTaskScheduleId;
	}

	public Date getFsFleetEndDate() {
		return this.fsFleetEndDate;
	}

	public void setFsFleetEndDate(Date fsFleetEndDate) {
		this.fsFleetEndDate = fsFleetEndDate;
	}

	public Time getFsFleetEndTime() {
		return this.fsFleetEndTime;
	}

	public void setFsFleetEndTime(Time fsFleetEndTime) {
		this.fsFleetEndTime = fsFleetEndTime;
	}

	public Date getFsFleetStartDate() {
		return this.fsFleetStartDate;
	}

	public void setFsFleetStartDate(Date fsFleetStartDate) {
		this.fsFleetStartDate = fsFleetStartDate;
	}

	public Time getFsFleetStartTime() {
		return this.fsFleetStartTime;
	}

	public void setFsFleetStartTime(Time fsFleetStartTime) {
		this.fsFleetStartTime = fsFleetStartTime;
	}

	public String getFsPeriodicity() {
		return this.fsPeriodicity;
	}

	public void setFsPeriodicity(String fsPeriodicity) {
		this.fsPeriodicity = fsPeriodicity;
	}

	public FmsFleetTask getFmsFleetTask() {
		return this.fmsFleetTask;
	}

	public void setFmsFleetTask(FmsFleetTask fmsFleetTask) {
		this.fmsFleetTask = fmsFleetTask;
	}
	
}