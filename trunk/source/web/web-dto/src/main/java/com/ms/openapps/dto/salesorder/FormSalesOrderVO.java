/**
 * 
 */
package com.ms.openapps.dto.salesorder;

import java.util.ArrayList;
import java.util.List;

import com.ms.openapps.dto.GenericDto;

/**
 * @author hrishi
 * 
 */
public class FormSalesOrderVO extends GenericDto {

	private static final long serialVersionUID = 1830659436693685735L;
	
	private List<ItemMasterVO> itemMasterVOs;
	
	private SalesOrderHdr salesOrderHdr = new SalesOrderHdr();

	private List<SalesOrderDet> salesOrderDets = new ArrayList<SalesOrderDet>();
	
	private SalesOrderDet newSalesOrderDet = new SalesOrderDet();
	
	public void addItemMasterVO(ItemMasterVO itemMasterVO) {
		if(itemMasterVO == null) {
			return;
		}
		
		if(itemMasterVOs == null) {
			itemMasterVOs = new ArrayList<ItemMasterVO>();
		}
		
		itemMasterVOs.add(itemMasterVO);
	}

	public List<ItemMasterVO> getItemMasterVOs() {
		return itemMasterVOs;
	}

	public void setItemMasterVOs(List<ItemMasterVO> itemMasterVOs) {
		this.itemMasterVOs = itemMasterVOs;
	}

	public SalesOrderHdr getSalesOrderHdr() {
		return salesOrderHdr;
	}

	public void setSalesOrderHdr(SalesOrderHdr salesOrderHdr) {
		this.salesOrderHdr = salesOrderHdr;
	}

	public List<SalesOrderDet> getSalesOrderDets() {
		return salesOrderDets;
	}

	public void setSalesOrderDets(List<SalesOrderDet> salesOrderDets) {
		this.salesOrderDets = salesOrderDets;
	}

	public SalesOrderDet getNewSalesOrderDet() {
		return newSalesOrderDet;
	}

	public void setNewSalesOrderDet(SalesOrderDet newSalesOrderDet) {
		this.newSalesOrderDet = newSalesOrderDet;
	}

}