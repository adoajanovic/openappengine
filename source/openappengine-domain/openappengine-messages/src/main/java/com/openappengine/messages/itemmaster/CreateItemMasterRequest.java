package com.openappengine.messages.itemmaster;

import java.io.Serializable;


public class CreateItemMasterRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
    protected ItemMaster itemMaster;

    public ItemMaster getItemMaster() {
        return itemMaster;
    }

    public void setItemMaster(ItemMaster value) {
        this.itemMaster = value;
    }

}
