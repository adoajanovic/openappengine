package com.openappengine.messages.itemmaster;

import com.openappengine.messages.api.MessagePayload;



public class CreateItemMasterResponse extends MessagePayload {

	private static final long serialVersionUID = 1L;
	
	protected ItemMaster itemMaster;

    public ItemMaster getItemMaster() {
        return itemMaster;
    }

    public void setItemMaster(ItemMaster value) {
        this.itemMaster = value;
    }

}
