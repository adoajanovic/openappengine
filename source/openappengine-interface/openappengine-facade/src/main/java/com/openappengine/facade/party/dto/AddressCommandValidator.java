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
public class AddressCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return AddressCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "address1", "AddressCommand.contactMechPurpose.required");
		ValidationUtils.rejectIfEmpty(errors, "postalCode", "partyCommand.contactMechType.required");
		ValidationUtils.rejectIfEmpty(errors, "city", "partyCommand.contactMechType.required");
		ValidationUtils.rejectIfEmpty(errors, "stateProvince", "partyCommand.infoString.required");
		ValidationUtils.rejectIfEmpty(errors, "country", "partyCommand.infoString.required");
		ValidationUtils.rejectIfEmpty(errors, "country", "partyCommand.infoString.required");
		//TODO - Validate the Address Roles(Types)
	}

}
