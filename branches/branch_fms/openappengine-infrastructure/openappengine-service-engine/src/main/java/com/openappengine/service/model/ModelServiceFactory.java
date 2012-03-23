/**
 * 
 */
package com.openappengine.service.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hrishikesh.joshi
 * @since  Mar 13, 2012
 *
 */
public class ModelServiceFactory {
	
	private ModelServiceReader modelServiceReader;
	
	private Map<String, ModelService> modelServiceMap = new HashMap<String, ModelService>();
	
	private String[] locations;
	
	public void initialize() {
		modelServiceReader.initializeFactory(locations, this);
	}
	
	public ModelService getModelService(String serviceName) {
		return modelServiceMap.get(serviceName);
	}
	
	public void registerModelService(ModelService modelService) {
		if(modelService == null) {
			return;
		}
		this.modelServiceMap.put(modelService.getName(), modelService);
	}

	public void setModelServiceReader(ModelServiceReader modelServiceReader) {
		this.modelServiceReader = modelServiceReader;
	}

	public void setLocations(String[] locations) {
		this.locations = locations;
	}

}
