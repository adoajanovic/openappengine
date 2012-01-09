/**
 * 
 */
package com.openappengine.service.impl;

import java.util.List;

import com.openappengine.model.code.Code;
import com.openappengine.model.code.CodeType;
import com.openappengine.repository.CodeRepository;
import com.openappengine.service.ICodesService;

/**
 * @author hrishi
 *
 */
public class CodeServiceImpl extends ModelService implements ICodesService {

	private CodeRepository codeRepository;
	
	/* (non-Javadoc)
	 * @see com.openappengine.service.ICodesService#getCodeTypes()
	 */
	public List<CodeType> getCodeTypes() {
		return codeRepository.getCodeTypes();
	}

	/* (non-Javadoc)
	 * @see com.openappengine.service.ICodesService#getCodeMasterByCodeType(java.lang.String)
	 */
	public List<Code> getCodesByCodeType(String codeType) {
		return codeRepository.getCodesByCodeType(codeType);
	}

	/* (non-Javadoc)
	 * @see com.openappengine.service.ICodesService#addCodeType(com.openappengine.model.code.CodeType)
	 */
	public void addCodeType(CodeType codeType) {
		codeRepository.store(codeType);
	}

	/* (non-Javadoc)
	 * @see com.openappengine.service.ICodesService#addCode(com.openappengine.model.code.CodeType, com.openappengine.model.code.Code)
	 */
	public void addCode(CodeType codeType, Code code) {
		codeRepository.addCodeToCodeType(codeType, code);
	}

	public void setCodeRepository(CodeRepository codeRepository) {
		this.codeRepository = codeRepository;
	}
}
