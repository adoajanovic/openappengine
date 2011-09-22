/**
 * 
 */
package com.openappengine.servicedef.party;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import com.ms.openapps.util.UtilXml;
import com.openappengine.domain.model.PmParty;
import com.openappengine.domain.model.PmPartyContactMech;
import com.openappengine.messages.party.AddPartyContactMechRequest;
import com.openappengine.messages.party.AddPartyContactMechResponse;
import com.openappengine.messages.party.PartyContactMech;
import com.openappengine.oxm.IOxmMapper;
import com.openappengine.oxm.OxmMapperContext;
import com.openappengine.oxm.OxmMappingException;
import com.openappengine.repository.GenericRepository;
import com.openappengine.repository.context.EntityContext;
import com.openappengine.repository.model.GenericEntity;
import com.openappengine.serviceengine.context.DispatchContext;
import com.openappengine.serviceengine.definition.GenericServiceDef;

/**
 * @author hrishikesh.joshi
 *
 */
public class AddPartyContactMechService extends GenericServiceDef {

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

	@Override
	public Document performProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		Document responseDoc = UtilXml.makeEmptyXmlDocument("AddPartyContactMechResponse");
		IOxmMapper oxmMapper = OxmMapperContext.getOxmMapper();
		try {
			AddPartyContactMechRequest requestObj = (AddPartyContactMechRequest) oxmMapper.unmarshal(requestDoc);
			Long partyId = requestObj.getPartyId();
			EntityContext instance = EntityContext.getInstance();
			GenericRepository genericRepository = instance.getGenericRepository();
			List<GenericEntity> partyList = genericRepository.findByNamedParam("from PmParty where partyId = :partyId", "partyId", partyId);
			if(partyList != null && !partyList.isEmpty()) {
				AddPartyContactMechResponse addPartyContactMechResponse = new AddPartyContactMechResponse();
				PmParty party = (PmParty) partyList.get(0);
				List<PmPartyContactMech> pmPartyContactMeches = new ArrayList<PmPartyContactMech>();
				List<PartyContactMech> partyContactMeches = requestObj.getPartyContactMeches();
				if(partyContactMeches != null && !partyContactMeches.isEmpty()) {
					for (PartyContactMech partyContactMech : partyContactMeches) {
						PmPartyContactMech contactMech = new PmPartyContactMech(); 
						contactMech.setCmContactMechPurpose(partyContactMech.getContactMechPurpose());
						contactMech.setCmContactMechType(partyContactMech.getContactMechType());
						contactMech.setCmInfoString(partyContactMech.getInfoString());
						contactMech.setPmParty(party);
						pmPartyContactMeches.add(contactMech);
					}
					if(!pmPartyContactMeches.isEmpty()) {
						party.getPmPartyContactMeches().addAll(pmPartyContactMeches);
						genericRepository.save(party);
						
						Document marshalObject = oxmMapper.marshalObject(addPartyContactMechResponse);
						return returnSuccess(marshalObject, "PartyContactMech added to Party [ Party Id : " + partyId + " ]");
					}
				}
			} else {
				return returnError(responseDoc, "Party not found for PartyId: " + partyId + ".");
			}
			
		} catch (OxmMappingException e) {
			return returnError(responseDoc, "Unmarshalling encountered when executing Service : " + getClass().getName());
		}
		return responseDoc;
	}

}
