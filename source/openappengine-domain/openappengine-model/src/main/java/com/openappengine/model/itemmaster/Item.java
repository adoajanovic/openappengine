package com.openappengine.model.itemmaster;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.openappengine.model.valueobject.ValueObject;

@Entity
@Table(name="IT_ITEM_MASTER")
public class Item implements ValueObject<Item> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ITEM_ID", unique=true, nullable=false)
	private int itemId;

	@Column(name="IT_CAT01", nullable=true, length=50)
	private String cat01;

	@Column(name="IT_CAT02", nullable=true, length=50)
	private String cat02;

	@Column(name="IT_CAT03", nullable=true, length=50)
	private String cat03;

	@Column(name="IT_CAT04", nullable=true, length=50)
	private String cat04;

	@Column(name="IT_CAT05", nullable=true, length=50)
	private String cat05;
	
	@Column(name="IT_COST", precision=10, scale=2)
	private BigDecimal cost;

	@Column(name="IT_CURCODE", nullable=false, length=50)
	private String curcode;

	@Column(name="IT_DESCRIPTION", nullable=false, length=255)
	private String desc;

	@Column(name="IT_NAME", nullable=false, length=255)
	private String name;

	@Column(name="IT_PERISHABLE", nullable=false)
	private boolean perishable = false;

	@Column(name="IT_PRICE", precision=10, scale=2)
	private BigDecimal price;

	@Column(name="IT_SHIP_CHARGES", precision=10, scale=2)
	private BigDecimal shipCharges;

	@Column(name="IT_STATUS", nullable=false, length=50)
	private String status;

	@Column(name="IT_TYPE", nullable=false, length=50)
	private String type;

	@Column(name="IT_UOM", nullable=false, length=50)
	private String uom;

	@Column(name="IT_WEIGHT", precision=10, scale=2)
	private BigDecimal weight;

    public Item() {
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

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
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

	public boolean sameValueAs(Item other) {
		return this.equals(other);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + itemId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Item other = (Item) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (itemId != other.itemId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
    
}