

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the so_sales_hdr database table.
 * 
 */
@Entity
@Table(name="so_sales_hdr")
public class SoSalesHdr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="SO_SALES_ID")
	private int soSalesId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="SO_CAN_DATE")
	private Date soCanDate;

	@Column(name="SO_CARRIER")
	private String soCarrier;

	@Column(name="SO_CUR_CODE")
	private String soCurCode;

	@Column(name="SO_MODE_PAY")
	private String soModePay;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="SO_ORD_DATE")
	private Date soOrdDate;

	@Column(name="SO_ORD_TYPE")
	private String soOrdType;

	@Column(name="SO_PARTY_ID")
	private int soPartyId;

	@Column(name="SO_SHIP_CHARGES")
	private double soShipCharges;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="SO_SHIP_DATE")
	private Date soShipDate;

	@Column(name="SO_SHIP_TYPE")
	private String soShipType;

	@Column(name="SO_STATUS")
	private String soStatus;

	@Column(name="SO_TOT_AMT")
	private double soTotAmt;

	@Column(name="SO_TOT_QTY")
	private double soTotQty;

	@Column(name="SO_TOT_TAX")
	private double soTotTax;

	@Column(name="SO_TOT_WEIGHT")
	private double soTotWeight;

	//bi-directional many-to-one association to SoSalesDet
	@OneToMany(mappedBy="soSalesHdr")
	private Set<SoSalesDet> soSalesDets;

    public SoSalesHdr() {
    }

	public int getSoSalesId() {
		return this.soSalesId;
	}

	public void setSoSalesId(int soSalesId) {
		this.soSalesId = soSalesId;
	}

	public Date getSoCanDate() {
		return this.soCanDate;
	}

	public void setSoCanDate(Date soCanDate) {
		this.soCanDate = soCanDate;
	}

	public String getSoCarrier() {
		return this.soCarrier;
	}

	public void setSoCarrier(String soCarrier) {
		this.soCarrier = soCarrier;
	}

	public String getSoCurCode() {
		return this.soCurCode;
	}

	public void setSoCurCode(String soCurCode) {
		this.soCurCode = soCurCode;
	}

	public String getSoModePay() {
		return this.soModePay;
	}

	public void setSoModePay(String soModePay) {
		this.soModePay = soModePay;
	}

	public Date getSoOrdDate() {
		return this.soOrdDate;
	}

	public void setSoOrdDate(Date soOrdDate) {
		this.soOrdDate = soOrdDate;
	}

	public String getSoOrdType() {
		return this.soOrdType;
	}

	public void setSoOrdType(String soOrdType) {
		this.soOrdType = soOrdType;
	}

	public int getSoPartyId() {
		return this.soPartyId;
	}

	public void setSoPartyId(int soPartyId) {
		this.soPartyId = soPartyId;
	}

	public double getSoShipCharges() {
		return this.soShipCharges;
	}

	public void setSoShipCharges(double soShipCharges) {
		this.soShipCharges = soShipCharges;
	}

	public Date getSoShipDate() {
		return this.soShipDate;
	}

	public void setSoShipDate(Date soShipDate) {
		this.soShipDate = soShipDate;
	}

	public String getSoShipType() {
		return this.soShipType;
	}

	public void setSoShipType(String soShipType) {
		this.soShipType = soShipType;
	}

	public String getSoStatus() {
		return this.soStatus;
	}

	public void setSoStatus(String soStatus) {
		this.soStatus = soStatus;
	}

	public double getSoTotAmt() {
		return this.soTotAmt;
	}

	public void setSoTotAmt(double soTotAmt) {
		this.soTotAmt = soTotAmt;
	}

	public double getSoTotQty() {
		return this.soTotQty;
	}

	public void setSoTotQty(double soTotQty) {
		this.soTotQty = soTotQty;
	}

	public double getSoTotTax() {
		return this.soTotTax;
	}

	public void setSoTotTax(double soTotTax) {
		this.soTotTax = soTotTax;
	}

	public double getSoTotWeight() {
		return this.soTotWeight;
	}

	public void setSoTotWeight(double soTotWeight) {
		this.soTotWeight = soTotWeight;
	}

	public Set<SoSalesDet> getSoSalesDets() {
		return this.soSalesDets;
	}

	public void setSoSalesDets(Set<SoSalesDet> soSalesDets) {
		this.soSalesDets = soSalesDets;
	}
	
}