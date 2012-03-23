/**
 * 
 */
package com.openappengine.gui.engine.core.component.ui;



/**
 * @author hrishikesh.joshi
 * @since Jan 5, 2012
 */
public interface ValueRefAware<T> {
	

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
