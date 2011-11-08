/**
 * 
 */
package com.openappengine.facade.party.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.openappengine.model.addressbook.AddressRole;
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
			Set<PartyContactMech> partyContactMechs = new HashSet<PartyContactMech>();
			Set<Address> addresses = new HashSet<Address>();
			if(partyCommand.getAddresses() != null) {
				for (AddressCommand addressCmd : partyCommand.getAddresses()) {
					Address address = new Address();
					address.setAddress1(addressCmd.getAddress1());
					address.setAddress2(addressCmd.getAddress2());
					address.setAttnName(addressCmd.getAttnName());
					address.setCity(addressCmd.getCity());
					address.setStateProvince(addressCmd.getStateProvince());
					address.setCountry(addressCmd.getCountry());
					address.setDirections(addressCmd.getDirections());
					address.setPostalCode(addressCmd.getPostalCode());
					address.setPostalCodeExt(addressCmd.getPostalCodeExt());
					address.setToName(addressCmd.getToName());
					
					Set<String> roles = addressCmd.getRoles();
					Set<AddressRole> addressRoles = new HashSet<AddressRole>();
					if(roles != null && !roles.isEmpty()) {
						for (String role : roles) {
							Date fromDate = new Date();
							
							Calendar calendar = Calendar.getInstance();
							Date endDate = calendar.getTime();
							
							calendar.set(9999, 11, 31);
							AddressRole addressRole = new AddressRole(role, fromDate, endDate);
							addressRoles.add(addressRole);
						}
					}
					
					address.setAddressRoles(addressRoles);
					addresses.add(address);
				}
			}
			
			if(partyCommand.getContactMechs() != null) {
				for (PartyContactMechCommand partyContactMechCmd : partyCommand.getContactMechs()) {
					PartyContactMech partyContactMech = new PartyContactMech(
							partyContactMechCmd.getContactMechPurpose(),
							partyContactMechCmd.getContactMechType(),
							partyContactMechCmd.getInfoString());
					partyContactMechs.add(partyContactMech);
				}
			}
			
			Party party = partyManagerService.createNewParty(partySpecification,partyContactMechs,addresses);
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
