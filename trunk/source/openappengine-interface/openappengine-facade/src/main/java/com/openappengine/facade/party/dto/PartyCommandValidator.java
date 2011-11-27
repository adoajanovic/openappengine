/**
 * 
 */
package com.openappengine.facade.party.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author hrishi
 *
 */
public class PartyCommandValidator implements Validator {

	public boolean supports(Class<?> cls) {
		return PartyCommand.class.isAssignableFrom(cls);
	}

	public void validate(Object command, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "partyCommand.description.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "preferredCurrencyUom", "partyCommand.preferredCurrencyUom.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "partyType", "partyCommand.partyType.required");
	}

}
