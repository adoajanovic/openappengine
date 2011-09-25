/**
 * 
 */
package com.openappengine.bpm.model;

/**
 * @author hrishikesh.joshi
 *
 */
public class Transition {
	
	/* A comma-seperated list of possible events */
	private String event;

	/* A Boolean Expression -- Guard Condition */
	private String condition = "true";
	
	private String action;
	
	/* Target State - Target Event to */ 
	private String target;
	
	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
