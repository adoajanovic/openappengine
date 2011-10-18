package com.openappengine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ContractHdr implements Serializable {

	private static final long serialVersionUID = 1L;

	private int contractId;

	private Date canDate;

	private Date endDate;

	private Date startDate;

	private List<ContractDet> contractDets = new ArrayList<ContractDet>();

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