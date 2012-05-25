/**
 * 
 */
package com.openappengine.model.contract;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author hrishi
 *
 */
@Entity
@Table(name="cn_contract_header")
public class Contract {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="seqGenerator")  
	@TableGenerator(name="seqGenerator", table="ad_table_sequences",pkColumnName="TS_SEQUENCE_NAME",valueColumnName="TS_SEQUENCE_VALUE",
	                allocationSize=1 // flush every 1 insert  
	)
	@Column(name="CH_CONTRACT_ID",unique=true, nullable=false)
	private int contractId;
	
	@Column(name="CH_CONTRACT_NUMBER",unique=true, nullable=false)
	private String contractNumber;
	
	@Column(name="CH_PARTY_EXTERNAL_ID",unique=true, nullable=false)
	private String partyId;
	
	@OneToMany(mappedBy="contract",cascade=CascadeType.ALL)
	private List<ContractLineItem> lineItems;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CH_FROM_DATE",nullable=false)
	private Date fromDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CH_TO_DATE")
	private Date toDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CH_DISCONTINUE_DATE", nullable=true)
	private Date discontinueDate;
	
	@Column(name="CH_ORDER_RECURRENCE", nullable=false)
	private String orderRecurrence;

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public List<ContractLineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<ContractLineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Date getDiscontinueDate() {
		return discontinueDate;
	}

	public void setDiscontinueDate(Date discontinueDate) {
		this.discontinueDate = discontinueDate;
	}

	public String getOrderRecurrence() {
		return orderRecurrence;
	}

	public void setOrderRecurrence(String orderRecurrence) {
		this.orderRecurrence = orderRecurrence;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	
}
