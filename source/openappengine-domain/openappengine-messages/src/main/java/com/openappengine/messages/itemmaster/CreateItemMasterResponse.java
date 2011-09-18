package com.openappengine.messages.itemmaster;

import java.io.Serializable;



public class CreateItemMasterResponse implements Serializable {

	private static final long serialVersionUID = 1065486841900335277L;
	
	protected ItemMaster itemMaster;

    public ItemMaster getItemMaster() {
        return itemMaster;
    }

    public void setItemMaster(ItemMaster value) {
        this.itemMaster = value;
    }

}
