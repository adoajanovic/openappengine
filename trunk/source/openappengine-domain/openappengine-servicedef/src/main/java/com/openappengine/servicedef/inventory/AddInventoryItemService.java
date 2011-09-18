/**
 * 
 */
package com.openappengine.servicedef.inventory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import com.ms.openapps.util.UtilXml;
import com.openappengine.domain.model.InInventoryMaster;
import com.openappengine.messages.inventory.AddInventoryRequest;
import com.openappengine.messages.inventory.AddInventoryResponse;
import com.openappengine.messages.inventory.InventoryItem;
import com.openappengine.oxm.IOxmMapper;
import com.openappengine.oxm.OxmMapperContext;
import com.openappengine.oxm.OxmMappingException;
import com.openappengine.oxm.converter.UtilXMLGregorianCalendar;
import com.openappengine.repository.model.GenericEntity;
import com.openappengine.serviceengine.ServiceUtil;
import com.openappengine.serviceengine.context.DispatchContext;
import com.openappengine.serviceengine.definition.GenericServiceDef;

/**
 * @author hrishi
 *
 */
public class AddInventoryItemService extends GenericServiceDef {

	/* (non-Javadoc)
	 * @see com.ms.openapps.servicedef.api.IServiceDef#performProcessing(com.ms.openapps.service.context.DispatchContext, org.w3c.dom.Document)
	 */
	public Document performProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		Document addInventoryResponseDoc = UtilXml.makeEmptyXmlDocument("AddInventoryResponse");

		AddInventoryResponse addInventoryResponse = new AddInventoryResponse();
		
		IOxmMapper oxmMapper = OxmMapperContext.getOxmMapper();
		
		AddInventoryRequest addInventoryRequest;
		
		try {
			addInventoryRequest = (AddInventoryRequest) oxmMapper.unmarshal(requestDoc);
		} catch (OxmMappingException e) {
			return ServiceUtil.returnError(requestDoc, "Unable to unmarshal the request Xml for AddInventoryRequest Xml");
		}
		if(addInventoryRequest == null) {
			return ServiceUtil.returnError(requestDoc, "Unmarshalled request object either null or empty.");
		}
		
		InventoryItem inventory = addInventoryRequest.getInventoryItem();
		if(inventory == null) {
			return ServiceUtil.returnError(requestDoc, "Unmarshalled request object either null or empty.");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("itemId", inventory.getItemId());
		List<GenericEntity> items = getGenericRepository().findByNamedParam("from ItItemMaster where itemId = :itemId", "itemId", inventory.getItemId());
		if(items == null || items.isEmpty()) {
			return ServiceUtil.returnError(requestDoc, "Item Not present in ItemMaster.");
		}
		
		InInventoryMaster inInventoryMaster = new InInventoryMaster();
		Date lrDate = UtilXMLGregorianCalendar.asDate(inventory.getDateLr());
		inInventoryMaster.setImDateLr(lrDate);
		inInventoryMaster.setImItemId(inventory.getItemId());
		inInventoryMaster.setImLocation(inventory.getLocation());
		inInventoryMaster.setImLotNo(inventory.getLotNo());
		inInventoryMaster.setImQtyAv(inventory.getQtyAv());
		inInventoryMaster.setImQtyCm(inventory.getQtyCm());
		inInventoryMaster.setImQtyPo(inventory.getQtyPo());
		inInventoryMaster.setImStatus(inventory.getStatus());
		inInventoryMaster.setImUom(inventory.getUom());
		
		inInventoryMaster = (InInventoryMaster) getGenericRepository().save(inInventoryMaster);
		
		inventory.setInventoryMasterId(inInventoryMaster.getImInventoryMasterId());
		addInventoryResponse.setInventoryItem(inventory);
		
		try {
			addInventoryResponseDoc = oxmMapper.marshalObject(addInventoryResponse);
			System.out.println(UtilXml.writeXmlDocument(addInventoryResponseDoc));
		} catch (OxmMappingException e) {
			e.printStackTrace();
			return ServiceUtil.returnError(addInventoryResponseDoc, "Response object cannot be marshalled.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return addInventoryResponseDoc;
	}

	@Override
	public Document performPreProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		return super.performPreProcessing(dispatchContext, requestDoc);
	}

	@Override
	public Document performPostProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		return super.performPostProcessing(dispatchContext, requestDoc);
	}

}
