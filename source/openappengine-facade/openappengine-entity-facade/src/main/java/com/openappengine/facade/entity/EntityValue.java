/**
 * 
 */
package com.openappengine.facade.entity;

import java.io.Serializable;

/**
 * @author hrishikesh.joshi
 *
 */
public class EntityValue extends DataBeanWrapper implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Object instance;
	
	public EntityValue(Object object) {
	    super(object);
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
	
}
