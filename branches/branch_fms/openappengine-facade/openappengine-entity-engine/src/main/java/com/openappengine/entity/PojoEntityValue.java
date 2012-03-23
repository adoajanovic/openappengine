/**
 * 
 */
package com.openappengine.entity;

import java.io.Serializable;

import com.openappengine.entity.definition.Entity;

/**
 * @author hrishikesh.joshi
 *
 */
public class PojoEntityValue extends DataBeanWrapper implements Serializable,EntityValue {

	private static final long serialVersionUID = 1L;
	
	private Object instance;
	
	private String entityName;
	
	private Entity entityDefinition;
	
	public PojoEntityValue(String entityName,Entity entityDefinition,Object object) {
	    super(object);
	    this.entityName = entityName;
	    this.entityDefinition = entityDefinition;
	    this.setInstance(object);
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

	public Entity getEntityDefinition() {
	    return entityDefinition;
	}
	
}
