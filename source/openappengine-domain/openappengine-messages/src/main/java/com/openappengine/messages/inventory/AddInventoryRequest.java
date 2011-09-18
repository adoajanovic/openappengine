/**
 * 
 */
package com.openappengine.messages.inventory;


/**
 * @author hrishi
 *
 */
public class AddInventoryRequest {

	private static final long serialVersionUID = 1L;
	
	private InventoryItem inventoryItem;

	public InventoryItem getInventoryItem() {
		return inventoryItem;
	}

	public void setInventoryItem(InventoryItem inventoryItem) {
		this.inventoryItem = inventoryItem;
	}

}
