package com.openappengine.model;

import java.io.Serializable;


public class ItemMaster implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int itemId;

	private String cat01;

	private String cat02;

	private String cat03;

	private String cat04;

	private String cat05;

	private Double cost;

	private String curcode;

	private String desc;

	private String name;

	private boolean perishable = false;

	private Double price;

	private Double shipCharges;

	private String status;

	private String type;

	private String uom;

	private Double weight;

    public ItemMaster() {
    }

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getCat01() {
		return cat01;
	}

	public void setCat01(String cat01) {
		this.cat01 = cat01;
	}

	public String getCat02() {
		return cat02;
	}

	public void setCat02(String cat02) {
		this.cat02 = cat02;
	}

	public String getCat03() {
		return cat03;
	}

	public void setCat03(String cat03) {
		this.cat03 = cat03;
	}

	public String getCat04() {
		return cat04;
	}

	public void setCat04(String cat04) {
		this.cat04 = cat04;
	}

	public String getCat05() {
		return cat05;
	}

	public void setCat05(String cat05) {
		this.cat05 = cat05;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getShipCharges() {
		return shipCharges;
	}

	public void setShipCharges(Double shipCharges) {
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

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
    
}