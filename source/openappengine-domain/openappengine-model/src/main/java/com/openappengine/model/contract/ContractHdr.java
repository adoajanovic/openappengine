package com.openappengine.model.contract;

import java.io.Serializable;
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

import com.openappengine.model.party.Party;

@Entity
@Table(name="CN_CONTRACT_HDR")
public class ContractHdr implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CN_CONTRACT_ID", unique=true, nullable=false)
	private int contractId;

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="CAN_DATE")
	private Date canDate;

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="CN_END_DATE", nullable=false)
	private Date endDate;

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="CN_START_DATE", nullable=false)
	private Date startDate;

	//bi-directional many-to-one association to CnContractDet
	@OneToMany(mappedBy="contractHdr",cascade = CascadeType.ALL)
	private List<ContractDet> contractDets = new ArrayList<ContractDet>();

	//bi-directional many-to-one association to PmParty
    @ManyToOne
	@JoinColumn(name="CN_PARTY_ID", nullable=false)
	private Party party;
	
	public boolean addContractDetLineItem(ContractDet contractDet) {
		if(contractDet == null) {
			return false;
		}
		
		return contractDets.add(contractDet);
	}
    
    public ContractHdr() {
    }

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public Date getCanDate() {
		return canDate;
	}

	public void setCanDate(Date canDate) {
		this.canDate = canDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<ContractDet> getContractDets() {
		return contractDets;
	}

	public void setContractDets(List<ContractDet> contractDets) {
		this.contractDets = contractDets;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}
    
}