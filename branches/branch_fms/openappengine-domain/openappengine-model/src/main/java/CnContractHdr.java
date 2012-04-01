

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the cn_contract_hdr database table.
 * 
 */
@Entity
@Table(name="cn_contract_hdr")
public class CnContractHdr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="CN_CONTRACT_ID")
	private int cnContractId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="CAN_DATE")
	private Date canDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="CN_END_DATE")
	private Date cnEndDate;

	@Column(name="CN_PARTY_ID")
	private int cnPartyId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="CN_START_DATE")
	private Date cnStartDate;

	//bi-directional many-to-one association to CnContractDet
	@OneToMany(mappedBy="cnContractHdr")
	private Set<CnContractDet> cnContractDets;

    public CnContractHdr() {
    }

	public int getCnContractId() {
		return this.cnContractId;
	}

	public void setCnContractId(int cnContractId) {
		this.cnContractId = cnContractId;
	}

	public Date getCanDate() {
		return this.canDate;
	}

	public void setCanDate(Date canDate) {
		this.canDate = canDate;
	}

	public Date getCnEndDate() {
		return this.cnEndDate;
	}

	public void setCnEndDate(Date cnEndDate) {
		this.cnEndDate = cnEndDate;
	}

	public int getCnPartyId() {
		return this.cnPartyId;
	}

	public void setCnPartyId(int cnPartyId) {
		this.cnPartyId = cnPartyId;
	}

	public Date getCnStartDate() {
		return this.cnStartDate;
	}

	public void setCnStartDate(Date cnStartDate) {
		this.cnStartDate = cnStartDate;
	}

	public Set<CnContractDet> getCnContractDets() {
		return this.cnContractDets;
	}

	public void setCnContractDets(Set<CnContractDet> cnContractDets) {
		this.cnContractDets = cnContractDets;
	}
	
}