/**
 * 
 */
package com.ms.openapps.web.application.helper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

/**
 * @author hrishi
 *
 */
public class ListHelperBean {
	
	/**
	 * @return SalesOrder Types
	 */
	public List<SelectItem> getSalesOrderTypes() {
		List<SelectItem> orderTypes = new ArrayList<SelectItem>();
		orderTypes.add(new SelectItem("SO", "Good - Item Order"));
		orderTypes.add(new SelectItem("SV", "Service"));
		return orderTypes;
	}
	
	
	/**
	 * @return SalesOrder Status Types
	 */
	public List<SelectItem> getSalesOrderStatus() {
		List<SelectItem> salesOrderStatuses = new ArrayList<SelectItem>();
		salesOrderStatuses.add(new SelectItem("A", "Added"));
		salesOrderStatuses.add(new SelectItem("C", "Cancel"));
		salesOrderStatuses.add(new SelectItem("S", "Ship"));
		salesOrderStatuses.add(new SelectItem("H", "Hold"));
		salesOrderStatuses.add(new SelectItem("Z", "Complete"));
		return salesOrderStatuses;
	}
	
	/**
	 * @return Currencies
	 */
	public List<SelectItem> getCurrencies() {
		List<SelectItem> currencies = new ArrayList<SelectItem>();
		currencies.add(new SelectItem("INR", "INR"));
		return currencies;
	}
	
	
	/**
	 * @return Payment Modes
	 */
	public List<SelectItem> getPaymentModes() {
		List<SelectItem> paymentModes = new ArrayList<SelectItem>();
		paymentModes.add(new SelectItem("CSH", "CSH"));
		paymentModes.add(new SelectItem("CHQ", "CHQ"));
		return paymentModes;
	}
	
	/**
	 * @return Perishable Types
	 */
	public List<SelectItem> getPerishableTypes() {
		List<SelectItem> perishableTypes = new ArrayList<SelectItem>();
		perishableTypes.add(new SelectItem(Boolean.TRUE, "Yes"));
		perishableTypes.add(new SelectItem(Boolean.FALSE, "No"));
		return perishableTypes;
	}
	
	/**
	 * @return ItemMasterType
	 */
	public List<SelectItem> getItemMasterTypes() {
		List<SelectItem> itemMasterTypes = new ArrayList<SelectItem>();
		itemMasterTypes.add(new SelectItem("Good", "Good"));
		itemMasterTypes.add(new SelectItem("Service", "Service"));
		return itemMasterTypes;
	}
	
	/**
	 * @return ItemMaster Status Types
	 */
	public List<SelectItem> getItemMasterStatus() {
		List<SelectItem> itemMasterStatusList = new ArrayList<SelectItem>();
		itemMasterStatusList.add(new SelectItem("ACTV", "ACTV"));
		itemMasterStatusList.add(new SelectItem("DISBLD", "DISBLD"));
		return itemMasterStatusList;
	}
	
	/**
	 * @return UOM Types
	 */
	public List<SelectItem> getUomTypes() {
		List<SelectItem> uomTypes = new ArrayList<SelectItem>();
		uomTypes.add(new SelectItem("EACH", "EACH"));
		return uomTypes;
	}

}
