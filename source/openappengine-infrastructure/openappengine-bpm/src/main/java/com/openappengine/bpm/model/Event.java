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
	 * 	Signal Event.
	 */
	public static final int SIGNAL_EVENT = 1;
	
	/**
	 *  The event name
	 */
	private String name;
	
	/**
	 *  The event type;
	 */
	private int type = SIGNAL_EVENT;
	
	public Event(String name) {
		super();
		this.name = name;
	}
	
	public Event(String name, int type) {
		super();
		this.name = name;
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + type;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", type=" + type + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
