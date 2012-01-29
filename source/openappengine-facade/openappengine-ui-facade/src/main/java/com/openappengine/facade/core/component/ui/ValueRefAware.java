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
	 * @return Is the EntityValue set ?
	 */
	boolean isValueSet();
	
	/**
	 * @return Value Ref Field.
	 */
	String getValueRef();
	
	/**
	 * Get Actual Value
	 * @return T
	 */
	T getValue();

	/**
	 * Set Value
	 * @param t
	 */
	void setValue(T t);
}
