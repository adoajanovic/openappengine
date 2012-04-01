

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the fms_driver database table.
 * 
 */
@Entity
@Table(name="fms_driver")
public class FmsDriver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="FD_DRIVER_ID")
	private int fdDriverId;

	@Column(name="FD_PARTY_ID")
	private int fdPartyId;

	//bi-directional many-to-one association to FmsFleetTaskDriver
	@OneToMany(mappedBy="fmsDriver")
	private Set<FmsFleetTaskDriver> fmsFleetTaskDrivers;

    public FmsDriver() {
    }

	public int getFdDriverId() {
		return this.fdDriverId;
	}

	public void setFdDriverId(int fdDriverId) {
		this.fdDriverId = fdDriverId;
	}

	public int getFdPartyId() {
		return this.fdPartyId;
	}

	public void setFdPartyId(int fdPartyId) {
		this.fdPartyId = fdPartyId;
	}

	public Set<FmsFleetTaskDriver> getFmsFleetTaskDrivers() {
		return this.fmsFleetTaskDrivers;
	}

	public void setFmsFleetTaskDrivers(Set<FmsFleetTaskDriver> fmsFleetTaskDrivers) {
		this.fmsFleetTaskDrivers = fmsFleetTaskDrivers;
	}
	
}