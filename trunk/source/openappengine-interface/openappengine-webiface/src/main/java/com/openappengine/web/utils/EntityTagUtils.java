/**
 * 
 */
package com.openappengine.web.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.openappengine.facade.entity.EntityFacade;
import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.entity.context.EntityFacadeContext;
import com.openappengine.facade.entity.definition.EntityDefinition;
import com.openappengine.web.exception.ComponentRenderException;

/**
 * @author hrishi
 *
 */
public class EntityTagUtils {
    
    private final Logger logger = Logger.getLogger(getClass());
    
    private static EntityFacade entityFacade = EntityFacadeContext.getEntityFacade();
    
    public EntityValue createEntityValue(String entityName) {
   	logger.info("Creating EntityValue");
   	System.out.println("aasasas");
   	if(StringUtils.isEmpty(entityName)) {
   	    throw new ComponentRenderException("Entity Name cannot be empty.");
   	}
   	EntityValue entityValue = entityFacade.createEntityValue(entityName);
   	return entityValue;
    }

    public static EntityDefinition getEntityDefinition(String entityName) {
	return entityFacade.findEntityDefinition(entityName);
    }
}
