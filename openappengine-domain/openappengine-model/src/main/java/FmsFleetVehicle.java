

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the fms_fleet_vehicle database table.
 * 
 */
@Entity
@Table(name="fms_fleet_vehicle")
public class FmsFleetVehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="FV_VEHICLE_ID")
	private int fvVehicleId;

    @Temporal( TemporalType.DATE)
	@Column(name="FV_FROM_DATE")
	private Date fvFromDate;

	@Column(name="FV_LICENCE_PLATE_NUMBER")
	private String fvLicencePlateNumber;

	@Column(name="FV_STATUS")
	private String fvStatus;

    @Temporal( TemporalType.DATE)
	@Column(name="FV_TO_DATE")
	private Date fvToDate;

	@Column(name="FV_VEHICLE_MAKE")
	private String fvVehicleMake;

	@Column(name="FV_VEHICLE_MODEL")
	private String fvVehicleModel;

	//bi-directional many-to-one association to FmsFleetTaskVehicle
	@OneToMany(mappedBy="fmsFleetVehicle")
	private Set<FmsFleetTaskVehicle> fmsFleetTaskVehicles;

	//bi-directional many-to-one association to FmsFleetVehicleType
    @ManyToOne
	@JoinColumn(name="FV_TYPE_ID")
	private FmsFleetVehicleType fmsFleetVehicleType;

    public FmsFleetVehicle() {
    }

	public int getFvVehicleId() {
		return this.fvVehicleId;
	}

	public void setFvVehicleId(int fvVehicleId) {
		this.fvVehicleId = fvVehicleId;
	}

	public Date getFvFromDate() {
		return this.fvFromDate;
	}

	public void setFvFromDate(Date fvFromDate) {
		this.fvFromDate = fvFromDate;
	}

	public String getFvLicencePlateNumber() {
		return this.fvLicencePlateNumber;
	}

	public void setFvLicencePlateNumber(String fvLicencePlateNumber) {
		this.fvLicencePlateNumber = fvLicencePlateNumber;
	}

	public String getFvStatus() {
		return this.fvStatus;
	}

	public void setFvStatus(String fvStatus) {
		this.fvStatus = fvStatus;
	}

	public Date getFvToDate() {
		return this.fvToDate;
	}

	public void setFvToDate(Date fvToDate) {
		this.fvToDate = fvToDate;
	}

	public String getFvVehicleMake() {
		return this.fvVehicleMake;
	}

	public void setFvVehicleMake(String fvVehicleMake) {
		this.fvVehicleMake = fvVehicleMake;
	}

	public String getFvVehicleModel() {
		return this.fvVehicleModel;
	}

	public void setFvVehicleModel(String fvVehicleModel) {
		this.fvVehicleModel = fvVehicleModel;
	}

	public Set<FmsFleetTaskVehicle> getFmsFleetTaskVehicles() {
		return this.fmsFleetTaskVehicles;
	}

	public void setFmsFleetTaskVehicles(Set<FmsFleetTaskVehicle> fmsFleetTaskVehicles) {
		this.fmsFleetTaskVehicles = fmsFleetTaskVehicles;
	}
	
	public FmsFleetVehicleType getFmsFleetVehicleType() {
		return this.fmsFleetVehicleType;
	}

	public void setFmsFleetVehicleType(FmsFleetVehicleType fmsFleetVehicleType) {
		this.fmsFleetVehicleType = fmsFleetVehicleType;
	}
	
}