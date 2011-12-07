/**
 * 
 */
package com.openappengine.facade.entity;

import java.io.Serializable;

/**
 * @author hrishikesh.joshi
 *
 */
public class EntityValue implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityDataHolder entityDataHolder;
	
	public EntityValue(EntityDataHolder entityDataHolder) {
		this.entityDataHolder = entityDataHolder;
	}
	
	public boolean isModified() {
		//TODO
		return false;
	}
	
	

}
