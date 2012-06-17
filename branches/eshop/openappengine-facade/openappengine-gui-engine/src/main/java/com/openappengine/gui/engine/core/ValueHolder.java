/**
 * 
 */
package com.openappengine.gui.engine.core;

import java.io.Serializable;

/**
 * @author hrishikesh.joshi
 * @since Jan 3, 2012
 */
public interface ValueHolder extends Serializable {

	/**
	 * Get Actual Value.
	 * @return
	 */
	Object getValue();

	/**
	 * Whether the holder has a value reference
	 * @return
	 */
	boolean hasValueReference();
	
	/**
	 * Get the Value Reference.
	 * @return
	 */
	String getValueReference();
}
