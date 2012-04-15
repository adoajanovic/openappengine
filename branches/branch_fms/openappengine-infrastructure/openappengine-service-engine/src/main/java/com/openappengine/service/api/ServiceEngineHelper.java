/**
 * 
 */
package com.openappengine.service.api;

import org.springframework.util.Assert;

import com.openappengine.service.AbstractDomainService;

/**
 * @author hrishi
 *
 */
public class ServiceEngineHelper {
	
	public static void addErrorMessage(AbstractDomainService service,String errorMessage) {
		Assert.notNull(service, "Service cannot be null.");
		service.addErrorMessage(errorMessage);
	}

}
