

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the fm_payment_type database table.
 * 
 */
@Entity
@Table(name="fm_payment_type")
public class FmPaymentType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="PT_PAYMENT_TYPE_ID")
	private int ptPaymentTypeId;

	@Column(name="PT_HAS_TABLE")
	private String ptHasTable;

	@Column(name="PT_PAYMENT_TYPE_DESC")
	private String ptPaymentTypeDesc;

	@Column(name="PT_TABLE_NAME")
	private String ptTableName;

	//bi-directional many-to-one association to FmPayment
	@OneToMany(mappedBy="fmPaymentType")
	private Set<FmPayment> fmPayments;

    public FmPaymentType() {
    }

	public int getPtPaymentTypeId() {
		return this.ptPaymentTypeId;
	}

	public void setPtPaymentTypeId(int ptPaymentTypeId) {
		this.ptPaymentTypeId = ptPaymentTypeId;
	}

	public String getPtHasTable() {
		return this.ptHasTable;
	}

	public void setPtHasTable(String ptHasTable) {
		this.ptHasTable = ptHasTable;
	}

	public String getPtPaymentTypeDesc() {
		return this.ptPaymentTypeDesc;
	}

	public void setPtPaymentTypeDesc(String ptPaymentTypeDesc) {
		this.ptPaymentTypeDesc = ptPaymentTypeDesc;
	}

	public String getPtTableName() {
		return this.ptTableName;
	}

	public void setPtTableName(String ptTableName) {
		this.ptTableName = ptTableName;
	}

	public Set<FmPayment> getFmPayments() {
		return this.fmPayments;
	}

	public void setFmPayments(Set<FmPayment> fmPayments) {
		this.fmPayments = fmPayments;
	}
	
}