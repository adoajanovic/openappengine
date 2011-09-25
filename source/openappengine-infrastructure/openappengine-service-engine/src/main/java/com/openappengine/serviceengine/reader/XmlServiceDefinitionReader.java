/**
 * 
 */
package com.openappengine.serviceengine.reader;

import com.openappengine.utility.UtilLogger;

/**
 * @author hrishi
 *
 */
public class XmlServiceDefinitionReader {

	private UtilLogger logger = new UtilLogger(getClass());
	
	private String serviceDefLocation = null;
	
	public XmlServiceDefinitionReader(String serviceDefLocation) {
		validateServiceDefLocation(serviceDefLocation);
		this.serviceDefLocation = serviceDefLocation;
	}
	/**
	 * @param serviceDefLocation
	 */
	private void validateServiceDefLocation(String serviceDefLocation) {
		if(serviceDefLocation == null) {
			throw new XmlServiceConfigException("Service Definitions does not exist");
		}
	}
	
	/**
	 * 	Init Method Reads Xml Services for each of the Service
	 */
	public void loadModelServices() {
		XmlServiceConfigReader reader = new XmlServiceConfigReader();
		logger.logInfo("Calling XmlServiceDefinitionReader to load Services");
		reader.loadGenericModelServices(serviceDefLocation);
	}
}