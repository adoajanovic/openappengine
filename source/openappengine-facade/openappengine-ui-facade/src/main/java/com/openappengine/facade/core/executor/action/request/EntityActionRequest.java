/**
 * 
 */
package com.openappengine.facade.core.executor.action.request;

import com.openappengine.facade.core.component.value.ValueFieldAware;

/**
 * @author hrishi
 * since Jan 29, 2012
 */
public class EntityActionRequest extends DefaultActionRequest implements ValueFieldAware {

	private static final long serialVersionUID = 1L;
	
	private String[] valueFields;
	
	/**
	 * @param actionName
	 * @param object
	 */
	public EntityActionRequest(String actionName, Object object) {
		super(actionName, object);
	}
	
	/**
	 * @param actionName
	 * @param object
	 */
	public EntityActionRequest(String actionName,Object object,String mode) {
		super(actionName,object,mode);
	}
	
	@Override
	public String[] getValueFields() {
		return valueFields;
	}

	public void setValueFields(String[] valueFields) {
		this.valueFields = valueFields;
	}

}
