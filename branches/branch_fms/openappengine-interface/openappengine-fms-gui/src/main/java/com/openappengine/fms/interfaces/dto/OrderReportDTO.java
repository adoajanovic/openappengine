/**
 * 
 */
package com.openappengine.fms.interfaces.dto;

import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author hrishikesh.joshi
 *
 */
public class OrderReportDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String fromParty;
	
	private String fromPartyAddress;
	
	private String fromPartyPhone;
	
	private String fromPartyWebsite;
	
	private InputStream fromPartyLogo;
	
	private String toPartyName;
	
	private String receiptBookNo;
	
	private Date orderDate;
	
	private BigDecimal lineTotalPrice;
	
	private BigDecimal totalTax;
	
	private BigDecimal grandTotal;
	
	private List<OrderReportLineItem> orderItems;
	
	public class OrderReportLineItem {
		
		private String productName;
		
		private BigDecimal unitListPrice;
		
		private BigDecimal quantity;
		
		private BigDecimal total;
		
		private BigDecimal tax;
		
		private BigDecimal lineTotal;

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public BigDecimal getUnitListPrice() {
			return unitListPrice;
		}

		public void setUnitListPrice(BigDecimal unitListPrice) {
			this.unitListPrice = unitListPrice;
		}

		public BigDecimal getQuantity() {
			return quantity;
		}

		public void setQuantity(BigDecimal quantity) {
			this.quantity = quantity;
		}

		public BigDecimal getTotal() {
			return total;
		}

		public void setTotal(BigDecimal total) {
			this.total = total;
		}

		public BigDecimal getTax() {
			return tax;
		}

		public void setTax(BigDecimal tax) {
			this.tax = tax;
		}

		public BigDecimal getLineTotal() {
			return lineTotal;
		}

		public void setLineTotal(BigDecimal lineTotal) {
			this.lineTotal = lineTotal;
		}
	}

	public String getFromParty() {
		return fromParty;
	}

	public void setFromParty(String fromParty) {
		this.fromParty = fromParty;
	}

	public String getFromPartyAddress() {
		return fromPartyAddress;
	}

	public void setFromPartyAddress(String fromPartyAddress) {
		this.fromPartyAddress = fromPartyAddress;
	}

	public String getFromPartyPhone() {
		return fromPartyPhone;
	}

	public void setFromPartyPhone(String fromPartyPhone) {
		this.fromPartyPhone = fromPartyPhone;
	}

	public String getFromPartyWebsite() {
		return fromPartyWebsite;
	}

	public void setFromPartyWebsite(String fromPartyWebsite) {
		this.fromPartyWebsite = fromPartyWebsite;
	}

	public InputStream getFromPartyLogo() {
		return fromPartyLogo;
	}

	public void setFromPartyLogo(InputStream fromPartyLogo) {
		this.fromPartyLogo = fromPartyLogo;
	}

	public String getReceiptBookNo() {
		return receiptBookNo;
	}

	public void setReceiptBookNo(String receiptBookNo) {
		this.receiptBookNo = receiptBookNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderReportLineItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderReportLineItem> orderItems) {
		this.orderItems = orderItems;
	}

	public BigDecimal getLineTotalPrice() {
		return lineTotalPrice;
	}

	public void setLineTotalPrice(BigDecimal lineTotalPrice) {
		this.lineTotalPrice = lineTotalPrice;
	}

	public BigDecimal getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getToPartyName() {
		return toPartyName;
	}

	public void setToPartyName(String toPartyName) {
		this.toPartyName = toPartyName;
	}

}
