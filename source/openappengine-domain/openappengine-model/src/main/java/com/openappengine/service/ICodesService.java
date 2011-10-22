/**
 * 
 */
package com.openappengine.service;

import java.util.List;

import com.openappengine.model.code.Code;
import com.openappengine.model.code.CodeType;

/**
 * @author hrishi
 *
 */
public interface ICodesService {
	

	public List<CodeType> getCodeTypes();
	
	/**
	 * Fetch a list of CodeMaster given the CodeType as String.
	 * @param codeType
	 * @return {@link List}<{@link Code}>
	 */
	public List<Code> getCodeMasterByCodeType(String codeType);
	
	/**
	 *  Add {@link CodeType}
	 * @param codeType
	 */
	public void addCodeType(CodeType codeType);
	
	
	/**
	 * Add {@link Code} to the given {@link CodeType}
	 * @param codeType
	 * @param code
	 */
	public void addCode(CodeType codeType, Code code);

}
