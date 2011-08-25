package com.ms.openapps.dto.salesorder;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemMasterVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int itemId;

	private String curcode;

	private String desc;

	private String name;

	private boolean perishable = false;

	private BigDecimal price;

	private BigDecimal shipCharges;

	private String status;

	private String type;

	private String uom;

	private BigDecimal weight;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getCurcode() {
		return curcode;
	}

	public void setCurcode(String curcode) {
		this.curcode = curcode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPerishable() {
		return perishable;
	}

	public void setPerishable(boolean perishable) {
		this.perishable = perishable;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getShipCharges() {
		return shipCharges;
	}

	public void setShipCharges(BigDecimal shipCharges) {
		this.shipCharges = shipCharges;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
}