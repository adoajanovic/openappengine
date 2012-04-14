/**
 * 
 */
package com.openappengine.fms.form;

import java.math.BigDecimal;

import org.apache.pivot.beans.BeanAdapter;
import org.apache.pivot.collections.HashMap;
import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.Dialog;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Form;
import org.apache.pivot.wtk.LinkButton;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.Window;
import org.apache.pivot.wtk.WindowStateListener;

import com.openappengine.fms.interfaces.dto.CustomerDTO;
import com.openappengine.fms.interfaces.dto.OrderItemDTO;
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
	
	@Override
	protected void initFormBean(Map<String, Object> namespace) {
		refreshFormDTO();
		
		try {
			String salesOrderExternalId = getFleetManagerServiceFacade().getSalesOrderExternalId();
			salesOrderDTO.setExternalId(salesOrderExternalId);
			
		} catch (ServiceException e) {
			throw new RuntimeException();
		}
		
		this.load(new BeanAdapter(salesOrderDTO));
	}

	@Override
	protected void initFormActions(Map<String, Object> namespace) {
		LinkButton searchCustomerLink = (LinkButton) namespace.get("searchCustomerLink");
		LinkButton addLineItemLink = (LinkButton) namespace.get("addLineItemLink");
		PushButton saveButton = (PushButton) namespace.get("saveButton");
		
		addLineItemLink.setAction(new Action() {
			@Override
			public void perform(Component source) {
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
				getFleetManagerServiceFacade().createOrder(salesOrderDTO);
			}
		});
	}

	private void refreshFormDTO() {
		salesOrderDTO = new SalesOrderDTO();
		
		/*salesOrderDTO.getParty().setSalutation("Mr.");
		salesOrderDTO.getParty().setFirstName("Hrishikesh");
		salesOrderDTO.getParty().setMiddleName("Shrikant");
		salesOrderDTO.getParty().setLastName("Joshi");

		Date date = new Date();
		date = DateUtils.setDays(date, 23);
		date = DateUtils.setMonths(date, 0);
		date = DateUtils.setYears(date, 1987);
		salesOrderDTO.getParty().setBirthDate(date);
		
		LineItemDTO lineItemDTO = salesOrderDTO.new LineItemDTO();
		salesOrderDTO.getLineItems().add(lineItemDTO);
		 */
	}
}
