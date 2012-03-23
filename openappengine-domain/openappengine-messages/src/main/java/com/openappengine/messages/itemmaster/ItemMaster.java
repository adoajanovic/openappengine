package com.openappengine.messages.itemmaster;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ItemMaster {

	protected BigInteger itemId;

	protected String name;
	protected String desc;
	protected String type;
	protected String uom;
	protected String status;
	protected BigDecimal cost;
	protected BigDecimal price;
	protected BigDecimal weight;
	protected String curCode;
	protected BigDecimal shipCharge;
	private Boolean perishable;
	protected String catCode01;
	protected String catCode02;
	protected String catCode03;
	protected String catCode04;
	protected String catCode05;
	protected String user;

	public BigInteger getItemId() {
		return itemId;
	}

	public void setItemId(BigInteger value) {
		this.itemId = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String value) {
		this.desc = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String value) {
		this.type = value;
	}

	public String getUOM() {
		return uom;
	}

	public void setUOM(String value) {
		this.uom = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String value) {
		this.status = value;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal value) {
		this.cost = value;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal value) {
		this.price = value;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal value) {
		this.weight = value;
	}

	public String getCurCode() {
		return curCode;
	}

	public void setCurCode(String value) {
		this.curCode = value;
	}

	public BigDecimal getShipCharge() {
		return shipCharge;
	}

	public void setShipCharge(BigDecimal value) {
		this.shipCharge = value;
	}

	public String getCatCode01() {
		return catCode01;
	}

	public void setCatCode01(String value) {
		this.catCode01 = value;
	}

	public String getCatCode02() {
		return catCode02;
	}

	public void setCatCode02(String value) {
		this.catCode02 = value;
	}

	public String getCatCode03() {
		return catCode03;
	}

	public void setCatCode03(String value) {
		this.catCode03 = value;
	}

	public String getCatCode04() {
		return catCode04;
	}

	public void setCatCode04(String value) {
		this.catCode04 = value;
	}

	public String getCatCode05() {
		return catCode05;
	}

	public void setCatCode05(String value) {
		this.catCode05 = value;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String value) {
		this.user = value;
	}

	public Boolean getPerishable() {
		return perishable;
	}

	public void setPerishable(Boolean perishable) {
		this.perishable = perishable;
	}

}