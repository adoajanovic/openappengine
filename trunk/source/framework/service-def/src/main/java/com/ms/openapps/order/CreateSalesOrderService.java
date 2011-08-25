/**
 * 
 */
package com.ms.openapps.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.dao.DataAccessException;
import org.w3c.dom.Document;

import com.ms.openapps.entity.GenericEntityException;
import com.ms.openapps.entity.IGenericEntityDelegator;
import com.ms.openapps.model.SoSalesDet;
import com.ms.openapps.model.SoSalesHdr;
import com.ms.openapps.oxm.IOxmMapper;
import com.ms.openapps.oxm.OxmMapperContext;
import com.ms.openapps.oxm.OxmMappingException;
import com.ms.openapps.oxm.converter.UtilXMLGregorianCalendar;
import com.ms.openapps.service.ServiceUtil;
import com.ms.openapps.service.context.DispatchContext;
import com.ms.openapps.servicedef.api.AbstractGenericServiceDef;
import com.ms.openapps.util.UtilXml;
import com.openappengine.salesorder.types.CreateSalesOrderRequest;
import com.openappengine.salesorder.types.SalesDet;
import com.openappengine.salesorder.types.SalesHdr;

/**
 * @author hrishi
 * 
 */
public class CreateSalesOrderService extends AbstractGenericServiceDef {

	/**
	 * Create a Sales Order.
	 * 
	 * @param salesOrderRequestDoc
	 * @return Document - SalesOrderResult
	 */
	public Document createSalesOrder(DispatchContext dispatchContext,
			Document salesOrderRequestDoc) {

		Document salesOrderResponseDoc = UtilXml.makeEmptyXmlDocument("CreateSalesOrderResponse");

		IGenericEntityDelegator genericEntityDelegator = dispatchContext
				.getGenericEntityDelegator();

		IOxmMapper oxmMapper = OxmMapperContext.getOxmMapper();
		CreateSalesOrderRequest createSalesOrderRequest = null;
		try {
			createSalesOrderRequest = (CreateSalesOrderRequest) oxmMapper
					.unmarshal(salesOrderRequestDoc);
		} catch (OxmMappingException e) {
			e.printStackTrace();
			return ServiceUtil.returnError(salesOrderResponseDoc, "Unable to unmarshal the request Xml for CreateSalesOrderRequest");
		}

		if (createSalesOrderRequest == null) {
			return ServiceUtil.returnError(salesOrderResponseDoc, "Unmarshalled request object from CreateSalesOrderRequest Xml either not found or null.");
		}

		SalesHdr salesHdr = createSalesOrderRequest.getSalesHdr();

		SoSalesHdr salesHdrEntity = null;
		try {
			salesHdrEntity = mapToSalesHdrEntity(dispatchContext, genericEntityDelegator,salesHdr);
		} catch (Exception e1) {
			e1.printStackTrace();
			return ServiceUtil.returnError(salesOrderResponseDoc, "Unable to create SalesHdr / SalesDet entity");
		}

		try {
			
			salesHdrEntity = (SoSalesHdr) genericEntityDelegator
					.createEntity(salesHdrEntity);
		} catch (DataAccessException e) {
			return ServiceUtil.returnError(salesOrderResponseDoc, "Unable to persist the entity for SalesHdr");
		} catch (GenericEntityException e) {
			// TODO Auto-generated catch block
		}
		try {
			salesOrderResponseDoc = oxmMapper.marshalObject(salesHdrEntity);
		} catch (OxmMappingException e) {
			return ServiceUtil.returnError(salesOrderResponseDoc, "Response object cannot be marshalled.");
		}
		
		return salesOrderResponseDoc;
	}

	/**
	 * @param genericEntityDelegator 
	 * @param salesHdr
	 */
	private SoSalesHdr mapToSalesHdrEntity(DispatchContext dispatchContext,IGenericEntityDelegator genericEntityDelegator, SalesHdr salesHdr) throws Exception {
		SoSalesHdr soSalesHdr = new SoSalesHdr();
		XMLGregorianCalendar canDateXGC = salesHdr.getCanDate();
		Date canDate = UtilXMLGregorianCalendar.asDate(canDateXGC);
		soSalesHdr.setCanDate(canDate);
		soSalesHdr.setCarrier(salesHdr.getCarrier());
		soSalesHdr.setCurCode(salesHdr.getCurCode());
		soSalesHdr.setModePay(salesHdr.getModePay());
		XMLGregorianCalendar ordDateXGC = salesHdr.getOrdDate();
		Date ordDate = UtilXMLGregorianCalendar.asDate(ordDateXGC);
		soSalesHdr.setOrdDate(ordDate);
		soSalesHdr.setOrdtype(salesHdr.getOrdType());
		soSalesHdr.setStatus(salesHdr.getStatus());
		soSalesHdr.setTotAmt(salesHdr.getTotAmt());
		soSalesHdr.setTotQty(salesHdr.getTotQty());
		soSalesHdr.setTotTax(salesHdr.getTotTax());
		soSalesHdr.setTotWeight(salesHdr.getTotWeight());
		soSalesHdr.setPartyId(salesHdr.getPartyId().intValue());
		
		List<SalesDet> salesDetList = salesHdr.getSalesDet();

		ArrayList<SoSalesDet> soSalesDets = new ArrayList<SoSalesDet>();
		
		if (salesDetList != null && !salesDetList.isEmpty()) {
			int lineNo = 1;
			for (SalesDet salesDet : salesDetList) {
				SoSalesDet soSalesDet = new SoSalesDet();
				soSalesDet.setCost(salesDet.getCost());
				soSalesDet.setDiscount(salesDet.getDiscount());
				soSalesDet.setLineNo(lineNo++);
				soSalesDet.setOrdType(salesDet.getOrdType());
				soSalesDet.setPrice(salesDet.getPrice());
				soSalesDet.setQtyOrd(salesDet.getQtyOrd());
				soSalesDet.setUom(salesDet.getUOM());
				soSalesDet.setWeight(salesDet.getWeight());
				soSalesDet.setItemMasterId(salesDet.getItemId().intValue());
				soSalesDet.setSoSalesHdr(soSalesHdr);
				soSalesDets.add(soSalesDet);
			}
		}
		
		soSalesHdr.setSoSalesDets(soSalesDets);

		return soSalesHdr;
	}

	public Document performPreProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		if(requestDoc != null) {
			return requestDoc;
		}
		return returnError(requestDoc, "Request Document cannot be null");
	}

	public Document performProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		Document responseDoc = createSalesOrder(dispatchContext,requestDoc);
		return responseDoc;
	}

	public Document performPostProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		return ServiceUtil.returnSuccess(requestDoc, "Sales Order generated");
	}

}