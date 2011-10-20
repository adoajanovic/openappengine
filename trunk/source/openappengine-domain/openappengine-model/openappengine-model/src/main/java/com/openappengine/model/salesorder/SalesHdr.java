package com.openappengine.model.salesorder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.openappengine.model.party.Party;

public class SalesHdr  implements Serializable {

	private static final long serialVersionUID = 1L;

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
    
}