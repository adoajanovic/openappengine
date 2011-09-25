/**
 * 
 */
package com.openappengine.servicedef.party;

import org.w3c.dom.Document;

import com.openappengine.domain.model.PmParty;
import com.openappengine.messages.party.CreatePartyRequest;
import com.openappengine.messages.party.CreatePartyResponse;
import com.openappengine.messages.party.Party;
import com.openappengine.oxm.IOxmMapper;
import com.openappengine.oxm.OxmMapperContext;
import com.openappengine.oxm.OxmMappingException;
import com.openappengine.serviceengine.ServiceUtil;
import com.openappengine.serviceengine.context.DispatchContext;
import com.openappengine.serviceengine.definition.GenericServiceDef;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 *
 */
public class CreatePartyService extends GenericServiceDef {

	/* (non-Javadoc)
	 * @see com.ms.openapps.servicedef.api.IServiceDef#performProcessing(com.ms.openapps.service.context.DispatchContext, org.w3c.dom.Document)
	 */
	public Document performProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		Document responseDoc = UtilXml.makeEmptyXmlDocument("CreatePartyResponse");
		CreatePartyResponse createPartyResponse = new CreatePartyResponse();
		
		IOxmMapper oxmMapper = OxmMapperContext.getOxmMapper();
		
		CreatePartyRequest createPartyRequest;
		
		try {
			createPartyRequest = (CreatePartyRequest) oxmMapper.unmarshal(requestDoc);
		} catch (OxmMappingException e) {
			return ServiceUtil.returnError(responseDoc, "Unable to unmarshal the request Xml for CreatePartyRequest Xml");
		}
		
		if(createPartyRequest == null) {
			return ServiceUtil.returnError(responseDoc, "Unmarshalled request object either null or empty.");
		}
		
		Party party = createPartyRequest.getParty();
		
		if(party == null) {
			return ServiceUtil.returnError(responseDoc, "Party object found null.");
		}
		
		PmParty pmParty = new PmParty();
		
		pmParty.setDescription(party.getDescription());
		pmParty.setExternalId(party.getExternalId());
		pmParty.setPartyType(party.getPartyType());
		pmParty.setPreferredCurrencyUom(party.getPreferredCurrencyUom());
		pmParty.setStatus(party.getStatus());
		
		pmParty = (PmParty) getGenericRepository().save(pmParty);
		
		party.setPartyId(pmParty.getPartyId());
		createPartyResponse.setParty(party);
		
		try {
			responseDoc = oxmMapper.marshalObject(createPartyResponse);
		} catch (OxmMappingException e) {
			e.printStackTrace();
			return ServiceUtil.returnError(responseDoc, "Response object cannot be marshalled.");
		}
		return responseDoc;
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
