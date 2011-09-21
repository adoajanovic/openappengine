/**
 * 
 */
package com.openappengine.web.mvc.itemmaster;

import org.w3c.dom.Document;

import com.openappengine.messages.itemmaster.CreateItemMasterRequest;
import com.openappengine.messages.itemmaster.ItemMaster;
import com.openappengine.oxm.IOxmMapper;
import com.openappengine.oxm.OxmMapperContext;
import com.openappengine.oxm.OxmMappingException;
import com.openappengine.servicedef.ServiceNames;
import com.openappengine.serviceengine.facade.ServiceFacade;

/**
 * @author hrishi
 *
 */
public class ItemMasterController {
	
	private ItemMasterModel itemMaster;
	
	/**
	 * 
	 */
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
		IOxmMapper oxmMapper = OxmMapperContext.getOxmMapper();
		try {
			Document createItemMasterMarshalledObject = oxmMapper.marshalObject(createItemMasterRequest);
			Document result = ServiceFacade.callXmlService(
					ServiceNames.SERVICE_CREATE_ITEM_MASTER, createItemMasterMarshalledObject);
			
		} catch (OxmMappingException e) {
			e.printStackTrace();
			//addErrorMessage("Action Failed : Create Sales Order.");
		}
		return null;
	}

	public ItemMasterModel getItemMaster() {
		return itemMaster;
	}

	public void setItemMaster(ItemMasterModel itemMaster) {
		this.itemMaster = itemMaster;
	}

}
