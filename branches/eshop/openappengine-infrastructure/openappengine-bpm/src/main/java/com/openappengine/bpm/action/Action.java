/**
 * 
 */
package com.openappengine.bpm.action;

/**
 * @author hrishi
 *
 */
public class Action {
	
	private Class<?> src;
	
	private boolean async = false;
	
	private String name;
	
	public Action(Class<?> src) {
		super();
		this.src = src;
	}

	public boolean isAsync() {
		return async;
	}

	public void setAsync(boolean async) {
		this.async = async;
	}

	/**
	 * @return the src
	 */
	public Class<?> getSrc() {
		return src;
	}

	/**
	 * @param src the src to set
	 */
	public void setSrc(Class<?> src) {
		this.src = src;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
