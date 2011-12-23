/**
 * 
 */
package com.openappengine.facade.ui.params;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author hrishikesh.joshi
 * @Dec 23, 2011
 */
public class Params implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Map<String,Object> paramsMap = new HashMap<String, Object>();

	public Map<String, Object> getParameterMap() {
		return paramsMap;
	}

	public void setParameterMap(Map<String, Object> params) {
		this.paramsMap = params;
	} 

	public Object getParam(String name) {
		return paramsMap.get(name);
	}
	
	public void setParam(String paramName,Object object) {
		this.paramsMap.put(paramName, object);
	}
	
	public void removeParam(String paramName) {
		if(paramsMap.containsKey(paramName)) {
			paramsMap.remove(paramName);
		}
	}
	
	public Set<String> getParameterNames() {
		return paramsMap.keySet();
	}
}
