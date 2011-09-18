/**
 * 
 */
package com.openappengine.serviceengine.config;

import java.io.File;

/**
 * @author hrishi
 *
 */
public class ServiceConfig {
	
	/* Service Config Location */
	private String configLocation;
	
	/* Aggregate Name */
	private String aggregateName;
	
	
	private File resourceLocation;
	
	/**
	 * @return the configLocation
	 */
	public String getConfigLocation() {
		return configLocation;
	}

	/**
	 * @param configLocation the configLocation to set
	 */
	public void setConfigLocation(String configLocation) {
		this.configLocation = configLocation;
	}

	public void setAggregateName(String aggregateName) {
		this.aggregateName = aggregateName;
	}

	public String getAggregateName() {
		return aggregateName;
	}

	/**
	 * @param resourceLocation the resourceLocation to set
	 */
	public void setResourceLocation(File resourceLocation) {
		this.resourceLocation = resourceLocation;
	}

	/**
	 * @return the resourceLocation
	 */
	public File getResourceLocation() {
		return resourceLocation;
	}

}
