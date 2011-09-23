/**
 * 
 */
package com.openappengine.bpm.scxml.model;

import java.io.Serializable;

/**
 * @author hrishikesh.joshi
 *
 */
public class TriggerEvent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
     * <code>CALL_EVENT</code>.
     */
    public static final int CALL_EVENT = 1;

    /**
     * <code>CHANGE_EVENT</code>.
     *
     */
    public static final int CHANGE_EVENT = 2;

    /**
     * <code>SIGNAL_EVENT</code>.
     *
     */
    public static final int SIGNAL_EVENT = 3;

    /**
     * <code>TIME_EVENT</code>.
     *
     */
    public static final int TIME_EVENT = 4;

    /**
     * <code>ERROR_EVENT</code>.
     *
     */
    public static final int ERROR_EVENT = 5;
	
	private String name;
	
	private int type;
	
	private Object payload;
	
	public TriggerEvent(String name, int type, Object payload) {
		super();
		this.name = name;
		this.type = type;
		this.payload = payload;
	}
	
	public TriggerEvent(String name, int type) {
		super();
		this.name = name;
		this.type = type;
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

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

}
