/**
 * 
 */
package com.openappengine.facade.core.executor.action.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.ui.resolver.EntityValueResolver;
import com.openappengine.facade.ui.resolver.ValueRef;
import com.openappengine.facade.ui.resolver.ValueResolver;

/**
 * @author hrishi
 *
 */
public class EntityFindOneActionHandler implements ActionHandler {
	
	private String entityName;
	
	private Map<String,ValueRef<Object>> andParameterMap = new HashMap<String,ValueRef<Object>>();
	
	private boolean autoFieldMap = false;
	
	private String conditionExpression;
	
	public EntityFindOneActionHandler(){
	}
	
	public EntityFindOneActionHandler(String entityName) {
		this.setEntityName(entityName);
	}

	@Override
	public EntityValue execute() {
		Map<String,Object> params = new HashMap<String, Object>();
		if(andParameterMap != null) {
			Set<String> paramKeys = andParameterMap.keySet();
			if(paramKeys != null) {
				for (String paramKey : paramKeys) {
					ValueRef<Object> valueRef = andParameterMap.get(paramKey);
					Object val = valueRef.getActualValue();
					params.put(paramKey,val);
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

	public Map<String, ValueRef<Object>> getAndParameterMap() {
		return andParameterMap;
	}

	public void setAndParameterMap(Map<String, ValueRef<Object>> andParameterMap) {
		this.andParameterMap = andParameterMap;
	}
	
	public void addAndParameter(String fieldName,ValueRef<Object> value) {
		this.andParameterMap.put(fieldName, value);
	}

	public boolean isAutoFieldMap() {
		return autoFieldMap;
	}

	public void setAutoFieldMap(boolean autoFieldMap) {
		this.autoFieldMap = autoFieldMap;
	}

	public String getConditionExpression() {
		return conditionExpression;
	}

	public void setConditionExpression(String conditionExpression) {
		this.conditionExpression = conditionExpression;
	}

	@Override
	public String getName() {
		return "entity-find-one";
	}

}
