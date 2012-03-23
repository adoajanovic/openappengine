/**
 * 
 */
package com.openappengine.messages.contract;

import java.io.Serializable;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author hrishi
 *
 */
public class ContractHdr implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int cnContractId;

	private XMLGregorianCalendar canDate;

	private XMLGregorianCalendar cnEndDate;

	private XMLGregorianCalendar cnStartDate;

	private List<ContractDet> contractDets;

	private int partyId;

	public int getCnContractId() {
		return cnContractId;
	}

	public void setCnContractId(int cnContractId) {
		this.cnContractId = cnContractId;
	}

	public XMLGregorianCalendar getCanDate() {
		return canDate;
	}

	public void setCanDate(XMLGregorianCalendar canDate) {
		this.canDate = canDate;
	}

	public XMLGregorianCalendar getCnEndDate() {
		return cnEndDate;
	}

	public void setCnEndDate(XMLGregorianCalendar cnEndDate) {
		this.cnEndDate = cnEndDate;
	}

	public XMLGregorianCalendar getCnStartDate() {
		return cnStartDate;
	}

	public void setCnStartDate(XMLGregorianCalendar cnStartDate) {
		this.cnStartDate = cnStartDate;
	}

	public List<ContractDet> getContractDets() {
		return contractDets;
	}

	public void setContractDets(List<ContractDet> contractDets) {
		this.contractDets = contractDets;
	}

	public int getPartyId() {
		return partyId;
	}

	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}

}
