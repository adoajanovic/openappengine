package com.openappengine.model;

import java.io.Serializable;

public class ContractDet implements Serializable {

	private static final long serialVersionUID = 1L;

	private int contractDetId;

	private Double cost;

	private Double discount;

	private int itemId;

	private String location;

	private String lotNo;

	private String ordType;

	private Double price;

	private Double qtyOrd;

	private String uom;

	private Double weight;

	private ContractHdr contractHdr;

	public ContractDet() {
	}

	public int getContractDetId() {
		return contractDetId;
	}

	public void setContractDetId(int contractDetId) {
		this.contractDetId = contractDetId;
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

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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

	public ContractHdr getContractHdr() {
		return contractHdr;
	}

	public void setContractHdr(ContractHdr contractHdr) {
		this.contractHdr = contractHdr;
	}
	
}