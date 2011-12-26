/**
 * 
 */
package com.openappengine.facade.ui.resolver;

import java.util.Map;

import com.openappengine.facade.entity.EntityFacade;
import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.entity.context.EntityFacadeContext;

/**
 * @author hrishikesh.joshi
 * @Dec 23, 2011
 */
public class EntityValueResolver implements ValueResolver {

	private String entityName;
	
	private Map<String,Object> queryParams;
	
	public EntityValueResolver(String entityName, Map<String, Object> queryParams) {
		super();
		this.entityName = entityName;
		this.queryParams = queryParams;
	}

	@Override
	public Object resolveValue() {
		EntityFacade entityFacade = EntityFacadeContext.getEntityFacade();
		EntityValue entityValue = entityFacade.findUniqueEntityValue(entityName, queryParams);
		return entityValue;
	}
	
}
