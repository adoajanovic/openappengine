/**
 * 
 */
package com.openappengine.facade.entity;

import java.io.Serializable;

import com.openappengine.facade.entity.definition.EntityDefinition;

/**
 * @author hrishikesh.joshi
 *
 */
public class EntityValue extends DataBeanWrapper implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Object instance;
	
	private String entityName;
	
	private EntityDefinition entityDefinition;
	
	public EntityValue(String entityName,EntityDefinition entityDefinition,Object object) {
	    super(object);
	    this.entityName = entityName;
	    this.entityDefinition = entityDefinition;
	    this.setInstance(object);
	}
	
	public boolean isModified() {
		//TODO
		return false;
	}
	
	public Object getInstance() {
	    return instance;
	}

	public void setInstance(Object instance) {
	    this.instance = instance;
	}

	public String getEntityName() {
	    return entityName;
	}

	public EntityDefinition getEntityDefinition() {
	    return entityDefinition;
	}
}
