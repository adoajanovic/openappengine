/**
 * 
 */
package com.openappengine.bpm.action;

/**
 * @author hrishi
 *
 */
public class Action {
	
	private String name;
	
	private Class<?> src;
	
	private boolean async = false;
	
	public Action(String name, Class<?> src) {
		super();
		this.name = name;
		this.src = src;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
