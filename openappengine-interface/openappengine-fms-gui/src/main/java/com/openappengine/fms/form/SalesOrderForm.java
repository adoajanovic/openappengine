/**
 * 
 */
package com.openappengine.fms.form;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.apache.pivot.beans.BeanAdapter;
import org.apache.pivot.collections.HashMap;
import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.Dialog;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Form;
import org.apache.pivot.wtk.LinkButton;
import org.apache.pivot.wtk.MessageType;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.TableView;
import org.apache.pivot.wtk.TextInput;
import org.apache.pivot.wtk.Window;
import org.apache.pivot.wtk.WindowStateListener;

import com.openappengine.fms.interfaces.dto.CustomerDTO;
import com.openappengine.fms.interfaces.dto.OrderItemDTO;
import com.openappengine.fms.interfaces.dto.OrderReportDTO;
import com.openappengine.fms.interfaces.dto.SalesOrderDTO;
import com.openappengine.fms.interfaces.dto.SalesOrderDTO.LineItemDTO;
import com.openappengine.fms.util.PivotUtils;
import com.openappengine.service.api.ServiceException;

/**
 * @author hrishi
 *
 */
public class SalesOrderForm extends FleetManagerForm {

	private SalesOrderDTO salesOrderDTO;
	
	private Integer partyId;

	private String externalId;
	
	private String status;
	
	@Override
	protected void initFormBean(Map<String, Object> namespace) {
		LinkButton searchCustomerLink = (LinkButton) namespace.get("searchCustomerLink");
		LinkButton addLineItemLink = (LinkButton) namespace.get("addLineItemLink");
		PushButton saveButton = (PushButton) namespace.get("saveButton");
		PushButton resetButton = (PushButton) namespace.get("resetButton");
		PushButton printButton = (PushButton) namespace.get("printButton");
		
		TextInput orderName = (TextInput) namespace.get("orderName");
		PushButton cancelButton = (PushButton) namespace.get("cancelButton");
		LinkButton editLineItemLink = (LinkButton) namespace.get("editLineItemLink");
		LinkButton deleteLineItemLink = (LinkButton) namespace.get("deleteLineItemLink");
		
		externalId = (String) namespace.get("paramExternalId");
		
		if(!StringUtils.isEmpty(externalId)) {
			salesOrderDTO = getFleetManagerServiceFacade().getSalesOrderDTO(externalId);
			salesOrderDTO.setExternalId(externalId);
			
			if(StringUtils.equals(salesOrderDTO.getStatus(), "ORDER_CREATED")) {
				searchCustomerLink.setVisible(false);
				addLineItemLink.setVisible(false);
				saveButton.setVisible(false);
				resetButton.setVisible(false);
				orderName.setEnabled(false);
				editLineItemLink.setVisible(false);
				deleteLineItemLink.setVisible(false);
				cancelButton.setVisible(true);
				printButton.setVisible(true);
			} else if(!StringUtils.equals(status, "ORDER_CANCELLED")) {
				searchCustomerLink.setVisible(false);
				addLineItemLink.setVisible(false);
				saveButton.setVisible(false);
				resetButton.setVisible(false);
				orderName.setEnabled(false);
				editLineItemLink.setVisible(false);
				deleteLineItemLink.setVisible(false);
				
				cancelButton.setVisible(false);
				printButton.setVisible(false);
			}
		} else {
			try {
				externalId = getFleetManagerServiceFacade().getSalesOrderExternalId();
				status = "ORDER_PROCESSING";
				refreshFormDTO();
			} catch (ServiceException e) {
				throw new RuntimeException();
			}
			
			cancelButton.setVisible(false);
			printButton.setVisible(false);
		}
		
		this.load(new BeanAdapter(salesOrderDTO));
	}

