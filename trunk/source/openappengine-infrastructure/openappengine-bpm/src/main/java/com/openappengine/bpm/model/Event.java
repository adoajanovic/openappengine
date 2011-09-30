/**
 * 
 */
package com.openappengine.bpm.model;

/**
 * @author hrishikesh.joshi
 *
 */
public class Event {
	
	/**
	 *  The event name
	 */
	private String name;
	
	public Event(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
