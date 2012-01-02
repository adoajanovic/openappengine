/**
 * 
 */
package com.openappengine.facade.core;

import java.io.Serializable;
import java.util.Map;

/**
 * The ActionRequest interface encapsulates the Action 
 * and the Request Parameters for the Action Handler. 
 * 
 * It decouples the Action Handlers from the Gui Components.
 * The ActionDispatcher interface holds the dictionary that maps an ActionRequest to an ActionHandler.
 * 
 * The appropriate ActionHandler's would be "executed" accordingly.
 * 
 * @author hrishikesh.joshi
 * @since Jan 2, 2012
 */
public interface ActionRequest extends Serializable {
	
	/**
	 * Get the Action Name
	 * @return Action Name.
	 */
	String getActionName();

	/**
	 * Get Request Parameters.
	 * @return Request Parameters.
	 */
	Map<String,Object> getActionParameters();
}
