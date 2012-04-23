/**
 * 
 */
package com.openappengine.fms.form;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.pivot.beans.BeanAdapter;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.HashMap;
import org.apache.pivot.collections.List;
import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.LinkButton;
import org.apache.pivot.wtk.MessageType;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.TableView;

import com.openappengine.fms.interfaces.dto.OrderListItemDTO;
import com.openappengine.fms.interfaces.dto.OrderSearchDTO;
import com.openappengine.fms.util.PivotUtils;

/**
 * @author hrishi
 *
 */
public class OrderListingForm extends FleetManagerForm {
	
	private List<OrderListItemDTO> orderListItems;
	private String externalId;
	private Date fromDate;
	private Date toDate;
	private String status;
	
	private BigDecimal totalTaxableAmount = new BigDecimal(0.0);
	private BigDecimal totalTax = new BigDecimal(0.0);
	private BigDecimal grandTotal = new BigDecimal(0.0);
	
	private BigDecimal totalTaxableAmountCancelled = new BigDecimal(0.0);
	private BigDecimal totalTaxCancelled = new BigDecimal(0.0);
	private BigDecimal grandTotalCancelled = new BigDecimal(0.0);
	
	private BigDecimal totalTaxableAmountNet = new BigDecimal(0.0);
	private BigDecimal totalTaxNet = new BigDecimal(0.0);
	private BigDecimal grandTotalNet = new BigDecimal(0.0);
	
	@Override
	protected void initFormBean(Map<String, Object> namespace) {
		// TODO Auto-generated method stub
		super.initFormBean(namespace);
	}

	@Override
	protected void initFormActions(final Map<String, Object> namespace) {
		PushButton searchButton = (PushButton) namespace.get("searchButton");
		PushButton clearButton = (PushButton) namespace.get("clearButton");
		LinkButton openButton = (LinkButton) namespace.get("openButton");
		
		searchButton.setAction(new Action() {
			@Override
			public void perform(Component source) {
				store(OrderListingForm.this);
				refreshOrderListingTable(namespace);
				load(new BeanAdapter(OrderListingForm.this));
			}
		});
		
		clearButton.setAction(new Action() {
			@Override
			public void perform(Component source) {
				TableView orderTableView = (TableView) namespace.get("orderTableView");
				orderTableView.setTableData(new ArrayList<OrderListItemDTO>());
			}
		});
		
		openButton.setAction(new Action() {
			@Override
			public void perform(Component source) {
				TableView orderTableView = (TableView) namespace.get("orderTableView");
				if(orderTableView.getSelectedRow() == null) {
					Alert.alert(MessageType.ERROR, "No Row Selected.", getWindow());
					return;
				}
				
				OrderListItemDTO dto = (OrderListItemDTO) orderTableView.getSelectedRow();
				Map<String, Object> salesOrderFormContext = new HashMap<String, Object>();
				salesOrderFormContext.put("paramExternalId", dto.getExternalId());
				
				PivotUtils.addTab(OrderListingForm.this, "SalesOrder.bxml",salesOrderFormContext,dto.getExternalId());
			}
		});
	}

	@Override
	protected void initFormElements(Map<String, Object> namespace) {
		TableView orderTableView = (TableView) namespace.get("orderTableView");

		orderTableView.setWidth(1000);
		Calendar calendarFrom = Calendar.getInstance();
		int startMon = calendarFrom.getActualMinimum(Calendar.DATE);
		calendarFrom.set(Calendar.DATE, startMon);
		setFromDate(calendarFrom.getTime());
		
		Calendar calendarTo = Calendar.getInstance();
		int endMon = calendarTo.getActualMaximum(Calendar.DATE);
		calendarTo.set(Calendar.DATE, endMon);
		setToDate(calendarTo.getTime());
		
		status = "";
		
		refreshOrderListingTable(namespace);
		load(new BeanAdapter(OrderListingForm.this));
	}

