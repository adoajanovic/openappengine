

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the fm_invoice database table.
 * 
 */
@Entity
@Table(name="fm_invoice")
public class FmInvoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="IN_INVOICE_ID")
	private int inInvoiceId;

	@Column(name="IN_BILLING_ACCOUNT_ID")
	private int inBillingAccountId;

	@Column(name="IN_CONTACT_MECH_ID")
	private int inContactMechId;

	@Column(name="IN_DESCRIPTION")
	private String inDescription;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="IN_DUE_DATE")
	private Date inDueDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="IN_INVOICE_DATE")
	private Date inInvoiceDate;

	@Column(name="IN_INVOICE_MESSAGE")
	private String inInvoiceMessage;

	@Column(name="IN_INVOICE_TYPE_ID")
	private int inInvoiceTypeId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="IN_PAID_DATE")
	private Date inPaidDate;

	@Column(name="IN_PARTY_ID")
	private int inPartyId;

	@Column(name="IN_PARTY_ID_FROM")
	private int inPartyIdFrom;

	@Column(name="IN_RECURRENCE_INFO_ID")
	private String inRecurrenceInfoId;

	@Column(name="IN_REFERENCE_NUMBER")
	private String inReferenceNumber;

	@Column(name="IN_ROLE_TYPE_ID")
	private int inRoleTypeId;

	@Column(name="IN_STATUS_DESC")
	private String inStatusDesc;

	//bi-directional many-to-one association to FmInvoiceItem
	@OneToMany(mappedBy="fmInvoice")
	private Set<FmInvoiceItem> fmInvoiceItems;

    public FmInvoice() {
    }

	public int getInInvoiceId() {
		return this.inInvoiceId;
	}

	public void setInInvoiceId(int inInvoiceId) {
		this.inInvoiceId = inInvoiceId;
	}

	public int getInBillingAccountId() {
		return this.inBillingAccountId;
	}

	public void setInBillingAccountId(int inBillingAccountId) {
		this.inBillingAccountId = inBillingAccountId;
	}

	public int getInContactMechId() {
		return this.inContactMechId;
	}

	public void setInContactMechId(int inContactMechId) {
		this.inContactMechId = inContactMechId;
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

	public int getInInvoiceTypeId() {
		return this.inInvoiceTypeId;
	}

	public void setInInvoiceTypeId(int inInvoiceTypeId) {
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

	public int getInRoleTypeId() {
		return this.inRoleTypeId;
	}

	public void setInRoleTypeId(int inRoleTypeId) {
		this.inRoleTypeId = inRoleTypeId;
	}

	public String getInStatusDesc() {
		return this.inStatusDesc;
	}

	public void setInStatusDesc(String inStatusDesc) {
		this.inStatusDesc = inStatusDesc;
	}

	public Set<FmInvoiceItem> getFmInvoiceItems() {
		return this.fmInvoiceItems;
	}

	public void setFmInvoiceItems(Set<FmInvoiceItem> fmInvoiceItems) {
		this.fmInvoiceItems = fmInvoiceItems;
	}
	
}