/**
 * 
 */
package com.openappengine.facade.core.executor.action.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.util.Assert;

import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.ui.resolver.EntityValueResolver;
import com.openappengine.facade.ui.resolver.ValueRef;
import com.openappengine.facade.ui.resolver.ValueResolver;

/**
 * 	
 *	Does a "find-by" on the primary key. 
 *  If no value is found does nothing to the value-field. If a value is
 *  found, sets the value in the "value-field" attribute in the context.
 * 
 * @author hrishi
 *
 */
public class EntityFindOneActionHandler extends AbstractEntityActionHandler {
	
	private Map<String,ValueRef<Object>> andParameterMap = new HashMap<String,ValueRef<Object>>();
	
	private boolean autoFieldMap = false;
	
	private String conditionExpression;
	
	public EntityFindOneActionHandler(String entityName) {
		setEntityName(entityName);
	}

	@Override
	public EntityValue execute(ActionContext actionContext) {
		Map<String,Object> params = new HashMap<String, Object>();
		
		if(autoFieldMap) {
			//Map request params from the external context directly to the entity properties.
			ExternalContext externalContext = actionContext.getExternalContext();
			Assert.notNull(externalContext, "External Context not set. " + getClass()
					+ " Action Handler requires an External Context when using the attribute auto-field-map");
			params = externalContext.getRequestParameters();
		} else if(andParameterMap != null) {
			Set<String> paramKeys = andParameterMap.keySet();
			if(paramKeys != null) {
				for (String paramKey : paramKeys) {
					ValueRef<Object> valueRef = andParameterMap.get(paramKey);
					Object val = valueRef.getActualValue();
					params.put(paramKey,val);
				}
			}
		}
		
		ValueResolver valueResolver = new EntityValueResolver(getEntityName(), params);
		return (EntityValue) valueResolver.resolveValue();
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
