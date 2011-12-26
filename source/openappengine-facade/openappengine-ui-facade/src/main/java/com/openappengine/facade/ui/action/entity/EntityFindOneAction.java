/**
 * 
 */
package com.openappengine.facade.ui.action.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.ui.context.ScreenContext;
import com.openappengine.facade.ui.params.Value;
import com.openappengine.facade.ui.preaction.PreAction;
import com.openappengine.facade.ui.resolver.EntityValueResolver;
import com.openappengine.facade.ui.resolver.ValueResolver;

/**
 * @author hrishi
 *
 */
public class EntityFindOneAction extends PreAction {
	
	private String entityName;
	
	private Map<String,Value> andParameterMap = new HashMap<String,Value>();
	
	private boolean autoFieldMap = false;
	
	private String valueField;
	
	public EntityFindOneAction(String entityName) {
		this.setEntityName(entityName);
	}

	@Override
	public EntityValue execute(ScreenContext screenContext) {
		Map<String,Object> params = new HashMap<String, Object>();
		if(andParameterMap != null) {
			Set<String> paramKeys = andParameterMap.keySet();
			if(paramKeys != null) {
				for (String paramKey : paramKeys) {
					Value value = andParameterMap.get(paramKey);
					if(value != null) {
						Object val = value.getValue();
						params.put(paramKey,val);
					}
				}
			}
		}
		
		ValueResolver valueResolver = new EntityValueResolver(entityName, params);
		return (EntityValue) valueResolver.resolveValue();
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public Map<String,Value> getAndParameterMap() {
		return andParameterMap;
	}

	public void setAndParameterMap(Map<String,Value> andParameterMap) {
		this.andParameterMap = andParameterMap;
	}
	
	public void addAndParameter(String fieldName,Value value) {
		this.andParameterMap.put(fieldName, value);
	}

	public boolean isAutoFieldMap() {
		return autoFieldMap;
	}

	public void setAutoFieldMap(boolean autoFieldMap) {
		this.autoFieldMap = autoFieldMap;
	}

	public String getValueField() {
		return valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

}
