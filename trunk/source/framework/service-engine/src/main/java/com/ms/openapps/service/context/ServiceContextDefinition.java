/**
 * 
 */
package com.ms.openapps.service.context;

import java.util.List;

import com.ms.openapps.service.config.ServiceConfig;

/**
 * @author hrishi
 *
 */
public class ServiceContextDefinition {

	/* Service Configurations */
	private List<ServiceConfig> serviceConfigs;
	
	/**
	 * @param serviceConfigs the serviceConfigs to set
	 */
	public void setServiceConfigs(List<ServiceConfig> serviceConfigs) {
		this.serviceConfigs = serviceConfigs;
	}

	/**
	 * @return the serviceConfigs
	 */
	public List<ServiceConfig> getServiceConfigs() {
		return serviceConfigs;
	}

}
