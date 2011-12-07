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
	
	public EntityDataHolder createNewEntityDataHolder(String entityClassName) {
		if(!StringUtils.hasText(entityClassName)) {
			throw new EntityValueException("Entity : " + entityClassName + " cannot be empty.");
		}
		
		//TODO
		return null;
	}
	

}
