/**
 * 
 */
package com.ms.openapps.service.context;

import com.ms.openapps.entity.IGenericEntityDelegator;
import com.ms.openapps.service.dispatcher.IServiceDispatcher;

/**
 * @author hrishi
 *
 */
public class DispatchContext {
	
	private IGenericEntityDelegator genericEntityDelegator;
	
	private IServiceDispatcher serviceDispatcher;

	/**
	 * @param genericEntityDelegator
	 * @param serviceDispatcher
	 */
	public DispatchContext(IGenericEntityDelegator genericEntityDelegator,
			IServiceDispatcher serviceDispatcher) {
		this.genericEntityDelegator = genericEntityDelegator;
		this.serviceDispatcher = serviceDispatcher;
	}

	/**
	 * @param genericEntityDelegator the genericEntityDelegator to set
	 */
	public void setGenericEntityDelegator(IGenericEntityDelegator genericEntityDelegator) {
		this.genericEntityDelegator = genericEntityDelegator;
	}

	/**
	 * @return the genericEntityDelegator
	 */
	public IGenericEntityDelegator getGenericEntityDelegator() {
		return genericEntityDelegator;
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
