/**
 * 
 */
package com.openappengine.facade.party.dto;

import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author hrishi
 *
 */
public class PartyCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return PartyCommand.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object command, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "partyCommand.description.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "preferredCurrencyUom", "partyCommand.preferredCurrencyUom.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "partyType", "partyCommand.partyType.required");
		
		PartyCommand partyCommand = (PartyCommand) command;
		List<PartyContactMechCommand> partyContactMechs = partyCommand.getPartyContactMechs();
		if(partyContactMechs != null && !partyContactMechs.isEmpty()) {
			PartyContactMechValidator partyContactMechValidator = new PartyContactMechValidator();
			for (PartyContactMechCommand partyContactMechCommand : partyContactMechs) {
				ValidationUtils.invokeValidator(partyContactMechValidator, partyContactMechCommand, errors);
			}
		}
	}

}
