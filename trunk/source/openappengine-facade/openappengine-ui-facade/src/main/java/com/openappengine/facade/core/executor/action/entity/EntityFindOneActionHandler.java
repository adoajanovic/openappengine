/**
 * 
 */
package com.openappengine.facade.core.executor.action.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.annotations.ActionParams;
import com.openappengine.facade.core.executor.annotations.Mode;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.entity.PojoEntityValue;
import com.openappengine.facade.ui.resolver.EntityValueResolver;
import com.openappengine.facade.ui.resolver.ValueRef;

/**
 * 	
 *	Does a "find-by" on the primary key. 
 *  If no value is found does nothing to the value-field. If a value is
 *  found, sets the value in the "value-field" attribute in the context.
 * 
 * @author hrishi
 *
 */
@ActionParams(actionName="entity-find-one",mode=Mode.ALL)
public class EntityFindOneActionHandler extends AbstractEntityActionHandler {
	
	public EntityFindOneActionHandler() {
	}
	
	@Override
	public PojoEntityValue execute(ActionContext actionContext) {
		boolean autoFieldMap = (Boolean) getActionRequest().getActionParameter("autoFieldMap");
		
		Map<String,ValueRef<Object>> andParameterMap = new HashMap<String,ValueRef<Object>>();
		andParameterMap = (Map<String, ValueRef<Object>>) getActionRequest().getActionParameter("andParameterMap");
		
		Map<String, Object> params = new HashMap<String, Object>();
		if(autoFieldMap) {
			//Map request params from the external context directly to the entity properties.
			ExternalContext externalContext = actionContext.getExternalContext();
			Assert.notNull(externalContext, "External Context not set. " + getClass() + " Action Handler requires an External Context when using the attribute auto-field-map");
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
		
		EntityValueResolver valueResolver = new EntityValueResolver(getEntityName(), params);
		String autoFieldPrefix = (String) getActionRequest().getActionParameter("autoFieldPrefix");
		if(StringUtils.isNotEmpty(autoFieldPrefix)) {
			valueResolver.setParameterPrefix(autoFieldPrefix);
		}
		
		return (PojoEntityValue) valueResolver.resolveValue();
	}

}
