package com.openappengine.model.salesorder;

import java.util.Date;
import java.util.List;

import com.openappengine.model.entity.Entity;
import com.openappengine.model.party.Party;

public class SalesHdr implements Entity<SalesHdr, Integer> {

	private int salesId;

	private Date canDate;

	private String carrier;

	private String curCode;

	private String modePay;

	private Date ordDate;

	private String ordtype;

	private Double shipCharges;

	private Date shipDate;

	private String shipType;

	private String status;

	private Double totAmt;

	private Double totQty;

	private Double totTax;

	private Double totWeight;

	private List<SalesDet> salesDets;

	private Party party;

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

	public List<SalesDet> getSoSalesDets() {
		return salesDets;
	}

	public void setSoSalesDets(List<SalesDet> salesDets) {
		this.salesDets = salesDets;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	@Override
	public boolean sameIdentityAs(SalesHdr other) {
		return this.equals(other);
	}

	@Override
	public Integer identity() {
		return salesId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ordDate == null) ? 0 : ordDate.hashCode());
		result = prime * result + ((ordtype == null) ? 0 : ordtype.hashCode());
		result = prime * result + ((party == null) ? 0 : party.hashCode());
		result = prime * result
				+ ((salesDets == null) ? 0 : salesDets.hashCode());
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
		if (party == null) {
			if (other.party != null)
				return false;
		} else if (!party.equals(other.party))
			return false;
		if (salesDets == null) {
			if (other.salesDets != null)
				return false;
		} else if (!salesDets.equals(other.salesDets))
			return false;
		if (salesId != other.salesId)
			return false;
		return true;
	}
    
}