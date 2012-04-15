/**
 * 
 */
package com.openappengine.fms.form;

import java.util.Calendar;
import java.util.Date;

import org.apache.pivot.beans.BeanAdapter;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.HashMap;
import org.apache.pivot.collections.List;
import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Component;
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

	@Override
	protected void initFormBean(Map<String, Object> namespace) {
		// TODO Auto-generated method stub
		super.initFormBean(namespace);
	}

	@Override
	protected void initFormActions(final Map<String, Object> namespace) {
		PushButton searchButton = (PushButton) namespace.get("searchButton");
		PushButton clearButton = (PushButton) namespace.get("clearButton");
		PushButton openButton = (PushButton) namespace.get("openButton");
		
		searchButton.setAction(new Action() {
			@Override
			public void perform(Component source) {
				store(OrderListingForm.this);
				refreshOrderListingTable(namespace);	
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
		orderTableView.setWidth(500);
		
		Calendar calendarFrom = Calendar.getInstance();
		int startMon = calendarFrom.getActualMinimum(Calendar.DATE);
		calendarFrom.set(Calendar.DATE, startMon);
		setFromDate(calendarFrom.getTime());
		
		Calendar calendarTo = Calendar.getInstance();
		int endMon = calendarTo.getActualMaximum(Calendar.DATE);
		calendarTo.set(Calendar.DATE, endMon);
		setToDate(calendarTo.getTime());
		
		refreshOrderListingTable(namespace);
		load(new BeanAdapter(OrderListingForm.this));
	}

	private void refreshOrderListingTable(Map<String, Object> namespace) {
		TableView orderTableView = (TableView) namespace.get("orderTableView");
		
		OrderSearchDTO dto = new OrderSearchDTO();
		dto.setExternalId(externalId);
		dto.setFromDate(fromDate);
		dto.setToDate(toDate);
		dto.setOrderStatus("ORDER_CREATED");
		
		setOrderListItems(getFleetManagerServiceFacade().loadOrderListItems(dto));
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

}
