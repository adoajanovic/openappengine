

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the so_sales_det database table.
 * 
 */
@Entity
@Table(name="so_sales_det")
public class SoSalesDet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="SO_DET_ID")
	private int soDetId;

	@Column(name="SD_COST")
	private BigDecimal sdCost;

	@Column(name="SD_DET_ID")
	private int sdDetId;

	@Column(name="SD_DISCOUNT")
	private BigDecimal sdDiscount;

	@Column(name="SD_ITEM_ID")
	private int sdItemId;

	@Column(name="SD_LINE_NO")
	private int sdLineNo;

	@Column(name="SD_LOCATION")
	private String sdLocation;

	@Column(name="SD_LOT_NO")
	private String sdLotNo;

	@Column(name="SD_ORD_TYPE")
	private String sdOrdType;

	@Column(name="SD_PRICE")
	private BigDecimal sdPrice;

	@Column(name="SD_QTY_ORD")
	private BigDecimal sdQtyOrd;

	@Column(name="SD_UOM")
	private String sdUom;

	@Column(name="SD_WEIGHT")
	private BigDecimal sdWeight;

	@Column(name="SO_COST")
	private BigDecimal soCost;

	@Column(name="SO_DISCOUNT")
	private BigDecimal soDiscount;

	@Column(name="SO_ITEM_ID")
	private int soItemId;

	@Column(name="SO_LINE_NO")
	private int soLineNo;

	@Column(name="SO_LOCATION")
	private String soLocation;

	@Column(name="SO_LOT_NO")
	private String soLotNo;

	@Column(name="SO_ORD_TYPE")
	private String soOrdType;

	@Column(name="SO_PRICE")
	private BigDecimal soPrice;

	@Column(name="SO_QTY_ORD")
	private BigDecimal soQtyOrd;

	@Column(name="SO_UOM")
	private String soUom;

	@Column(name="SO_WEIGHT")
	private BigDecimal soWeight;

	//bi-directional many-to-one association to SoSalesHdr
    @ManyToOne
	@JoinColumn(name="SO_SALES_ID")
	private SoSalesHdr soSalesHdr;

    public SoSalesDet() {
    }

	public int getSoDetId() {
		return this.soDetId;
	}

	public void setSoDetId(int soDetId) {
		this.soDetId = soDetId;
	}

	public BigDecimal getSdCost() {
		return this.sdCost;
	}

	public void setSdCost(BigDecimal sdCost) {
		this.sdCost = sdCost;
	}

	public int getSdDetId() {
		return this.sdDetId;
	}

	public void setSdDetId(int sdDetId) {
		this.sdDetId = sdDetId;
	}

	public BigDecimal getSdDiscount() {
		return this.sdDiscount;
	}

	public void setSdDiscount(BigDecimal sdDiscount) {
		this.sdDiscount = sdDiscount;
	}

	public int getSdItemId() {
		return this.sdItemId;
	}

	public void setSdItemId(int sdItemId) {
		this.sdItemId = sdItemId;
	}

	public int getSdLineNo() {
		return this.sdLineNo;
	}

	public void setSdLineNo(int sdLineNo) {
		this.sdLineNo = sdLineNo;
	}

	public String getSdLocation() {
		return this.sdLocation;
	}

	public void setSdLocation(String sdLocation) {
		this.sdLocation = sdLocation;
	}

	public String getSdLotNo() {
		return this.sdLotNo;
	}

	public void setSdLotNo(String sdLotNo) {
		this.sdLotNo = sdLotNo;
	}

	public String getSdOrdType() {
		return this.sdOrdType;
	}

	public void setSdOrdType(String sdOrdType) {
		this.sdOrdType = sdOrdType;
	}

	public BigDecimal getSdPrice() {
		return this.sdPrice;
	}

	public void setSdPrice(BigDecimal sdPrice) {
		this.sdPrice = sdPrice;
	}

	public BigDecimal getSdQtyOrd() {
		return this.sdQtyOrd;
	}

	public void setSdQtyOrd(BigDecimal sdQtyOrd) {
		this.sdQtyOrd = sdQtyOrd;
	}

	public String getSdUom() {
		return this.sdUom;
	}

	public void setSdUom(String sdUom) {
		this.sdUom = sdUom;
	}

	public BigDecimal getSdWeight() {
		return this.sdWeight;
	}

	public void setSdWeight(BigDecimal sdWeight) {
		this.sdWeight = sdWeight;
	}

	public BigDecimal getSoCost() {
		return this.soCost;
	}

	public void setSoCost(BigDecimal soCost) {
		this.soCost = soCost;
	}

	public BigDecimal getSoDiscount() {
		return this.soDiscount;
	}

	public void setSoDiscount(BigDecimal soDiscount) {
		this.soDiscount = soDiscount;
	}

	public int getSoItemId() {
		return this.soItemId;
	}

	public void setSoItemId(int soItemId) {
		this.soItemId = soItemId;
	}

	public int getSoLineNo() {
		return this.soLineNo;
	}

	public void setSoLineNo(int soLineNo) {
		this.soLineNo = soLineNo;
	}

	public String getSoLocation() {
		return this.soLocation;
	}

	public void setSoLocation(String soLocation) {
		this.soLocation = soLocation;
	}

	public String getSoLotNo() {
		return this.soLotNo;
	}

	public void setSoLotNo(String soLotNo) {
		this.soLotNo = soLotNo;
	}

	public String getSoOrdType() {
		return this.soOrdType;
	}

	public void setSoOrdType(String soOrdType) {
		this.soOrdType = soOrdType;
	}

	public BigDecimal getSoPrice() {
		return this.soPrice;
	}

	public void setSoPrice(BigDecimal soPrice) {
		this.soPrice = soPrice;
	}

	public BigDecimal getSoQtyOrd() {
		return this.soQtyOrd;
	}

	public void setSoQtyOrd(BigDecimal soQtyOrd) {
		this.soQtyOrd = soQtyOrd;
	}

	public String getSoUom() {
		return this.soUom;
	}

	public void setSoUom(String soUom) {
		this.soUom = soUom;
	}

	public BigDecimal getSoWeight() {
		return this.soWeight;
	}

	public void setSoWeight(BigDecimal soWeight) {
		this.soWeight = soWeight;
	}

	public SoSalesHdr getSoSalesHdr() {
		return this.soSalesHdr;
	}

	public void setSoSalesHdr(SoSalesHdr soSalesHdr) {
		this.soSalesHdr = soSalesHdr;
	}
	
}