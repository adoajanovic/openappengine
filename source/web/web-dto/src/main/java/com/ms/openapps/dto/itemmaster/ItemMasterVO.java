/**
 * 
 */
package com.ms.openapps.dto.itemmaster;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author hrishi
 * 
 */
public class ItemMasterVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigInteger itemId;

	private String name;

	private String desc;

	private String type;

	private String uom;

	private String status;

	private BigDecimal cost;

	private BigDecimal price;
	
	private BigDecimal weight;
	
	private String curCode;
	
	private BigDecimal shipCharge;
	
	private Boolean perishable;
	
	private String catCode01;
	
	private String catCode02;
	
	private String catCode03;
	
	private String catCode04;

	private String catCode05;

	private String user;

	public BigInteger getItemId() {
		return itemId;
	}

	public void setItemId(BigInteger itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getCurCode() {
		return curCode;
	}

	public void setCurCode(String curCode) {
		this.curCode = curCode;
	}

	public BigDecimal getShipCharge() {
		return shipCharge;
	}

	public void setShipCharge(BigDecimal shipCharge) {
		this.shipCharge = shipCharge;
	}

	public Boolean getPerishable() {
		return perishable;
	}

	public void setPerishable(Boolean perishable) {
		this.perishable = perishable;
	}

	public String getCatCode01() {
		return catCode01;
	}

	public void setCatCode01(String catCode01) {
		this.catCode01 = catCode01;
	}

	public String getCatCode02() {
		return catCode02;
	}

	public void setCatCode02(String catCode02) {
		this.catCode02 = catCode02;
	}

	public String getCatCode03() {
		return catCode03;
	}

	public void setCatCode03(String catCode03) {
		this.catCode03 = catCode03;
	}

	public String getCatCode04() {
		return catCode04;
	}

	public void setCatCode04(String catCode04) {
		this.catCode04 = catCode04;
	}

	public String getCatCode05() {
		return catCode05;
	}

	public void setCatCode05(String catCode05) {
		this.catCode05 = catCode05;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
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
		ItemMasterVO other = (ItemMasterVO) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemMasterVO [itemId=" + itemId + ", name=" + name + ", desc="
				+ desc + ", type=" + type + ", uom=" + uom + ", status="
				+ status + ", cost=" + cost + ", weight=" + weight
				+ ", curCode=" + curCode + ", shipCharge=" + shipCharge
				+ ", perishable=" + perishable + ", catCode01=" + catCode01
				+ ", catCode02=" + catCode02 + "]";
	}

}
