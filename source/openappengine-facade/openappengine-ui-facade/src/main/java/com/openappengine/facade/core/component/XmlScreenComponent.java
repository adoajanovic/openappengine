/**
 * 
 */
package com.openappengine.facade.core.component;

import java.io.Serializable;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public interface XmlScreenComponent extends Serializable {

	/**
	 * Every Component in the XML Screen has a Component-Type 
	 * registered with the Context.
	 * 
	 * @return
	 */
	String getComponentType();
	
	
	/**
	 * Unique Component Name withing the context.
	 * @return
	 */
	String getComponentName();
}
