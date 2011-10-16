package com.openappengine.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.openappengine.repository.entity.GenericEntity;


/**
 * The persistent class for the it_item_master database table.
 * 
 */
@Entity
@Table(name="it_item_master")
public class ItItemMaster extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ITEM_ID", unique=true, nullable=false)
	private int itemId;

	@Column(name="CAT01", nullable=true, length=15)
	private String cat01;

	@Column(name="CAT02", nullable=true, length=15)
	private String cat02;

	@Column(name="CAT03", nullable=true, length=15)
	private String cat03;

	@Column(name="CAT04", nullable=true, length=15)
	private String cat04;

	@Column(name="CAT05", nullable=true, length=15)
	private String cat05;

	@Column(name="COST", precision=10, scale=2)
	private BigDecimal cost;

	@Column(name="CURCODE", nullable=false, length=5)
	private String curcode;

	@Column(name="DESCRIPTION", nullable=false, length=255)
	private String desc;

	@Column(name="NAME", nullable=false, length=255)
	private String name;

	@Column(name="PERISHABLE", nullable=false)
	private boolean perishable = false;

	@Column(name="PRICE", precision=10, scale=2)
	private BigDecimal price;

	@Column(name="SHIP_CHARGES", precision=10, scale=2)
	private BigDecimal shipCharges;

	@Column(name="STATUS", nullable=false, length=5)
	private String status;

	@Column(name="TYPE", nullable=false, length=5)
	private String type;

	@Column(name="UOM", nullable=false, length=5)
	private String uom;

	@Column(name="WEIGHT", precision=10, scale=2)
	private BigDecimal weight;

    public ItItemMaster() {
    }

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getCat01() {
		return this.cat01;
	}

	public void setCat01(String cat01) {
		this.cat01 = cat01;
	}

	public String getCat02() {
		return this.cat02;
	}

	public void setCat02(String cat02) {
		this.cat02 = cat02;
	}

	public String getCat03() {
		return this.cat03;
	}

	public void setCat03(String cat03) {
		this.cat03 = cat03;
	}

	public String getCat04() {
		return this.cat04;
	}

	public void setCat04(String cat04) {
		this.cat04 = cat04;
	}

	public String getCat05() {
		return this.cat05;
	}

	public void setCat05(String cat05) {
		this.cat05 = cat05;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getCurcode() {
		return this.curcode;
	}

	public void setCurcode(String curcode) {
		this.curcode = curcode;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return this.name;
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
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getShipCharges() {
		return this.shipCharges;
	}

	public void setShipCharges(BigDecimal shipCharges) {
		this.shipCharges = shipCharges;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
}