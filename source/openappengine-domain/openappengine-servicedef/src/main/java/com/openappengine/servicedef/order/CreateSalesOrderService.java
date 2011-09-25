/**
 * 
 */
package com.openappengine.servicedef.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.w3c.dom.Document;

import com.openappengine.domain.model.SoSalesDet;
import com.openappengine.domain.model.SoSalesHdr;
import com.openappengine.messages.salesorder.CreateSalesOrderRequest;
import com.openappengine.messages.salesorder.SalesDet;
import com.openappengine.messages.salesorder.SalesHdr;
import com.openappengine.oxm.IOxmMapper;
import com.openappengine.oxm.OxmMapperContext;
import com.openappengine.oxm.OxmMappingException;
import com.openappengine.oxm.converter.UtilXMLGregorianCalendar;
import com.openappengine.serviceengine.ServiceUtil;
import com.openappengine.serviceengine.context.DispatchContext;
import com.openappengine.serviceengine.definition.GenericServiceDef;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 * 
 */
public class CreateSalesOrderService extends GenericServiceDef {

	/**
	 * Create a Sales Order.
	 * 
	 * @param salesOrderRequestDoc
	 * @return Document - SalesOrderResult
	 */
	public Document createSalesOrder(DispatchContext dispatchContext,
			Document salesOrderRequestDoc) {

		Document salesOrderResponseDoc = UtilXml.makeEmptyXmlDocument("CreateSalesOrderResponse");

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
			salesHdrEntity = mapToSalesHdrEntity(dispatchContext,salesHdr);
		} catch (Exception e1) {
			e1.printStackTrace();
			return ServiceUtil.returnError(salesOrderResponseDoc, "Unable to create SalesHdr / SalesDet entity");
		}

		salesHdrEntity = (SoSalesHdr) getGenericRepository().save(salesHdrEntity);
		
		try {
			salesOrderResponseDoc = oxmMapper.marshalObject(salesHdrEntity);
		} catch (OxmMappingException e) {
			return ServiceUtil.returnError(salesOrderResponseDoc, "Response object cannot be marshalled.");
		}
		
		return salesOrderResponseDoc;
	}

	/**
	 * @param salesHdr
	 */
	private SoSalesHdr mapToSalesHdrEntity(DispatchContext dispatchContext, SalesHdr salesHdr) throws Exception {
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