/**
 * 
 */
package com.openappengine.facade.entity.validator;

import org.springframework.util.Assert;
import org.springframework.validation.Errors;

import com.openappengine.facade.entity.definition.EntityDefinition;

/**
 * @author hrishi
 * since Feb 1, 2012
 */
public class DefaultEntityValidator implements EntityValidator {
	
	private EntityDefinition entityDefinition;
	
	/**
	 * @param entityDefinition
	 */
	public DefaultEntityValidator(EntityDefinition entityDefinition) {
		super();
		Assert.notNull(entityDefinition, "No EntityDefinition found.!");
		this.entityDefinition = entityDefinition;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		Class<?> entityClass = entityDefinition.getEntityClass();
		return entityClass.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//TODO - Add Validation Based on EntityDefinition Created.
	}

}
