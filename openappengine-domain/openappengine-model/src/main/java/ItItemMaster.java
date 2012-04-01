

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the it_item_master database table.
 * 
 */
@Entity
@Table(name="it_item_master")
public class ItItemMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ITEM_ID")
	private int itemId;

	@Column(name="IT_CAT01")
	private String itCat01;

	@Column(name="IT_CAT02")
	private String itCat02;

	@Column(name="IT_CAT03")
	private String itCat03;

	@Column(name="IT_CAT04")
	private String itCat04;

	@Column(name="IT_CAT05")
	private String itCat05;

	@Column(name="IT_COST")
	private BigDecimal itCost;

	@Column(name="IT_CURCODE")
	private String itCurcode;

	@Column(name="IT_DESCRIPTION")
	private String itDescription;

	@Column(name="IT_NAME")
	private String itName;

	@Column(name="IT_PERISHABLE")
	private byte itPerishable;

	@Column(name="IT_PRICE")
	private BigDecimal itPrice;

	@Column(name="IT_SHIP_CHARGES")
	private BigDecimal itShipCharges;

	@Column(name="IT_STATUS")
	private String itStatus;

	@Column(name="IT_TYPE")
	private String itType;

	@Column(name="IT_UOM")
	private String itUom;

	@Column(name="IT_WEIGHT")
	private BigDecimal itWeight;

    public ItItemMaster() {
    }

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItCat01() {
		return this.itCat01;
	}

	public void setItCat01(String itCat01) {
		this.itCat01 = itCat01;
	}

	public String getItCat02() {
		return this.itCat02;
	}

	public void setItCat02(String itCat02) {
		this.itCat02 = itCat02;
	}

	public String getItCat03() {
		return this.itCat03;
	}

	public void setItCat03(String itCat03) {
		this.itCat03 = itCat03;
	}

	public String getItCat04() {
		return this.itCat04;
	}

	public void setItCat04(String itCat04) {
		this.itCat04 = itCat04;
	}

	public String getItCat05() {
		return this.itCat05;
	}

	public void setItCat05(String itCat05) {
		this.itCat05 = itCat05;
	}

	public BigDecimal getItCost() {
		return this.itCost;
	}

	public void setItCost(BigDecimal itCost) {
		this.itCost = itCost;
	}

	public String getItCurcode() {
		return this.itCurcode;
	}

	public void setItCurcode(String itCurcode) {
		this.itCurcode = itCurcode;
	}

	public String getItDescription() {
		return this.itDescription;
	}

	public void setItDescription(String itDescription) {
		this.itDescription = itDescription;
	}

	public String getItName() {
		return this.itName;
	}

	public void setItName(String itName) {
		this.itName = itName;
	}

	public byte getItPerishable() {
		return this.itPerishable;
	}

	public void setItPerishable(byte itPerishable) {
		this.itPerishable = itPerishable;
	}

	public BigDecimal getItPrice() {
		return this.itPrice;
	}

	public void setItPrice(BigDecimal itPrice) {
		this.itPrice = itPrice;
	}

	public BigDecimal getItShipCharges() {
		return this.itShipCharges;
	}

	public void setItShipCharges(BigDecimal itShipCharges) {
		this.itShipCharges = itShipCharges;
	}

	public String getItStatus() {
		return this.itStatus;
	}

	public void setItStatus(String itStatus) {
		this.itStatus = itStatus;
	}

	public String getItType() {
		return this.itType;
	}

	public void setItType(String itType) {
		this.itType = itType;
	}

	public String getItUom() {
		return this.itUom;
	}

	public void setItUom(String itUom) {
		this.itUom = itUom;
	}

	public BigDecimal getItWeight() {
		return this.itWeight;
	}

	public void setItWeight(BigDecimal itWeight) {
		this.itWeight = itWeight;
	}

}