/**
 * 
 */
package com.openappengine.facade.code.dto;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.model.code.Code;

/**
 * @author hrishi
 *
 */
public class CodesDTOAssembler {
	
	/**
	 * Add List of CodeDTO's.
	 * @param codes
	 * @return
	 */
	public List<CodeDTO> toDTOList(List<Code> codes) {
		if(codes == null || codes.isEmpty()) {
			return null;
		}
		List<CodeDTO> dtos = new ArrayList<CodeDTO>();
		for (Code code : codes) {
			dtos.add(new CodeDTO(code.getCodeLabel(),code.getCodeValue()));
		}
		return dtos;
	}
}
