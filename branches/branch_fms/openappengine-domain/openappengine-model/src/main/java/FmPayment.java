

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the fm_payment database table.
 * 
 */
@Entity
@Table(name="fm_payment")
public class FmPayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="PMT_PAYMENT_ID")
	private int pmtPaymentId;

	@Column(name="PMT_ACTUAL_CURRENCY_AMOUNT")
	private BigDecimal pmtActualCurrencyAmount;

	@Column(name="PMT_AMOUNT")
	private BigDecimal pmtAmount;

	@Column(name="PMT_COMMENTS")
	private String pmtComments;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="PMT_EFFECTIVE_DATE")
	private Date pmtEffectiveDate;

	@Column(name="PMT_FIN_ACCOUNT_TRANS_ID")
	private int pmtFinAccountTransId;

	@Column(name="PMT_PARTY_ID_FROM")
	private int pmtPartyIdFrom;

	@Column(name="PMT_PARTY_ID_TO")
	private int pmtPartyIdTo;

	@Column(name="PMT_PAYMENT_METHOD_ID")
	private int pmtPaymentMethodId;

	@Column(name="PMT_PAYMENT_REF_NUM")
	private String pmtPaymentRefNum;

	@Column(name="PMT_ROLE_TYPE_ID_TO")
	private int pmtRoleTypeIdTo;

	@Column(name="PMT_STATUS_ID")
	private int pmtStatusId;

	//bi-directional many-to-one association to FmPaymentMenthodType
    @ManyToOne
	@JoinColumn(name="PMT_PAYMENT_METHOD_TYPE_ID")
	private FmPaymentMenthodType fmPaymentMenthodType;

	//bi-directional many-to-one association to FmPaymentType
    @ManyToOne
	@JoinColumn(name="PMT_PAYMENT_TYPE_ID")
	private FmPaymentType fmPaymentType;

    public FmPayment() {
    }

	public int getPmtPaymentId() {
		return this.pmtPaymentId;
	}

	public void setPmtPaymentId(int pmtPaymentId) {
		this.pmtPaymentId = pmtPaymentId;
	}

	public BigDecimal getPmtActualCurrencyAmount() {
		return this.pmtActualCurrencyAmount;
	}

	public void setPmtActualCurrencyAmount(BigDecimal pmtActualCurrencyAmount) {
		this.pmtActualCurrencyAmount = pmtActualCurrencyAmount;
	}

	public BigDecimal getPmtAmount() {
		return this.pmtAmount;
	}

	public void setPmtAmount(BigDecimal pmtAmount) {
		this.pmtAmount = pmtAmount;
	}

	public String getPmtComments() {
		return this.pmtComments;
	}

	public void setPmtComments(String pmtComments) {
		this.pmtComments = pmtComments;
	}

	public Date getPmtEffectiveDate() {
		return this.pmtEffectiveDate;
	}

	public void setPmtEffectiveDate(Date pmtEffectiveDate) {
		this.pmtEffectiveDate = pmtEffectiveDate;
	}

	public int getPmtFinAccountTransId() {
		return this.pmtFinAccountTransId;
	}

	public void setPmtFinAccountTransId(int pmtFinAccountTransId) {
		this.pmtFinAccountTransId = pmtFinAccountTransId;
	}

	public int getPmtPartyIdFrom() {
		return this.pmtPartyIdFrom;
	}

	public void setPmtPartyIdFrom(int pmtPartyIdFrom) {
		this.pmtPartyIdFrom = pmtPartyIdFrom;
	}

	public int getPmtPartyIdTo() {
		return this.pmtPartyIdTo;
	}

	public void setPmtPartyIdTo(int pmtPartyIdTo) {
		this.pmtPartyIdTo = pmtPartyIdTo;
	}

	public int getPmtPaymentMethodId() {
		return this.pmtPaymentMethodId;
	}

	public void setPmtPaymentMethodId(int pmtPaymentMethodId) {
		this.pmtPaymentMethodId = pmtPaymentMethodId;
	}

	public String getPmtPaymentRefNum() {
		return this.pmtPaymentRefNum;
	}

	public void setPmtPaymentRefNum(String pmtPaymentRefNum) {
		this.pmtPaymentRefNum = pmtPaymentRefNum;
	}

	public int getPmtRoleTypeIdTo() {
		return this.pmtRoleTypeIdTo;
	}

	public void setPmtRoleTypeIdTo(int pmtRoleTypeIdTo) {
		this.pmtRoleTypeIdTo = pmtRoleTypeIdTo;
	}

	public int getPmtStatusId() {
		return this.pmtStatusId;
	}

	public void setPmtStatusId(int pmtStatusId) {
		this.pmtStatusId = pmtStatusId;
	}

	public FmPaymentMenthodType getFmPaymentMenthodType() {
		return this.fmPaymentMenthodType;
	}

	public void setFmPaymentMenthodType(FmPaymentMenthodType fmPaymentMenthodType) {
		this.fmPaymentMenthodType = fmPaymentMenthodType;
	}
	
	public FmPaymentType getFmPaymentType() {
		return this.fmPaymentType;
	}

	public void setFmPaymentType(FmPaymentType fmPaymentType) {
		this.fmPaymentType = fmPaymentType;
	}
	
}