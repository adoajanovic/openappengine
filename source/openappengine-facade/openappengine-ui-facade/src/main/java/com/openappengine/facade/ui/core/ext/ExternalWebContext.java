/**
 * 
 */
package com.openappengine.facade.ui.core.ext;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.openappengine.facade.ui.core.ExternalContext;

/**
 * ExternalContext representing the JEE Environment. 
 * Initialized from the XmlScreenProcessingFilter.
 * 
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class ExternalWebContext implements ExternalContext {
	
	protected HttpServletRequest request;
	
	@Override
	public Object getRequest() {
		return request;
	}

	@Override
	public Map<String, Object> getRequestParameters() {
		Map<String,Object> cleanedParams = new HashMap<String,Object>();

		Map parameterMap = request.getParameterMap();
		
		if(parameterMap != null && !parameterMap.isEmpty()) {
			Set params = parameterMap.keySet();
			for (Object object : params) {
				final String param = (String) object;
				//Request Parameters are not String but String[]; 
				//hence require clean-up to avoid further problems related to ClassCastExceptions.
				String[] value = (String[]) parameterMap.get(param);
				cleanedParams.put(param, value[0]);
			}
		}
		return cleanedParams;
	}

}