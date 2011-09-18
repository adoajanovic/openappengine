/**
 * 
 */
package com.openappengine.servicedef.contract;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import com.ms.openapps.util.UtilXml;
import com.openappengine.domain.model.CnContractDet;
import com.openappengine.domain.model.CnContractHdr;
import com.openappengine.domain.model.PmParty;
import com.openappengine.messages.contract.ContractDet;
import com.openappengine.messages.contract.ContractHdr;
import com.openappengine.messages.contract.CreateContractRequest;
import com.openappengine.messages.contract.CreateContractResponse;
import com.openappengine.oxm.IOxmMapper;
import com.openappengine.oxm.OxmMapperContext;
import com.openappengine.oxm.OxmMappingException;
import com.openappengine.oxm.converter.UtilXMLGregorianCalendar;
import com.openappengine.serviceengine.ServiceUtil;
import com.openappengine.serviceengine.context.DispatchContext;
import com.openappengine.serviceengine.definition.GenericServiceDef;

/**
 * @author hrishi
 *
 */
public class CreateContractService extends GenericServiceDef {

	/* (non-Javadoc)
	 * @see com.ms.openapps.servicedef.api.IServiceDef#performProcessing(com.ms.openapps.service.context.DispatchContext, org.w3c.dom.Document)
	 */
	public Document performProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		Document createContractResponseDoc = UtilXml.makeEmptyXmlDocument("CreateContractResponse");

		CreateContractResponse contractResponse = new CreateContractResponse();
		
		IOxmMapper oxmMapper = OxmMapperContext.getOxmMapper();
		
		CreateContractRequest createContractRequest;
		
		try {
			createContractRequest = (CreateContractRequest) oxmMapper.unmarshal(requestDoc);
		} catch (OxmMappingException e) {
			return ServiceUtil.returnError(requestDoc, "Unable to unmarshal the request Xml for CreateContractRequest Xml");
		}
		if(createContractRequest == null) {
			return ServiceUtil.returnError(requestDoc, "Unmarshalled request object either null or empty.");
		}
		
		ContractHdr contractHdr = createContractRequest.getContractHdr();
		if(contractHdr == null) {
			return ServiceUtil.returnError(requestDoc, "Unmarshalled request object either null or empty.");
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("partyId", contractHdr.getPartyId());
		List list = new ArrayList();//genericEntityDelegator.findByNamedParams("from PmParty where partyId = :partyId", params );
		PmParty pmParty = null;
		if(list != null && !list.isEmpty()) {
			pmParty = (PmParty) list.get(0);
		}
		if(pmParty == null) {
			return ServiceUtil.returnError(requestDoc, "Party Id cannot be null.");
		}
		
		CnContractHdr cnContractHdr = new CnContractHdr();
		cnContractHdr.setCanDate(UtilXMLGregorianCalendar.asDate(contractHdr.getCanDate()));
		cnContractHdr.setCnEndDate(UtilXMLGregorianCalendar.asDate(contractHdr.getCnEndDate()));
		cnContractHdr.setCnStartDate(UtilXMLGregorianCalendar.asDate(contractHdr.getCnStartDate()));
		cnContractHdr.setPmParty(pmParty);
		ArrayList<CnContractDet> cnContractDets = new ArrayList<CnContractDet>();
		
		if(contractHdr.getContractDets() != null && !contractHdr.getContractDets().isEmpty()) {
			List<ContractDet> contractDets = contractHdr.getContractDets();
			for (ContractDet contractDet : contractDets) {
				CnContractDet cnContractDet = new CnContractDet();
				cnContractDet.setCnContractHdr(cnContractHdr);
				cnContractDet.setCnCost(contractDet.getCnCost());
				cnContractDet.setCnDiscount(contractDet.getCnDiscount());
				cnContractDet.setCnPrice(contractDet.getCnPrice());
				cnContractDet.setCnItemId(contractDet.getCnItemId());
				cnContractDet.setCnLocation(contractDet.getCnLocation());
				cnContractDet.setCnLotNo(contractDet.getCnLotNo());
				cnContractDet.setCnOrdType(contractDet.getCnOrdType());
				cnContractDet.setCnUom(contractDet.getCnUom());
				cnContractDet.setCnQtyOrd(contractDet.getCnQtyOrd());
				cnContractDet.setCnWeight(contractDet.getCnWeight());
				cnContractDets.add(cnContractDet);
			}
			
			cnContractHdr.setCnContractDets(cnContractDets);
		}
		
		/*try {
			cnContractHdr = (CnContractHdr) genericEntityDelegator.createEntity(cnContractHdr);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return ServiceUtil.returnError(createContractResponseDoc, "Unable to persist the entity for InInventoryMaster");
		} catch (GenericEntityException e) {
			// TODO Auto-generated catch block
		}*/
		
		contractHdr.setCnContractId(cnContractHdr.getCnContractId());
		contractResponse.setContractHdr(contractHdr);
		
		try {
			createContractResponseDoc = oxmMapper.marshalObject(contractResponse);
			System.out.println(UtilXml.writeXmlDocument(createContractResponseDoc));
		} catch (OxmMappingException e) {
			e.printStackTrace();
			return ServiceUtil.returnError(createContractResponseDoc, "Response object cannot be marshalled.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return createContractResponseDoc;
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
