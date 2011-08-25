/**
 * 
 */
package com.ms.openapps.itemmaster;

import java.io.IOException;
import java.math.BigInteger;

import org.springframework.dao.DataAccessException;
import org.w3c.dom.Document;

import com.ms.openapps.entity.GenericEntityException;
import com.ms.openapps.entity.IGenericEntityDelegator;
import com.ms.openapps.model.ItItemMaster;
import com.ms.openapps.oxm.IOxmMapper;
import com.ms.openapps.oxm.OxmMapperContext;
import com.ms.openapps.oxm.OxmMappingException;
import com.ms.openapps.service.ServiceUtil;
import com.ms.openapps.service.context.DispatchContext;
import com.ms.openapps.servicedef.api.AbstractGenericServiceDef;
import com.ms.openapps.util.UtilXml;
import com.openappengine.itemmaster.types.CreateItemMasterRequest;
import com.openappengine.itemmaster.types.CreateItemMasterResponse;
import com.openappengine.itemmaster.types.ItemMaster;

/**
 * @author hrishi
 *
 */
public class CreateItemMasterService extends AbstractGenericServiceDef {
	

	/* (non-Javadoc)
	 * @see com.ms.openapps.servicedef.api.IServiceDef#performPreProcessing(com.ms.openapps.service.context.DispatchContext, org.w3c.dom.Document)
	 */
	public Document performPreProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		if (requestDoc != null) {
			return requestDoc;
		}
		return returnError(requestDoc, "Request Document cannot be null");
	}

	/* (non-Javadoc)
	 * @see com.ms.openapps.servicedef.api.IServiceDef#performProcessing(com.ms.openapps.service.context.DispatchContext, org.w3c.dom.Document)
	 */
	public Document performProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		Document salesOrderResponseDoc = UtilXml.makeEmptyXmlDocument("CreateItemMasterResponse");

		CreateItemMasterResponse createItemMasterResponse = new CreateItemMasterResponse();
		
		IGenericEntityDelegator genericEntityDelegator = dispatchContext
				.getGenericEntityDelegator();

		IOxmMapper oxmMapper = OxmMapperContext.getOxmMapper();
		CreateItemMasterRequest createItemMasterReq;
		try {
			createItemMasterReq = (CreateItemMasterRequest) oxmMapper.unmarshal(requestDoc);
		} catch (OxmMappingException e) {
			return ServiceUtil.returnError(requestDoc, "Unable to unmarshal the request Xml for CreateItemMasterRequest");
		}
		if(createItemMasterReq == null) {
			return ServiceUtil.returnError(requestDoc, "Unmarshalled request object either null or empty.");
		}
		
		ItemMaster itemMaster = createItemMasterReq.getItemMaster();
		
		ItItemMaster itItemMaster = new ItItemMaster();
		itItemMaster.setCat01(itemMaster.getCatCode01());
		itItemMaster.setCat02(itemMaster.getCatCode02());
		itItemMaster.setCat03(itemMaster.getCatCode03());
		itItemMaster.setCat04(itemMaster.getCatCode04());
		itItemMaster.setCat05(itemMaster.getCatCode05());
		itItemMaster.setCost(itemMaster.getCost());
		itItemMaster.setCurcode(itemMaster.getCurCode());
		itItemMaster.setDesc(itemMaster.getDesc());
		itItemMaster.setName(itemMaster.getName());
		itItemMaster.setPerishable(itemMaster.getPerishable());
		itItemMaster.setPrice(itemMaster.getPrice());
		itItemMaster.setShipCharges(itemMaster.getShipCharge());
		itItemMaster.setStatus(itemMaster.getStatus());
		itItemMaster.setType(itemMaster.getType());
		itItemMaster.setUom(itemMaster.getUOM());
		itItemMaster.setWeight(itemMaster.getWeight());
		
		try {
			itItemMaster = (ItItemMaster) genericEntityDelegator.createEntity(itItemMaster);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return ServiceUtil.returnError(salesOrderResponseDoc, "Unable to persist the entity for ItItemMaster");
		} catch (GenericEntityException e) {
			// TODO Auto-generated catch block
		}
		
		itemMaster.setItemId(new BigInteger(""+itItemMaster.getItemId()));
		createItemMasterResponse.setItemMaster(itemMaster);
		
		try {
			salesOrderResponseDoc = oxmMapper.marshalObject(createItemMasterResponse);
			System.out.println(UtilXml.writeXmlDocument(salesOrderResponseDoc));
		} catch (OxmMappingException e) {
			e.printStackTrace();
			return ServiceUtil.returnError(salesOrderResponseDoc, "Response object cannot be marshalled.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return salesOrderResponseDoc;
	}

	/* (non-Javadoc)
	 * @see com.ms.openapps.servicedef.api.IServiceDef#performPostProcessing(com.ms.openapps.service.context.DispatchContext, org.w3c.dom.Document)
	 */
	public Document performPostProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		if(requestDoc != null) {
			return returnSuccess(requestDoc, "Item Master Created.");
		} else {
			return returnError(requestDoc, "Marshalling Failed.");
		}
	}

}
