package com.openappengine.model.fm;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the fm_invoice database table.
 * 
 */
@Entity
@Table(name="fm_invoice")
public class FmInvoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="seqGenerator")  
	@TableGenerator(name="seqGenerator", table="ad_table_sequences",pkColumnName="TS_SEQUENCE_NAME",valueColumnName="TS_SEQUENCE_VALUE",
	                allocationSize=1 // flush every 1 insert  
	)
	@Column(name="IN_INVOICE_ID", unique=true, nullable=false)
	private int inInvoiceId;

	@Column(name="IN_BILLING_ACCOUNT_ID", length=20)
	private String inBillingAccountId;

	@Column(name="IN_CONTACT_MECH_ID")
	private int inContactMechId;

	@Column(name="IN_CURRENCY_UOM_ID", length=20)
	private String inCurrencyUomId;

	@Column(name="IN_DESCRIPTION", length=255)
	private String inDescription;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="IN_DUE_DATE")
	private Date inDueDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="IN_INVOICE_DATE")
	private Date inInvoiceDate;

	@Column(name="IN_INVOICE_MESSAGE", length=255)
	private String inInvoiceMessage;

	@Column(name="IN_INVOICE_TYPE_ID", length=20)
	private String inInvoiceTypeId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="IN_PAID_DATE")
	private Date inPaidDate;

	@Column(name="IN_PARTY_ID")
	private int inPartyId;

	@Column(name="IN_PARTY_ID_FROM")
	private int inPartyIdFrom;

	@Column(name="IN_RECURRENCE_INFO_ID", length=20)
	private String inRecurrenceInfoId;

	@Column(name="IN_REFERENCE_NUMBER", length=60)
	private String inReferenceNumber;

	@Column(name="IN_ROLE_TYPE_ID", length=20)
	private String inRoleTypeId;

	@Column(name="IN_STATUS_ID", length=20)
	private String inStatusId;

	//bi-directional many-to-one association to FmInvoiceItem
	@OneToMany(mappedBy="fmInvoice",cascade=CascadeType.ALL)
	private List<FmInvoiceItem> fmInvoiceItems = new ArrayList<FmInvoiceItem>();

    public FmInvoice() {
    }

	public int getInInvoiceId() {
		return this.inInvoiceId;
	}

	public void setInInvoiceId(int inInvoiceId) {
		this.inInvoiceId = inInvoiceId;
	}

	public String getInBillingAccountId() {
		return this.inBillingAccountId;
	}

	public void setInBillingAccountId(String inBillingAccountId) {
		this.inBillingAccountId = inBillingAccountId;
	}

	public int getInContactMechId() {
		return this.inContactMechId;
	}

	public void setInContactMechId(int inContactMechId) {
		this.inContactMechId = inContactMechId;
	}

	public String getInCurrencyUomId() {
		return this.inCurrencyUomId;
	}

	public void setInCurrencyUomId(String inCurrencyUomId) {
		this.inCurrencyUomId = inCurrencyUomId;
	}

	public String getInDescription() {
		return this.inDescription;
	}

	public void setInDescription(String inDescription) {
		this.inDescription = inDescription;
	}

	public Date getInDueDate() {
		return this.inDueDate;
	}

	public void setInDueDate(Date inDueDate) {
		this.inDueDate = inDueDate;
	}

	public Date getInInvoiceDate() {
		return this.inInvoiceDate;
	}

	public void setInInvoiceDate(Date inInvoiceDate) {
		this.inInvoiceDate = inInvoiceDate;
	}

	public String getInInvoiceMessage() {
		return this.inInvoiceMessage;
	}

	public void setInInvoiceMessage(String inInvoiceMessage) {
		this.inInvoiceMessage = inInvoiceMessage;
	}

	public String getInInvoiceTypeId() {
		return this.inInvoiceTypeId;
	}

	public void setInInvoiceTypeId(String inInvoiceTypeId) {
		this.inInvoiceTypeId = inInvoiceTypeId;
	}

	public Date getInPaidDate() {
		return this.inPaidDate;
	}

	public void setInPaidDate(Date inPaidDate) {
		this.inPaidDate = inPaidDate;
	}

	public int getInPartyId() {
		return this.inPartyId;
	}

	public void setInPartyId(int inPartyId) {
		this.inPartyId = inPartyId;
	}

	public int getInPartyIdFrom() {
		return this.inPartyIdFrom;
	}

	public void setInPartyIdFrom(int inPartyIdFrom) {
		this.inPartyIdFrom = inPartyIdFrom;
	}

	public String getInRecurrenceInfoId() {
		return this.inRecurrenceInfoId;
	}

	public void setInRecurrenceInfoId(String inRecurrenceInfoId) {
		this.inRecurrenceInfoId = inRecurrenceInfoId;
	}

	public String getInReferenceNumber() {
		return this.inReferenceNumber;
	}

	public void setInReferenceNumber(String inReferenceNumber) {
		this.inReferenceNumber = inReferenceNumber;
	}

	public String getInRoleTypeId() {
		return this.inRoleTypeId;
	}

	public void setInRoleTypeId(String inRoleTypeId) {
		this.inRoleTypeId = inRoleTypeId;
	}

	public String getInStatusId() {
		return this.inStatusId;
	}

	public void setInStatusId(String inStatusId) {
		this.inStatusId = inStatusId;
	}

	public List<FmInvoiceItem> getFmInvoiceItems() {
		return this.fmInvoiceItems;
	}

	public void setFmInvoiceItems(List<FmInvoiceItem> fmInvoiceItems) {
		this.fmInvoiceItems = fmInvoiceItems;
	}
	
}