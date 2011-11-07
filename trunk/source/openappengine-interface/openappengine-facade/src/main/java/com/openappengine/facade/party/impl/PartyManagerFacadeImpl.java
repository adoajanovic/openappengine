/**
 * 
 */
package com.openappengine.facade.party.impl;

import java.util.List;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.openappengine.facade.code.dto.CodeDTO;
import com.openappengine.facade.code.dto.CodesDTOAssembler;
import com.openappengine.facade.party.PartyManagerFacade;
import com.openappengine.facade.party.dto.AddressCommand;
import com.openappengine.facade.party.dto.AddressCommandValidator;
import com.openappengine.facade.party.dto.AddressDTOAssembler;
import com.openappengine.facade.party.dto.ContactMechDTOAssembler;
import com.openappengine.facade.party.dto.PartyCommand;
import com.openappengine.facade.party.dto.PartyCommandValidator;
import com.openappengine.facade.party.dto.PartyContactMechCommand;
import com.openappengine.facade.party.dto.PartyContactMechValidator;
import com.openappengine.model.addressbook.Address;
import com.openappengine.model.code.Code;
import com.openappengine.model.party.Party;
import com.openappengine.model.party.PartyContactMech;
import com.openappengine.model.party.PartySpecification;
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
	
	public List<CodeDTO> listAllCodes(String codeType) {
		List<Code> codes = codeRepository.getCodesByCodeType(codeType);
		return new CodesDTOAssembler().toDTOList(codes);
	}

	public void setCodeRepository(CodeRepository codeRepository) {
		this.codeRepository = codeRepository;
	}

	public String createParty(PartyCommand partyCommand) {
		PartyCommandValidator validator = new PartyCommandValidator();
		Errors errors = new BeanPropertyBindingResult(partyCommand, "partyCommand");
		validator.validate(partyCommand,errors);
		
		if(!errors.hasErrors()) {
			PartySpecification partySpecification = new PartySpecification(partyCommand.getDescription(),
					partyCommand.getPartyType(), partyCommand.getPreferredCurrencyUom());
			Party party = partyManagerService.createNewParty(partySpecification,null,null);
			if(party != null) {
				return party.getExternalId();
			}
		} 
		return "" + PartyCommand.PARTY_VALIDATION_ERROR;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.facade.party.PartyManagerFacade#storeContactMech(java.lang.String, com.openappengine.facade.party.dto.PartyContactMechCommand)
	 */
	public void storeContactMech(String partyExternalId,
			PartyContactMechCommand partyContactMechCommand) {
		PartyContactMech partyContactMech = new ContactMechDTOAssembler()
				.fromDTO(partyContactMechCommand);
		PartyContactMechValidator partyContactMechValidator = new PartyContactMechValidator();
		Errors errors = new BeanPropertyBindingResult(partyContactMechCommand, "partyContactMechCommand");
		ValidationUtils.invokeValidator(partyContactMechValidator,partyContactMechCommand, errors);
		partyManagerService.createContactMech(partyExternalId, partyContactMech);
	}
	
	/**
	 * Create Address for the Party with the given Party - ExternalId
	 * @param externalId
	 * @param addressCommand
	 */
	public void storeAddress(String externalId,AddressCommand addressCommand) {
		AddressCommandValidator validator = new AddressCommandValidator();
		Errors errors = new BeanPropertyBindingResult(addressCommand, "addressCommand");
		validator.validate(addressCommand,errors);
		
		if(!errors.hasErrors()) {
			Address address = new AddressDTOAssembler().fromDTO(addressCommand);
			partyManagerService.createAddress(externalId, address);
		}
	}

	public void setPartyManagerService(IPartyManagerService partyManagerService) {
		this.partyManagerService = partyManagerService;
	}
	
}
