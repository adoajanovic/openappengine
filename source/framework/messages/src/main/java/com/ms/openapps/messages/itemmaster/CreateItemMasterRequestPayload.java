/**
 * 
 */
package com.ms.openapps.messages.itemmaster;

import com.ms.openapps.messages.RequestPayload;

/**
 * @author hrishi
 *
 */
public class CreateItemMasterRequestPayload extends RequestPayload {

	private static final long serialVersionUID = 1027921483927356816L;
	
	private int itemId;
	
	private String itemName;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
