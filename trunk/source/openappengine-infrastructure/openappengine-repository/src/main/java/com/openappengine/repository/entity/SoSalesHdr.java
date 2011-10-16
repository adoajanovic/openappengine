package com.openappengine.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.openappengine.repository.entity.GenericEntity;


/**
 * The persistent class for the so_sales_hdr database table.
 * 
 */
@Entity
@Table(name="so_sales_hdr")
public class SoSalesHdr extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SALES_ID", unique=true, nullable=false)
	private int salesId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="CAN_DATE")
	private Date canDate;

	@Column(name="CARRIER", nullable=true, length=15)
	private String carrier;

	@Column(name="CUR_CODE", nullable=false, length=5)
	private String curCode;

	@Column(name="MODE_PAY", nullable=true, length=5)
	private String modePay;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="ORD_DATE", nullable=false)
	private Date ordDate;

	@Column(name="ORDTYPE", nullable=false, length=10)
	private String ordtype;

	@Column(name="SHIP_CHARGES", precision=10, scale=2)
	private BigDecimal shipCharges;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="SHIP_DATE")
	private Date shipDate;

	@Column(name="SHIP_TYPE", nullable=true, length=5)
	private String shipType;

	@Column(name="STATUS", nullable=false, length=5)
	private String status;

	@Column(name="TOT_AMT", precision=10, scale=2)
	private BigDecimal totAmt;

	@Column(name="TOT_QTY", precision=10, scale=2)
	private BigDecimal totQty;

	@Column(name="TOT_TAX", precision=10, scale=2)
	private BigDecimal totTax;

	@Column(name="TOT_WEIGHT", precision=10, scale=2)
	private BigDecimal totWeight;

	//bi-directional many-to-one association to SoSalesDet
	@OneToMany(mappedBy="soSalesHdr",cascade=CascadeType.ALL)
	private List<SoSalesDet> soSalesDets;

	@Column(name="PARTY_ID", nullable=false, length=5)
	private int partyId;

    public SoSalesHdr() {
    }

	public int getSalesId() {
		return this.salesId;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public Date getCanDate() {
		return this.canDate;
	}

	public void setCanDate(Date canDate) {
		this.canDate = canDate;
	}

	public String getCarrier() {
		return this.carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getCurCode() {
		return this.curCode;
	}

	public void setCurCode(String curCode) {
		this.curCode = curCode;
	}

	public String getModePay() {
		return this.modePay;
	}

	public void setModePay(String modePay) {
		this.modePay = modePay;
	}

	public Date getOrdDate() {
		return this.ordDate;
	}

	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}

	public String getOrdtype() {
		return this.ordtype;
	}

	public void setOrdtype(String ordtype) {
		this.ordtype = ordtype;
	}

	public BigDecimal getShipCharges() {
		return this.shipCharges;
	}

	public void setShipCharges(BigDecimal shipCharges) {
		this.shipCharges = shipCharges;
	}

	public Date getShipDate() {
		return this.shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public String getShipType() {
		return this.shipType;
	}

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTotAmt() {
		return this.totAmt;
	}

	public void setTotAmt(BigDecimal totAmt) {
		this.totAmt = totAmt;
	}

	public BigDecimal getTotQty() {
		return this.totQty;
	}

	public void setTotQty(BigDecimal totQty) {
		this.totQty = totQty;
	}

	public BigDecimal getTotTax() {
		return this.totTax;
	}

	public void setTotTax(BigDecimal totTax) {
		this.totTax = totTax;
	}

	public BigDecimal getTotWeight() {
		return this.totWeight;
	}

	public void setTotWeight(BigDecimal totWeight) {
		this.totWeight = totWeight;
	}

	public List<SoSalesDet> getSoSalesDets() {
		return this.soSalesDets;
	}

	public void setSoSalesDets(List<SoSalesDet> soSalesDets) {
		this.soSalesDets = soSalesDets;
	}
	
	public int getPartyId() {
		return partyId;
	}

	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	
	/**
	 * Add a {@link SoSalesDet} line item to the Sales Order
	 * @param salesDet
	 * @return boolean
	 */
	public boolean addLineItem(SoSalesDet salesDet) {
		if(salesDet == null) {
			return false;
		}
		
		if(this.soSalesDets == null) {
			soSalesDets = new ArrayList<SoSalesDet>();
		}
		
		soSalesDets.add(salesDet);
		return true;
	}
	
}