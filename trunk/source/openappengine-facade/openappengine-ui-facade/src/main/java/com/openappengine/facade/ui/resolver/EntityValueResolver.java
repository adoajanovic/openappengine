/**
 * 
 */
package com.openappengine.facade.ui.resolver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.util.Assert;

import com.openappengine.facade.entity.EntityFacade;
import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.entity.context.EntityFacadeContext;
import com.openappengine.facade.entity.definition.EntityDefinition;
import com.openappengine.facade.entity.definition.FieldDefinition;

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
		Assert.notNull(entityFacade,"Entity Engine Not Initialized.");
		EntityDefinition entityDefinition = entityFacade.findEntityDefinition(entityName);
		List<FieldDefinition> pkFields = entityDefinition.getPKFields();
		final Map<String,Object> filteredPkParams = new ConcurrentHashMap<String, Object>();
		if(pkFields != null) {
			for (FieldDefinition fieldDefinition : pkFields) {
				String property = fieldDefinition.getProperty();
				if(queryParams.containsKey(property)) {
					filteredPkParams.put(property, queryParams.get(property));
				}
			}
		}
		EntityValue entityValue = entityFacade.findUniqueEntityValue(entityName, filteredPkParams);
		return entityValue;
	}
	
}
