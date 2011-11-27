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
public class PartyContactMechValidator implements Validator {

	public boolean supports(Class<?> cls) {
		return PartyContactMechCommand.class.isAssignableFrom(cls);
	}

	public void validate(Object partyContactMech, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "contactMechPurpose", "partyCommand.contactMechPurpose.required");
		ValidationUtils.rejectIfEmpty(errors, "contactMechType", "partyCommand.contactMechType.required");
		ValidationUtils.rejectIfEmpty(errors, "infoString", "partyCommand.infoString.required");
	}
	
	

}
