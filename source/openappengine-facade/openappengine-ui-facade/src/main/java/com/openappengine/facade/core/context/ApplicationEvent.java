/**
 * 
 */
package com.openappengine.facade.core.context;

import java.util.EventObject;

/**
 * @author hrishikesh.joshi
 * @since Jan 4, 2012
 */
public abstract class ApplicationEvent<T> extends EventObject {

	private static final long serialVersionUID = 1L;
	
	public ApplicationEvent(T source) {
		super(source);
	}

	@Override
	public T getSource() {
		return (T) super.getSource();
	}
	
}
