/**
 * 
 */
package com.openappengine.serviceengine.context;

import com.openappengine.serviceengine.dispatcher.IServiceDispatcher;

/**
 * @author hrishi
 *
 */
public class DispatchContext {
	
	private IServiceDispatcher serviceDispatcher;
	
	/**
	 * @param genericEntityDelegator
	 * @param serviceDispatcher
	 */
	public DispatchContext(IServiceDispatcher serviceDispatcher) {
		this.serviceDispatcher = serviceDispatcher;
	}

	/**
	 * @param serviceDispatcher the serviceDispatcher to set
	 */
	public void setServiceDispatcher(IServiceDispatcher serviceDispatcher) {
		this.serviceDispatcher = serviceDispatcher;
	}

	/**
	 * @return the serviceDispatcher
	 */
	public IServiceDispatcher getServiceDispatcher() {
		return serviceDispatcher;
	}

}
