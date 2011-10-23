/**
 * 
 */
package com.openappengine.web.mvc.itemmaster;

import com.openappengine.web.mvc.BaseWebController;

/**
 * @author hrishi
 *
 */
public class ItemMasterController extends BaseWebController {
	
	private ItemMasterModel itemMaster;
	
	public String createItemMaster() {
		return null;
	}

	public ItemMasterModel getItemMaster() {
		return itemMaster;
	}

	public void setItemMaster(ItemMasterModel itemMaster) {
		this.itemMaster = itemMaster;
	}

}
