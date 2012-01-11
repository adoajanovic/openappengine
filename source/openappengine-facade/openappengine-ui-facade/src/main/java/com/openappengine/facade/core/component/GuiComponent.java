/**
 * 
 */
package com.openappengine.facade.core.component;

import java.io.Serializable;
import java.util.List;

/**
 * The root interface of the GuiComponent hierarchy. 
 * 
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public interface GuiComponent extends Serializable {
	
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


	/**
	 * @return
	 */
	boolean hasChildren();


	/**
	 * @return
	 */
	List<GuiComponent> getChildComponents();
}
