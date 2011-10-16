/**
 * 
 */
package com.openappengine.web.mvc.itemmaster;

import com.openappengine.messages.itemmaster.CreateItemMasterRequest;
import com.openappengine.messages.itemmaster.ItemMaster;
import com.openappengine.web.mvc.BaseWebController;
import com.openappengine.web.service.ServiceNames;

/**
 * @author hrishi
 *
 */
public class ItemMasterController extends BaseWebController {
	
	private ItemMasterModel itemMaster;
	
	public String createItemMaster() {
		ItemMaster itemMasterReq = new ItemMaster();
		itemMasterReq.setCatCode01(itemMaster.getCatCode01());
		itemMasterReq.setCatCode02(itemMaster.getCatCode02());
		itemMasterReq.setCatCode03(itemMaster.getCatCode03());
		itemMasterReq.setCatCode04(itemMaster.getCatCode04());
		itemMasterReq.setCatCode05(itemMaster.getCatCode05());
		itemMasterReq.setCost(itemMaster.getCost());
		itemMasterReq.setCurCode(itemMaster.getCurCode());
		itemMasterReq.setDesc(itemMaster.getDesc());
		itemMasterReq.setItemId(itemMaster.getItemId());
		itemMasterReq.setName(itemMaster.getName());
		itemMasterReq.setPerishable(itemMaster.getPerishable());
		itemMasterReq.setPrice(itemMaster.getPrice());
		itemMasterReq.setShipCharge(itemMaster.getShipCharge());
		itemMasterReq.setStatus(itemMaster.getStatus());
		itemMasterReq.setType(itemMaster.getType());
		itemMasterReq.setUOM(itemMaster.getUom());
		itemMasterReq.setUser(itemMaster.getUser());
		itemMasterReq.setWeight(itemMaster.getWeight());
		
		CreateItemMasterRequest createItemMasterRequest = new CreateItemMasterRequest();
		createItemMasterRequest.setItemMaster(itemMasterReq);
		callServiceFacade(createItemMasterRequest, ServiceNames.SERVICE_CREATE_ITEM_MASTER);
		return null;
	}

	public ItemMasterModel getItemMaster() {
		return itemMaster;
	}

	public void setItemMaster(ItemMasterModel itemMaster) {
		this.itemMaster = itemMaster;
	}

}
