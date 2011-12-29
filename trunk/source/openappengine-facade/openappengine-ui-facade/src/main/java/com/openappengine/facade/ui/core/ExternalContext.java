/**
 * 
 */
package com.openappengine.facade.ui.core;

import java.util.Map;

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
	public Map<String, Object> getRequestParameters();
}
