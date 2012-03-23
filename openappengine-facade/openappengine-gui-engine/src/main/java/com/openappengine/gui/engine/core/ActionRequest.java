/**
 * 
 */
package com.openappengine.gui.engine.core;

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
	
	public static final String MODE_XML = "xml";
	
	public static final String MODE_POJO = "pojo";
	
	/**
	 * Get the Action Name
	 * @return Action Name.
	 */
	String getActionName();
	
	String getMode();

	/**
	 * Get Request Parameters.
	 * @return Request Parameters.
	 */
	Map<String,Object> getActionParameters();
	
	Object getActionParameter(String param);
	
	<T> T getActionParameter(String paramKey,Class<T> t);
	
	/**
	 * Add Action Parameters
	 * @param params
	 */
	void addActionParameters(Map<String,Object> params);
	
	/**
	 * Add a single Action Parameter.
	 * @param param
	 * @param value
	 */
	void addActionParameter(String param,Object value);
}
