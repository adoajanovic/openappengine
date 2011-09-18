/**
 * 
 */
package com.openappengine.container;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class Component implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String componentId;
	
	private String eventHandler;
	
	private String startupMethod;
	
	private String shutdownMethod;

	/**
	 * @param componentId
	 * @param eventHandler
	 * @param startupMethod
	 * @param shutdownMethod
	 */
	public Component(String componentId, String eventHandler,
			String startupMethod, String shutdownMethod) {
		super();
		this.componentId = componentId;
		this.eventHandler = eventHandler;
		this.startupMethod = startupMethod;
		this.shutdownMethod = shutdownMethod;
	}

	/**
	 * @return the componentId
	 */
	public String getComponentId() {
		return componentId;
	}

	/**
	 * @param componentId the componentId to set
	 */
	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	/**
	 * @return the eventHandler
	 */
	public String getEventHandler() {
		return eventHandler;
	}

	/**
	 * @param eventHandler the eventHandler to set
	 */
	public void setEventHandler(String eventHandler) {
		this.eventHandler = eventHandler;
	}

	/**
	 * @return the startupMethod
	 */
	public String getStartupMethod() {
		return startupMethod;
	}

	/**
	 * @param startupMethod the startupMethod to set
	 */
	public void setStartupMethod(String startupMethod) {
		this.startupMethod = startupMethod;
	}

	/**
	 * @return the shutdownMethod
	 */
	public String getShutdownMethod() {
		return shutdownMethod;
	}

	/**
	 * @param shutdownMethod the shutdownMethod to set
	 */
	public void setShutdownMethod(String shutdownMethod) {
		this.shutdownMethod = shutdownMethod;
	}

}