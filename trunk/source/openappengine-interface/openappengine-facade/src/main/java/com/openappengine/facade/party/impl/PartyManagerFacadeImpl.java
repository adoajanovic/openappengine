/**
 * 
 */
package com.openappengine.facade.party.impl;

import java.util.List;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.openappengine.facade.code.dto.CodeDTO;
import com.openappengine.facade.code.dto.CodesDTOAssembler;
import com.openappengine.facade.party.PartyManagerFacade;
import com.openappengine.facade.party.dto.PartyContactMechCommand;
import com.openappengine.facade.party.dto.ContactMechDTOAssembler;
import com.openappengine.facade.party.dto.PartyCommand;
import com.openappengine.facade.party.dto.PartyCommandValidator;
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
	 * @see com.openappengine.facade.party.PartyManagerFacade#createParty(com.openappengine.facade.party.dto.PartyCommand)
	 */
	public String createParty(PartyCommand partyCommand) {
		PartyCommandValidator validator = new PartyCommandValidator();
		Errors errors = new BeanPropertyBindingResult(partyCommand, "partyCommand");
		validator.validate(partyCommand,errors);
		
		if(!errors.hasErrors()) {
			Party party = partyManagerService.createNewParty(partyCommand.getDescription(),
					partyCommand.getPartyType(), partyCommand.getPreferredCurrencyUom());
			if(party != null) {
				return party.getExternalId();
			}
		} 
		
		return "" + PartyCommand.PARTY_VALIDATION_ERROR;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.facade.party.PartyManagerFacade#assignContactMechToParty(java.lang.String, com.openappengine.facade.party.dto.PartyContactMechCommand)
	 */
	public void assignContactMechToParty(String partyExternalId,
			PartyContactMechCommand partyContactMechCommand) {
		PartyContactMech partyContactMech = new ContactMechDTOAssembler().fromDTO(partyContactMechCommand);
		partyManagerService.assignContactMechToParty(partyExternalId,partyContactMech);
	}

	public void setPartyManagerService(IPartyManagerService partyManagerService) {
		this.partyManagerService = partyManagerService;
	}
	
}
