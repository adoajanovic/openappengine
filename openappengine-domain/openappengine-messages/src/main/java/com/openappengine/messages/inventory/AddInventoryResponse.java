/**
 * 
 */
package com.openappengine.messages.inventory;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class AddInventoryResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private InventoryItem inventoryItem;

	public InventoryItem getInventoryItem() {
		return inventoryItem;
	}

	public void setInventoryItem(InventoryItem inventoryItem) {
		this.inventoryItem = inventoryItem;
	}

}
