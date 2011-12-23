/**
 * 
 */
package com.openappengine.facade.ui.widgets.forms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hrishikesh.joshi
 * @Dec 23, 2011
 */
public class FormParams {
	
	private Map<String, Object> queryParams = new HashMap<String, Object>();

	public Map<String, Object> getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(Map<String, Object> queryParams) {
		this.queryParams = queryParams;
	}
}