	@Override
	protected void initFormActions(final Map<String, Object> namespace) {
		LinkButton searchCustomerLink = (LinkButton) namespace.get("searchCustomerLink");
		LinkButton addLineItemLink = (LinkButton) namespace.get("addLineItemLink");
		PushButton saveButton = (PushButton) namespace.get("saveButton");
		PushButton cancelButton = (PushButton) namespace.get("cancelButton");
		PushButton printButton = (PushButton) namespace.get("printButton");
		PushButton resetButton = (PushButton) namespace.get("resetButton");
		LinkButton editLineItemLink = (LinkButton) namespace.get("editLineItemLink");
		LinkButton deleteLineItemLink = (LinkButton) namespace.get("deleteLineItemLink");
		final TableView lineItemsTableView = (TableView) namespace.get("lineItemsTableView");
		
		editLineItemLink.setAction(new Action() {
			@Override
			public void perform(Component source) {
				//TODO
			}
		});
		
		deleteLineItemLink.setAction(new Action() {
			@Override
			public void perform(Component source) {
				if(lineItemsTableView.getSelectedRow() == null) {
					Alert.alert(MessageType.ERROR, "Please select a row to delete", getWindow());
					return;
				}
				
				LineItemDTO lineItemDTO = (LineItemDTO) lineItemsTableView.getSelectedRow();
				BigDecimal total = salesOrderDTO.getGrandTotal().subtract(lineItemDTO.getTotal());
				salesOrderDTO.setGrandTotal(total);
				
				salesOrderDTO.getLineItems().remove(lineItemDTO);				
				SalesOrderForm.this.load(new BeanAdapter(salesOrderDTO));
			}
		});
		
		addLineItemLink.setAction(new Action() {
			@Override
			public void perform(Component source) {
				
				SalesOrderForm.this.store(salesOrderDTO);
				
				final Form addOrderItemForm = (Form) PivotUtils.readObject("AddLineItem.bxml", new HashMap<String, Object>());
				Dialog dialog = new Dialog(true);
				dialog.setTitle("Add Line Item");
				dialog.setContent(addOrderItemForm);
				
				dialog.getWindowStateListeners().add(new WindowStateListener.Adapter(){
					@Override
					public void windowClosed(Window window, Display display,
							Window owner) {
						OrderItemDTO orderItemDTO = ((AddOrderItemForm)addOrderItemForm).getSelectedItemDTO();
						int lineNo = salesOrderDTO.getLineItems().getLength() + 1;
						if(orderItemDTO != null) {
							LineItemDTO lineItemDTO = salesOrderDTO.new LineItemDTO();
							lineItemDTO.setProductId(orderItemDTO.getProductId());
							lineItemDTO.setLineNo(lineNo);
							lineItemDTO.setProductName(orderItemDTO.getProductName());
							lineItemDTO.setQuantity(orderItemDTO.getQuantity());
							lineItemDTO.setTax(orderItemDTO.getTotalTax());
							lineItemDTO.setNetPrice(orderItemDTO.getListPrice());
							lineItemDTO.setTotal(orderItemDTO.getTotal());
							lineItemDTO.setUnitPrice(orderItemDTO.getUnitPrice());
							
							if(salesOrderDTO.getGrandTotal() == null) {
								salesOrderDTO.setGrandTotal(new BigDecimal(0.0));
							}
							
							BigDecimal total = salesOrderDTO.getGrandTotal().add(lineItemDTO.getTotal());
							salesOrderDTO.setGrandTotal(total);
							salesOrderDTO.getLineItems().add(lineItemDTO);
							
							SalesOrderForm.this.load(new BeanAdapter(salesOrderDTO));
						}
					}
				});
				
				dialog.open(getWindow());
			}
		});
		
		searchCustomerLink.setAction(new Action() {
			@Override
			public void perform(Component source) {
				
				SalesOrderForm.this.store(salesOrderDTO);
				
				final Form customerSearchForm = (Form) PivotUtils.readObject("CustomerSearch.bxml", new HashMap<String, Object>());
				Dialog dialog = new Dialog(true);
				dialog.setContent(customerSearchForm);
				
				dialog.getWindowStateListeners().add(new WindowStateListener.Adapter() {

					@Override
					public void windowClosed(Window window, Display display,Window owner) {
						partyId = ((CustomerSearchForm)customerSearchForm).getSelectedId();
						if(partyId != null) {
							CustomerDTO customerDTO = getFleetManagerServiceFacade().loadCustomerDTO(partyId);
							salesOrderDTO.setParty(customerDTO);
							SalesOrderForm.this.load(new BeanAdapter(salesOrderDTO));
						}
					}
				});
				
				dialog.open(getWindow());
			}
		});
		
		saveButton.setAction(new Action() {
			@Override
			public void perform(Component source) {
				SalesOrderForm.this.store(salesOrderDTO);
				
				if(salesOrderDTO.getParty() == null || salesOrderDTO.getParty().getPartyId() == 0) {
					Alert.alert(MessageType.ERROR, "No Customer selected.", getWindow());
					return;
				}
				
				if(salesOrderDTO.getLineItems() == null || salesOrderDTO.getLineItems().isEmpty()) {
					Alert.alert(MessageType.ERROR, "No Line Item present for the order.", getWindow());
					return;
				}
				
				if(StringUtils.isEmpty(salesOrderDTO.getOrderName())) {
					salesOrderDTO.setOrderName(externalId);
				}
				boolean success = true;
				try {
					getFleetManagerServiceFacade().createOrder(salesOrderDTO);
				} catch (Exception e) {
					success = false;
					Alert.alert(MessageType.ERROR, "Error encountered while saving the Order. Exception : " + e.getLocalizedMessage(), getWindow());
				}
				
				if(success) {
					Alert.alert(MessageType.INFO, "Sales Order : " + salesOrderDTO.getExternalId() + " saved.",getWindow());
					namespace.put("paramExternalId", salesOrderDTO.getExternalId());
					//getFleetManagerServiceFacade().printOrder(salesOrderDTO.getOrderId());
					initFormBean(namespace);
				}
			}
		});
		
		if(cancelButton.isVisible()) {
			cancelButton.setAction(new Action() {
				@Override
				public void perform(Component source) {
					getFleetManagerServiceFacade().cancelSalesOrder(salesOrderDTO.getExternalId());
				}
			});
		}
		
		
		
		resetButton.setAction(new Action() {
			@Override
			public void perform(Component source) {
				refreshFormDTO();
				SalesOrderForm.this.load(new BeanAdapter(salesOrderDTO));
			}
		});
		
		printButton.setAction(new Action() {
			@Override
			public void perform(Component source) {
				getFleetManagerServiceFacade().printOrder(externalId);	
			}
		});
	}

	private void refreshFormDTO() {
		salesOrderDTO = new SalesOrderDTO();
		salesOrderDTO.setExternalId(externalId);
		salesOrderDTO.setStatus(status);
	}
}
