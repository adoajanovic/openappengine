/**
 * 
 */
package com.ms.openapps.web.controller.itemmaster;

import java.util.logging.Logger;

import org.w3c.dom.Document;

import com.ms.openapps.dto.itemmaster.FormItemMasterVO;
import com.ms.openapps.dto.itemmaster.ItemMasterVO;
import com.ms.openapps.mapper.FormItemMasterMapper;
import com.ms.openapps.oxm.IOxmMapper;
import com.ms.openapps.oxm.OxmMapperContext;
import com.ms.openapps.oxm.OxmMappingException;
import com.ms.openapps.service.constants.ServiceNames;
import com.ms.openapps.service.facade.ServiceFacade;
import com.ms.openapps.web.controller.GenericFormController;
import com.openappengine.itemmaster.types.CreateItemMasterRequest;
import com.openappengine.itemmaster.types.ItemMaster;

/**
 * @author hrishi
 *
 */
public class ItemMasterController extends GenericFormController {

	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private FormItemMasterVO formItemMasterVO = new FormItemMasterVO();
	
	public ItemMasterController() {
		logger.info("ItemMasterController initialized");

		FormItemMasterMapper mapper = new FormItemMasterMapper();
		formItemMasterVO = mapper.mapScreen();
	}
	
	public String createItemMaster() {
		ItemMaster itemMaster = new ItemMaster();
		ItemMasterVO itemMasterVO = formItemMasterVO.getItemMasterVO();
		itemMaster.setCatCode01(itemMasterVO.getCatCode01());
		itemMaster.setCatCode02(itemMasterVO.getCatCode02());
		itemMaster.setCatCode03(itemMasterVO.getCatCode03());
		itemMaster.setCatCode04(itemMasterVO.getCatCode04());
		itemMaster.setCatCode05(itemMasterVO.getCatCode05());
		itemMaster.setCost(itemMasterVO.getCost());
		itemMaster.setCurCode(itemMasterVO.getCurCode());
		itemMaster.setDesc(itemMasterVO.getDesc());
		itemMaster.setItemId(itemMasterVO.getItemId());
		itemMaster.setName(itemMasterVO.getName());
		itemMaster.setPerishable(itemMasterVO.getPerishable());
		itemMaster.setPrice(itemMasterVO.getPrice());
		itemMaster.setShipCharge(itemMasterVO.getShipCharge());
		itemMaster.setStatus(itemMasterVO.getStatus());
		itemMaster.setType(itemMasterVO.getType());
		itemMaster.setUOM(itemMasterVO.getUom());
		itemMaster.setUser(itemMasterVO.getUser());
		itemMaster.setWeight(itemMasterVO.getWeight());
		
		CreateItemMasterRequest createItemMasterRequest = new CreateItemMasterRequest();
		createItemMasterRequest.setItemMaster(itemMaster);
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

	public FormItemMasterVO getFormItemMasterVO() {
		return formItemMasterVO;
	}

	public void setFormItemMasterVO(FormItemMasterVO formItemMasterVO) {
		this.formItemMasterVO = formItemMasterVO;
	}
	
	

}
