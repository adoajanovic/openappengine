package com.openappengine.repository.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.openappengine.repository.entity.GenericEntity;


/**
 * The persistent class for the cn_contract_hdr database table.
 * 
 */
@Entity
@Table(name="cn_contract_hdr")
public class CnContractHdr extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CN_CONTRACT_ID", unique=true, nullable=false)
	private int cnContractId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="CAN_DATE")
	private Date canDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="CN_END_DATE", nullable=false)
	private Date cnEndDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="CN_START_DATE", nullable=false)
	private Date cnStartDate;

	//bi-directional many-to-one association to CnContractDet
	@OneToMany(mappedBy="cnContractHdr",cascade = CascadeType.ALL)
	private List<CnContractDet> cnContractDets;

	//bi-directional many-to-one association to PmParty
    @ManyToOne
	@JoinColumn(name="CN_PARTY_ID", nullable=false)
	private PmParty pmParty;
    
    public CnContractHdr() {
    }
    
    /**
     * Add a Line Item to the Contract
     * @param cnContractDet
     * @return true : if the Contract Det Line Item was added, false otherwise.
     */
    public boolean addLineItem(CnContractDet cnContractDet) {
    	if(this.cnContractDets == null) {
    		cnContractDets = new ArrayList<CnContractDet>();
    	}
    	return cnContractDets.add(cnContractDet);
    }
    
    //Accessors
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

	public Date getCnStartDate() {
		return this.cnStartDate;
	}

	public void setCnStartDate(Date cnStartDate) {
		this.cnStartDate = cnStartDate;
	}

	public List<CnContractDet> getCnContractDets() {
		return this.cnContractDets;
	}

	public void setCnContractDets(List<CnContractDet> cnContractDets) {
		this.cnContractDets = cnContractDets;
	}
	
	public PmParty getPmParty() {
		return this.pmParty;
	}

	public void setPmParty(PmParty pmParty) {
		this.pmParty = pmParty;
	}
	
}