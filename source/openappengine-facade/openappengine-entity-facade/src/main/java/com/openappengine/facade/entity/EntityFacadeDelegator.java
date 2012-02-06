/**
 * 
 */
package com.openappengine.facade.entity;

import com.openappengine.facade.entity.definition.EntityDefinition;
import com.openappengine.facade.entity.exception.EntityValueException;

/**
 * @author hrishikesh.joshi
 *
 */
public class EntityFacadeDelegator {
	
	public PojoEntityValue createEntityValue(String entityName,EntityDefinition ed,Class<?> entityClass) {
		try {
			Object newInstance = entityClass.newInstance();
			PojoEntityValue pojoEntityValue = new PojoEntityValue(entityName,ed,newInstance);
			return pojoEntityValue;
		} catch (InstantiationException e) {
			throw new EntityValueException("Entity : " + entityClass + " cannot be instantiated.");
		} catch (IllegalAccessException e) {
			throw new EntityValueException("Illegal Access to Entity : " + entityClass + ".");
		}
	}

}
