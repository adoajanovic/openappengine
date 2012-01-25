/**
 * 
 */
package com.openappengine.facade.core.ext;

import java.util.Map;

import org.springframework.ui.ModelMap;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public interface ExternalContext {

	/**
	 * @return Request Object from the External Context. 
	 */
	Object getRequest();
	
	/**
	 * Get request parameters that are passed to the Screen. 
	 * @return
	 */
	Map<String, Object> getRequestParameters();
	
	/**
	 * @return ModelMap to bind data for UI.
	 */
	ModelMap getModelMap();
	
	/**
	 * Add Model Attribute
	 * @param attrName
	 * @param value
	 */
	void addModelMapAttribute(String attrName,Object value);
}