	private void refreshOrderListingTable(Map<String, Object> namespace) {
		TableView orderTableView = (TableView) namespace.get("orderTableView");
		
		OrderSearchDTO dto = new OrderSearchDTO();
		dto.setExternalId(externalId);
		dto.setFromDate(fromDate);
		dto.setToDate(toDate);
		dto.setOrderStatus(status);
		
		List<OrderListItemDTO> orderListItems = getFleetManagerServiceFacade().loadOrderListItems(dto);
		setOrderListItems(orderListItems);
		
		totalTaxableAmount = new BigDecimal(0.0);
		totalTax = new BigDecimal(0.0);
		grandTotal = new BigDecimal(0.0);
		
		totalTaxableAmountCancelled = new BigDecimal(0.0);
		totalTaxCancelled = new BigDecimal(0.0);
		grandTotalCancelled = new BigDecimal(0.0);
		
		totalTaxableAmountNet = new BigDecimal(0.0);
		totalTaxNet = new BigDecimal(0.0);
		grandTotalNet = new BigDecimal(0.0);
		
		if(orderListItems != null && !orderListItems.isEmpty()) {
			for (OrderListItemDTO orderListItemDTO : orderListItems) {
				totalTaxableAmount = totalTaxableAmount.add(orderListItemDTO.getTaxableAmount());
				totalTax = totalTax.add(orderListItemDTO.getTotalTax());
				setGrandTotal(getGrandTotal().add(orderListItemDTO.getGrandTotal()));
				
				if(StringUtils.equals(orderListItemDTO.getStatus(), "ORDER_CANCELLED")) {
					totalTaxableAmountCancelled = totalTaxableAmountCancelled.add(orderListItemDTO.getTaxableAmount());
					totalTaxCancelled = totalTaxCancelled.add(orderListItemDTO.getTotalTax());
					grandTotalCancelled = grandTotalCancelled.add(orderListItemDTO.getGrandTotal());
				}
			}
		}
	
		totalTaxableAmountNet = totalTaxableAmount.subtract(totalTaxableAmountCancelled);
		totalTaxNet = totalTax.subtract(totalTaxCancelled);
		grandTotalNet= grandTotal.subtract(grandTotalCancelled);
		
		orderTableView.setTableData(getOrderListItems());
	}

	public List<OrderListItemDTO> getOrderListItems() {
		return orderListItems;
	}

	public void setOrderListItems(List<OrderListItemDTO> orderListItems) {
		this.orderListItems = orderListItems;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public BigDecimal getTotalTaxableAmount() {
		return totalTaxableAmount;
	}

	public void setTotalTaxableAmount(BigDecimal totalTaxableAmount) {
		this.totalTaxableAmount = totalTaxableAmount;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTotalTaxableAmountCancelled() {
		return totalTaxableAmountCancelled;
	}

	public void setTotalTaxableAmountCancelled(BigDecimal totalTaxableAmountCancelled) {
		this.totalTaxableAmountCancelled = totalTaxableAmountCancelled;
	}

	public BigDecimal getTotalTaxCancelled() {
		return totalTaxCancelled;
	}

	public void setTotalTaxCancelled(BigDecimal totalTaxCancelled) {
		this.totalTaxCancelled = totalTaxCancelled;
	}

	public BigDecimal getGrandTotalCancelled() {
		return grandTotalCancelled;
	}

	public void setGrandTotalCancelled(BigDecimal grandTotalCancelled) {
		this.grandTotalCancelled = grandTotalCancelled;
	}

	public BigDecimal getTotalTaxableAmountNet() {
		return totalTaxableAmountNet;
	}

	public void setTotalTaxableAmountNet(BigDecimal totalTaxableAmountNet) {
		this.totalTaxableAmountNet = totalTaxableAmountNet;
	}

	public BigDecimal getTotalTaxNet() {
		return totalTaxNet;
	}

	public void setTotalTaxNet(BigDecimal totalTaxNet) {
		this.totalTaxNet = totalTaxNet;
	}

	public BigDecimal getGrandTotalNet() {
		return grandTotalNet;
	}

	public void setGrandTotalNet(BigDecimal grandTotalNet) {
		this.grandTotalNet = grandTotalNet;
	}
}
