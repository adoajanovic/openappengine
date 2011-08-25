/**
 * 
 */
package com.openappengine.party.ws;

import java.util.logging.Logger;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.openappengine.party.types.CreatePartyRequest;
import com.openappengine.party.types.CreatePartyResponse;
import com.openappengine.party.types.ObjectFactory;
import com.openappengine.party.types.PartyType;

/**
 * @author hrishi
 *
 */
@Endpoint
public class PartyMgrEndpoint {

	private static final String NAMESPACE_URI = "http://openappengine.com/party/types";

	private Logger logger = Logger.getLogger(PartyMgrEndpoint.class.getName());

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreatePartyRequest")
	@ResponsePayload
	public CreatePartyResponse createParty(
			@RequestPayload CreatePartyRequest request) {
		PartyType party = request.getParty();
		logger.info("Party Name : " + party.getPartyName());
		party.setPartyName("Approved");
		CreatePartyResponse createPartyResponse = new ObjectFactory()
				.createCreatePartyResponse();
		createPartyResponse.setParty(party);
		return createPartyResponse;
	}

}
