package com.openappengine.model.salesorder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.openappengine.model.entity.Entity;

@javax.persistence.Entity
@Table(name="SO_SALES_HDR")
public class SalesHdr implements Entity<SalesHdr, Integer> {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SO_SALES_ID", unique=true, nullable=false)
	private int salesId;

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="SO_CAN_DATE")
	private Date canDate;

	@Column(name="SO_CARRIER", nullable=true, length=50)
	private String carrier;

	@Column(name="SO_CUR_CODE", nullable=false, length=50)
	private String curCode;

	@Column(name="SO_MODE_PAY", nullable=true, length=50)
	private String modePay;

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="SO_ORD_DATE", nullable=false)
	private Date ordDate;

	@Column(name="SO_ORD_TYPE", nullable=false, length=50)
	private String ordtype;

	@Column(name="SO_SHIP_CHARGES", precision=10, scale=2)
	private Double shipCharges;

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="SO_SHIP_DATE")
	private Date shipDate;

	@Column(name="SO_SHIP_TYPE", nullable=true, length=50)
	private String shipType;

	@Column(name="SO_STATUS", nullable=false, length=50)
	private String status;

	@Column(name="SO_TOT_AMT", precision=10, scale=2)
	private Double totAmt;

	@Column(name="SO_TOT_QTY", precision=10, scale=2)
	private Double totQty;

	@Column(name="SO_TOT_TAX", precision=10, scale=2)
	private Double totTax;

	@Column(name="SO_TOT_WEIGHT", precision=10, scale=2)
	private Double totWeight;

	//bi-directional many-to-one association to SoSalesDet
	@OneToMany(mappedBy="salesHdr",cascade=CascadeType.ALL)
	private List<SalesDet> salesDetLineItems = new ArrayList<SalesDet>();

	@Column(name="SO_PARTY_ID", nullable=false, length=5)
	private int partyId;

    public SalesHdr() {
    }

	public int getSalesId() {
		return salesId;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public Date getCanDate() {
		return canDate;
	}

	public void setCanDate(Date canDate) {
		this.canDate = canDate;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getCurCode() {
		return curCode;
	}

	public void setCurCode(String curCode) {
		this.curCode = curCode;
	}

	public String getModePay() {
		return modePay;
	}

	public void setModePay(String modePay) {
		this.modePay = modePay;
	}

	public Date getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}

	public String getOrdtype() {
		return ordtype;
	}

	public void setOrdtype(String ordtype) {
		this.ordtype = ordtype;
	}

	public Double getShipCharges() {
		return shipCharges;
	}

	public void setShipCharges(Double shipCharges) {
		this.shipCharges = shipCharges;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public String getShipType() {
		return shipType;
	}

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getTotAmt() {
		return totAmt;
	}

	public void setTotAmt(Double totAmt) {
		this.totAmt = totAmt;
	}

	public Double getTotQty() {
		return totQty;
	}

	public void setTotQty(Double totQty) {
		this.totQty = totQty;
	}

	public Double getTotTax() {
		return totTax;
	}

	public void setTotTax(Double totTax) {
		this.totTax = totTax;
	}

	public Double getTotWeight() {
		return totWeight;
	}

	public void setTotWeight(Double totWeight) {
		this.totWeight = totWeight;
	}
	
	/**
	 * Add a new line item to the Sales Order.
	 * @param det
	 */
	public void addLineItem(SalesDet det) {
		if(det == null) {
			return;
		}
		salesDetLineItems.add(det);
	}

	public List<SalesDet> getSoSalesDets() {
		return salesDetLineItems;
	}

	public void setSoSalesDets(List<SalesDet> salesDets) {
		this.salesDetLineItems = salesDets;
	}

	public boolean sameIdentityAs(SalesHdr other) {
		return this.equals(other);
	}

	public Integer identity() {
		return salesId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ordDate == null) ? 0 : ordDate.hashCode());
		result = prime * result + ((ordtype == null) ? 0 : ordtype.hashCode());
		result = prime * result + partyId;
		result = prime * result
				+ ((salesDetLineItems == null) ? 0 : salesDetLineItems.hashCode());
		result = prime * result + salesId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesHdr other = (SalesHdr) obj;
		if (ordDate == null) {
			if (other.ordDate != null)
				return false;
		} else if (!ordDate.equals(other.ordDate))
			return false;
		if (ordtype == null) {
			if (other.ordtype != null)
				return false;
		} else if (!ordtype.equals(other.ordtype))
			return false;
		if (partyId != other.partyId)
			return false;
		if (salesDetLineItems == null) {
			if (other.salesDetLineItems != null)
				return false;
		} else if (!salesDetLineItems.equals(other.salesDetLineItems))
			return false;
		if (salesId != other.salesId)
			return false;
		return true;
	}
    
}