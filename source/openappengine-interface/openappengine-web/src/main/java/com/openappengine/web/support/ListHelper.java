/**
 * 
 */
package com.openappengine.web.support;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.openappengine.oxm.OxmMappingException;

/**
 * @author hrishi
 * 
 */
public class ListHelper {

	

	public List<SelectItem> getApplicationCodes(String codeType) throws OxmMappingException {
		List<SelectItem> codes = new ArrayList<SelectItem>();
		return codes;
	}
	
	/**
	 * @return Perishable Types
	 */
	public List<SelectItem> getYesNoSelect() {
		List<SelectItem> perishableTypes = new ArrayList<SelectItem>();
		perishableTypes.add(new SelectItem(Boolean.TRUE, "Yes"));
		perishableTypes.add(new SelectItem(Boolean.FALSE, "No"));
		return perishableTypes;
	}

}
