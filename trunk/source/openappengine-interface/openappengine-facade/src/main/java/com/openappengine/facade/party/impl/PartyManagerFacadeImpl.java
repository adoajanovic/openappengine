/**
 * 
 */
package com.openappengine.facade.party.impl;

import java.util.List;

import com.openappengine.facade.code.dto.CodeDTO;
import com.openappengine.facade.code.dto.CodesDTOAssembler;
import com.openappengine.facade.party.PartyManagerFacade;
import com.openappengine.facade.party.dto.ContactMechDTO;
import com.openappengine.facade.party.dto.ContactMechDTOAssembler;
import com.openappengine.facade.party.dto.PartyDTO;
import com.openappengine.model.code.Code;
import com.openappengine.model.party.Party;
import com.openappengine.model.party.PartyContactMech;
import com.openappengine.repository.CodeRepository;
import com.openappengine.service.IPartyManagerService;

/**
 * @author hrishi
 *
 */
public class PartyManagerFacadeImpl implements PartyManagerFacade {
	
	private IPartyManagerService partyManagerService; 

	private CodeRepository codeRepository;
	
	public PartyManagerFacadeImpl() {
	}
	
	/* (non-Javadoc)
	 * @see com.openappengine.facade.party.PartyManagerFacade#listAllCodes(java.lang.String)
	 */
	public List<CodeDTO> listAllCodes(String codeType) {
		List<Code> codes = codeRepository.getCodesByCodeType(codeType);
		return new CodesDTOAssembler().toDTOList(codes);
	}

	public void setCodeRepository(CodeRepository codeRepository) {
		this.codeRepository = codeRepository;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.facade.party.PartyManagerFacade#createParty(com.openappengine.facade.party.dto.PartyDTO)
	 */
	public String createParty(PartyDTO partyDTO) {
		Party party = partyManagerService.createParty(partyDTO.getDescription(),
				partyDTO.getPartyType(), partyDTO.getPreferredCurrencyUom());
		if(party != null) {
			return party.getExternalId();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.facade.party.PartyManagerFacade#assignContactMechToParty(java.lang.String, com.openappengine.facade.party.dto.ContactMechDTO)
	 */
	public void assignContactMechToParty(String partyExternalId,
			ContactMechDTO contactMechDTO) {
		PartyContactMech partyContactMech = new ContactMechDTOAssembler().fromDTO(contactMechDTO);
		partyManagerService.assignContactMechToParty(partyExternalId,partyContactMech);
	}

	public void setPartyManagerService(IPartyManagerService partyManagerService) {
		this.partyManagerService = partyManagerService;
	}
	
}
