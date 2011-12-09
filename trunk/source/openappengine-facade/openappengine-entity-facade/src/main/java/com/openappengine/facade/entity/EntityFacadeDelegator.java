/**
 * 
 */
package com.openappengine.facade.entity;

import org.springframework.util.StringUtils;

import com.openappengine.facade.entity.exception.EntityValueException;

/**
 * @author hrishikesh.joshi
 *
 */
public class EntityFacadeDelegator {
	
	public EntityValue createEntityValue(String entityClassName) {
		if(!StringUtils.hasText(entityClassName)) {
			throw new EntityValueException("Entity : " + entityClassName + " cannot be empty.");
		}
		
		try {
			Class<?> entityClass = Class.forName(entityClassName);
			if(entityClass == null) {
				throw new EntityValueException("Entity : " + entityClassName + " not found.");	
			}
			
			Object newInstance = entityClass.newInstance();
			EntityValue entityValue = new EntityValue(newInstance);
			return entityValue;
		} catch (ClassNotFoundException e) {
			throw new EntityValueException("Entity : " + entityClassName + " not found.");
		} catch (InstantiationException e) {
			throw new EntityValueException("Entity : " + entityClassName + " cannot be instantiated.");
		} catch (IllegalAccessException e) {
			throw new EntityValueException("Illegal Access to Entity : " + entityClassName + ".");
		}
	}
	

}
