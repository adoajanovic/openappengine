/**
 * 
 */
package com.openappengine.facade.party.dto;

import com.openappengine.facade.code.dto.CodeDTO;
import com.openappengine.model.code.CodeTypeConstants;

/**
 * @author hrishi
 *
 */
public class PartyTypeDTO extends CodeDTO {

	private static final long serialVersionUID = 1L;
	
	public PartyTypeDTO() {
		setType(CodeTypeConstants.PARTY_TYPE);
	}

}
