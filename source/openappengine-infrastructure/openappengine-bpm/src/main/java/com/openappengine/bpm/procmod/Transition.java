/**
 * 
 */
package com.openappengine.bpm.procmod;

/**
 * @author hrishikesh.joshi
 *
 */
public class Transition {
	
	/* A comma-seperated list of possible events */
	private String event;

	/* A Boolean Expression -- Guard Condition */
	private String condition = "true";
	
	/* Target State - Target Event to */ 
	private String to;
	
	/**
	 *  Parent state having this as an outgoing transition.
	 */
	private Target parent;
	
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

	public Target getParent() {
		return parent;
	}

	public void setParent(Target parent) {
		this.parent = parent;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}
}
