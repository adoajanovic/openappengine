/**
 * 
 */
package com.openappengine.facade.core.component.ui;



/**
 * @author hrishikesh.joshi
 * @since Jan 5, 2012
 */
public interface ValueRefAware<T> {
	

	/**
	 * Set the EntityValue.
	 * @param value
	 */
	void setValue(T value);
	
	/**
	 * @return Is the EntityValue set ?
	 */
	boolean isValueSet();
	
	/**
	 * @return Value Ref Field.
	 */
	String getValueRef();

}
