/**
 * 
 */
package com.openappengine.facade.entity;

import com.openappengine.facade.entity.exception.EntityValueException;

/**
 * @author hrishikesh.joshi
 *
 */
public class EntityFacadeDelegator {
	
	public EntityValue createEntityValue(Class<?> entityClass) {
		try {
			Object newInstance = entityClass.newInstance();
			EntityValue entityValue = new EntityValue(newInstance);
			return entityValue;
		} catch (InstantiationException e) {
			throw new EntityValueException("Entity : " + entityClass + " cannot be instantiated.");
		} catch (IllegalAccessException e) {
			throw new EntityValueException("Illegal Access to Entity : " + entityClass + ".");
		}
	}

}
