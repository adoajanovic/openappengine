/**
 * 
 */
package com.openappengine.gui.engine.ui.params;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hrishikesh.joshi
 * @Dec 23, 2011
 */
public class Parameters implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Map<Param,Object> parameterMap = new HashMap<Param, Object>();
	
	private Set<Param> requiredParams = new HashSet<Param>();

	public Object getParam(String name) {
		return parameterMap.get(name);
	}
	
	public void setParam(Param paramName,Object object) {
		this.parameterMap.put(paramName, object);
	}
	
	public void removeParam(String paramName) {
		if(parameterMap.containsKey(paramName)) {
			parameterMap.remove(paramName);
		}
	}
	
	public Set<Param> getParameterNames() {
		return parameterMap.keySet();
	}

	public Map<Param,Object> getParameterMap() {
		return parameterMap;
	}

	public void setParameterMap(Map<Param,Object> parameterMap) {
		this.parameterMap = parameterMap;
	}
	
	public boolean isEmpty() {
		if(parameterMap == null) {
			return false;
		}
		return parameterMap.isEmpty();
	}
	
	public Set<Param> getRequiredParams() {
		if (requiredParams == null) {
			if (parameterMap != null) {
				Set<Param> params = parameterMap.keySet();
				for (Param param : params) {
					if (param.isRequired()) {
						requiredParams.add(param);
					}
				}
			}
		}
		return requiredParams;
	}

	public void setRequiredParams(Set<Param> requiredParams) {
		this.requiredParams = requiredParams;
	}
}
