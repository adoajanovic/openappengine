package com.openappengine.model;

import java.io.Serializable;


public class SoSalesDet implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int salesDetId;
	
	private Double cost;

	private Double discount;

	private int lineNo;

	private String location;

	private String lotNo;

	private String ordType;

	private Double price;

	private Double qtyOrd;

	private String uom;

	private Double weight;

	private ItemMaster itemMaster;

	private SalesHdr salesHdr;

    public SoSalesDet() {
    }

	public int getSalesDetId() {
		return salesDetId;
	}

	public void setSalesDetId(int salesDetId) {
		this.salesDetId = salesDetId;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public int getLineNo() {
		return lineNo;
	}

	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLotNo() {
		return lotNo;
	}

	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}

	public String getOrdType() {
		return ordType;
	}

	public void setOrdType(String ordType) {
		this.ordType = ordType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getQtyOrd() {
		return qtyOrd;
	}

	public void setQtyOrd(Double qtyOrd) {
		this.qtyOrd = qtyOrd;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public ItemMaster getItemMaster() {
		return itemMaster;
	}

	public void setItemMaster(ItemMaster itemMaster) {
		this.itemMaster = itemMaster;
	}

	public SalesHdr getSalesHdr() {
		return salesHdr;
	}

	public void setSalesHdr(SalesHdr salesHdr) {
		this.salesHdr = salesHdr;
	}
	
}