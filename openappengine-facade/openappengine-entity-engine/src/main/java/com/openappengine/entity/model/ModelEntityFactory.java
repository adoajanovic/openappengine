/**
 * 
 */
package com.openappengine.entity.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;


/**
 * A Generic Factory for ModelEntities. This factory has an instance of the {@link ModelReader}
 * which reads the entities from the filestore and registers the ModelEntity with the factory.
 * 
 * @author hrishikesh.joshi
 * @since  Mar 5, 2012
 *
 */
public class ModelEntityFactory {
	
	private Map<String,ModelEntity> modelEntityMap = new HashMap<String, ModelEntity>();
	
	private String[] locations;
	
	private ModelReader modelReader;
	
	//Init Method
	public void initializeFactory() {
		modelReader.readModelEntities(locations, this);
	}

	public ModelEntity getModelEntity(String entityName) {
		if(StringUtils.isEmpty(entityName)) {
			throw new IllegalArgumentException("Entity Name cannot be null.");
		}
		
		if(modelEntityMap.containsKey(entityName)) {
			return modelEntityMap.get(entityName);
		}
		
		return null;
	}
	
	
	public void registerModelEntity(ModelEntity modelEntity) {
		this.modelEntityMap.put(modelEntity.getEntityName(), modelEntity);
	}

	public ModelReader getModelReader() {
		return modelReader;
	}

	public void setModelReader(ModelReader modelReader) {
		this.modelReader = modelReader;
	}

	public void setLocations(String[] locations) {
		this.locations = locations;
	}

}
