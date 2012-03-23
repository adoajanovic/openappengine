/**
 * 
 */
package com.openappengine.bpm.event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.openappengine.bpm.action.Action;

/**
 * @author hrishi
 *
 */
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String EVENT_NODE_ENTER = "node-enter";
	
	public static final String EVENT_NODE_LEAVE = "node-leave";
	
	/**
	 *  Event Type. 
	 */
	private String eventType;
	
	/**
	 * 	Actions 
	 */
	private List<Action> actions = new ArrayList<Action>();
	
	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	public void addAction(Action action) {
		if(action == null) {
			return;
		}
		actions.add(action);
	}

	/**
	 * @return the actionHandlers
	 */
	public List<Action> getActions() {
		return actions;
	}

	/**
	 * @param actionHandlers the actionHandlers to set
	 */
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

}
