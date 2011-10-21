package com.openappengine.model.salesorder;

import java.io.Serializable;

import com.openappengine.model.itemmaster.Item;
import com.openappengine.model.valueobject.ValueObject;


public class SalesDet implements ValueObject<SalesDet> {
	
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

	private Item item;

	private SalesHdr salesHdr;

    public SalesDet() {
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

	public Item getItemMaster() {
		return item;
	}

	public void setItemMaster(Item item) {
		this.item = item;
	}

	public SalesHdr getSalesHdr() {
		return salesHdr;
	}

	public void setSalesHdr(SalesHdr salesHdr) {
		this.salesHdr = salesHdr;
	}

	@Override
	public boolean sameValueAs(SalesDet other) {
		return this.equals(other);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result
				+ ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + lineNo;
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((lotNo == null) ? 0 : lotNo.hashCode());
		result = prime * result + ((ordType == null) ? 0 : ordType.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((qtyOrd == null) ? 0 : qtyOrd.hashCode());
		result = prime * result
				+ ((salesHdr == null) ? 0 : salesHdr.hashCode());
		result = prime * result + ((uom == null) ? 0 : uom.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		SalesDet other = (SalesDet) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (lineNo != other.lineNo)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (lotNo == null) {
			if (other.lotNo != null)
				return false;
		} else if (!lotNo.equals(other.lotNo))
			return false;
		if (ordType == null) {
			if (other.ordType != null)
				return false;
		} else if (!ordType.equals(other.ordType))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (qtyOrd == null) {
			if (other.qtyOrd != null)
				return false;
		} else if (!qtyOrd.equals(other.qtyOrd))
			return false;
		if (salesHdr == null) {
			if (other.salesHdr != null)
				return false;
		} else if (!salesHdr.equals(other.salesHdr))
			return false;
		if (uom == null) {
			if (other.uom != null)
				return false;
		} else if (!uom.equals(other.uom))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
}