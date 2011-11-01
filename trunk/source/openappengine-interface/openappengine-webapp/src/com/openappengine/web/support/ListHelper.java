/**
 * 
 */
package com.openappengine.web.support;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

/**
 * @author hrishi
 * 
 */
public class ListHelper {

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
