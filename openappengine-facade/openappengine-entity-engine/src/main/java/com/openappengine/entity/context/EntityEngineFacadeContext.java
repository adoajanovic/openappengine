package com.openappengine.entity.context;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.openappengine.entity.EntityEngineFacade;
import com.openappengine.entity.model.ModelEntityFactory;
/**
 * @author hrishi
 *
 */
public class EntityEngineFacadeContext implements ApplicationContextAware {
	
	private static final String MODEL_ENTITY_FACTORY = "modelEntityFactory";

	private static final String DEFAULT_FIELD_TYPES = "defaultFieldTypes";
	
	private static ApplicationContext context;
    
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    	EntityEngineFacadeContext.context = applicationContext;
    }
    
    public static EntityEngineFacade getEntityFacade() {
    	checkIfEntityEngineIsRunning();
    	return (EntityEngineFacade) context.getBean("entityFacade");
    }

	/**
	 * 
	 */
	private static void checkIfEntityEngineIsRunning() {
		if(context == null) {
    		throw new IllegalStateException("EntityEngine has not been initialized.");
    	}
	}
	
  public static ModelEntityFactory getModelEntityFactory() {
    	checkIfEntityEngineIsRunning();
    	return context.getBean(MODEL_ENTITY_FACTORY, ModelEntityFactory.class);
    }
    
    public static Map<String,String> getDefaultFieldTypeMap() {
    	checkIfEntityEngineIsRunning();
    	return context.getBean(DEFAULT_FIELD_TYPES, Map.class);
    }
}
