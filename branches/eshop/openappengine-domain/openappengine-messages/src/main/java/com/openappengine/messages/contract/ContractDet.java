/**
 * 
 */
package com.openappengine.messages.contract;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author hrishi
 *
 */
public class ContractDet implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int cnContractDetId;

	private BigDecimal cnCost;

	private BigDecimal cnDiscount;

	private int cnItemId;

	private String cnLocation;

	private String cnLotNo;

	private String cnOrdType;

	private BigDecimal cnPrice;

	private BigDecimal cnQtyOrd;

	private String cnUom;

	private BigDecimal cnWeight;

	public int getCnContractDetId() {
		return cnContractDetId;
	}

	public void setCnContractDetId(int cnContractDetId) {
		this.cnContractDetId = cnContractDetId;
	}

	public BigDecimal getCnCost() {
		return cnCost;
	}

	public void setCnCost(BigDecimal cnCost) {
		this.cnCost = cnCost;
	}

	public BigDecimal getCnDiscount() {
		return cnDiscount;
	}

	public void setCnDiscount(BigDecimal cnDiscount) {
		this.cnDiscount = cnDiscount;
	}

	public int getCnItemId() {
		return cnItemId;
	}

	public void setCnItemId(int cnItemId) {
		this.cnItemId = cnItemId;
	}

	public String getCnLocation() {
		return cnLocation;
	}

	public void setCnLocation(String cnLocation) {
		this.cnLocation = cnLocation;
	}

	public String getCnLotNo() {
		return cnLotNo;
	}

	public void setCnLotNo(String cnLotNo) {
		this.cnLotNo = cnLotNo;
	}

	public String getCnOrdType() {
		return cnOrdType;
	}

	public void setCnOrdType(String cnOrdType) {
		this.cnOrdType = cnOrdType;
	}

	public BigDecimal getCnPrice() {
		return cnPrice;
	}

	public void setCnPrice(BigDecimal cnPrice) {
		this.cnPrice = cnPrice;
	}

	public BigDecimal getCnQtyOrd() {
		return cnQtyOrd;
	}

	public void setCnQtyOrd(BigDecimal cnQtyOrd) {
		this.cnQtyOrd = cnQtyOrd;
	}

	public String getCnUom() {
		return cnUom;
	}

	public void setCnUom(String cnUom) {
		this.cnUom = cnUom;
	}

	public BigDecimal getCnWeight() {
		return cnWeight;
	}

	public void setCnWeight(BigDecimal cnWeight) {
		this.cnWeight = cnWeight;
	}

}
