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
	
	public EntityValue(Object object) {
	    super(object);
	}
	
	public boolean isModified() {
		//TODO
		return false;
	}
	
	public Object getInstance() {
	    return getWrappedInstance();
	}
	
}
