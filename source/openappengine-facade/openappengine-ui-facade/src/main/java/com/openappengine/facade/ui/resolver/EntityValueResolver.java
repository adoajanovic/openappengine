/**
 * 
 */
package com.openappengine.facade.ui.resolver;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
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
	
	private String parameterPrefix;
	
	private String prefixDelimiter = ".";
	
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
				//If there is no prefix for query parameters
				if(StringUtils.isEmpty(parameterPrefix)) {
					if(queryParams.containsKey(property)) {
						filteredPkParams.put(property, queryParams.get(property));
					} 
				} else {
					//Iterate over query params.
					//TODO
					if(queryParams != null) {
						Set<String> keySet = queryParams.keySet();
						for (String key : keySet) {
							String prefixKey = createParamKey();
							if(key.startsWith(prefixKey)) {
								String trimmedProperty = key.replaceFirst(prefixKey, "");
								if(trimmedProperty.equals(property)) {
									filteredPkParams.put(property, queryParams.get(key));
								}
							}
						}
					}
				}
			}
		}
		EntityValue entityValue = entityFacade.findUniqueEntityValue(entityName, filteredPkParams);
		return entityValue;
	}

	/**
	 * @return
	 */
	private String createParamKey() {
		StringBuffer paramKey = new StringBuffer();
		paramKey.append(parameterPrefix);
		paramKey.append(prefixDelimiter);
		String prefixKey = paramKey.toString();
		return prefixKey;
	}

	public String getParameterPrefix() {
		return parameterPrefix;
	}

	public void setParameterPrefix(String parameterPrefix) {
		this.parameterPrefix = parameterPrefix;
	}

	public String getPrefixDelimiter() {
		return prefixDelimiter;
	}

	public void setPrefixDelimiter(String prefixDelimiter) {
		this.prefixDelimiter = prefixDelimiter;
	}
	
}
