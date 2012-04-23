/**
 * 
 */
package com.openappengine.fms.interfaces.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.List;

/**
 * @author hrishi
 *
 */
public class SalesOrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer orderId;
	
	private String orderName;
	
	private String status;
	
	private String externalId;
	
	private BigDecimal grandTotal = new BigDecimal(0.0);
	
	private CustomerDTO party = new CustomerDTO();
	
	private List<LineItemDTO> lineItems = new ArrayList<SalesOrderDTO.LineItemDTO>();
	
	public class LineItemDTO {
		
		private int productId;
		
		private int lineNo;
		
		private String productName;
		
		private String unit;
		
		private BigDecimal unitPrice;
		
		private BigDecimal quantity;
		
		private BigDecimal netPrice;
		
		private BigDecimal tax;
		
		private BigDecimal total;

		public int getLineNo() {
			return lineNo;
		}

		public void setLineNo(int lineNo) {
			this.lineNo = lineNo;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getUnit() {
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}

		public BigDecimal getUnitPrice() {
			return unitPrice;
		}

		public void setUnitPrice(BigDecimal unitPrice) {
			this.unitPrice = unitPrice;
		}

		public BigDecimal getQuantity() {
			return quantity;
		}

		public void setQuantity(BigDecimal quantity) {
			this.quantity = quantity;
		}

		public BigDecimal getTax() {
			return tax;
		}

		public void setTax(BigDecimal tax) {
			this.tax = tax;
		}

		public BigDecimal getTotal() {
			return total;
		}

		public void setTotal(BigDecimal total) {
			this.total = total;
		}

		public BigDecimal getNetPrice() {
			return netPrice;
		}

		public void setNetPrice(BigDecimal netPrice) {
			this.netPrice = netPrice;
		}

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}
		
	}

	public CustomerDTO getParty() {
		return party;
	}

	public void setParty(CustomerDTO party) {
		this.party = party;
	}

	public List<LineItemDTO> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItemDTO> lineItems) {
		this.lineItems = lineItems;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

}
