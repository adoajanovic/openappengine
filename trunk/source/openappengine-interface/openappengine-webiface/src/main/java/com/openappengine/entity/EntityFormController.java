/**
 * 
 */
package com.openappengine.entity;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.openappengine.facade.entity.EntityFacade;
import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.entity.context.EntityFacadeContext;

/**
 * @author hrishi
 * 
 */
public class EntityFormController implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean formRendered;
    
    private String entityName;
    
    private EntityValue entityValue;
    
    protected Logger logger = Logger.getLogger(getClass());
    
    private EntityFacade entityFacade = EntityFacadeContext.getEntityFacade();
    
    public static final String SAVE_OR_UPDATE = "SAVE_OR_UPDATE";
    
    public static final String SAVE = "SAVE";
    
    public EntityFormController() {
	processRequestParameters();
    }

    private void processRequestParameters() {
	String entityName = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("entityName");
	if(!StringUtils.isEmpty(entityName)) {
	    this.entityName = entityName; 
	    
	    String entityId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("entityId");
	    Integer id = null;
	    if(!StringUtils.isEmpty(entityId)) {
		id = Integer.parseInt(entityId);
	    }
	    entityValue = entityFacade.createEntityValue(entityName,id);
	    setFormRendered(true);
	}
	
    }

    public void performPreRenderActions() {
	
	if (!isFormRendered()) {
	    //TODO
	    setFormRendered(true);
	}
    }

    public boolean isFormRendered() {
	return formRendered;
    }

    public void setFormRendered(boolean formRendered) {
	this.formRendered = formRendered;
    }
    
    public EntityValue getEntityValue() {
	return entityValue;
    }

    public void setEntityValue(EntityValue entityValue) {
	this.entityValue = entityValue;
    }
    
    public void processEntityAction(ActionEvent actionEvent) {
	
	if(actionEvent == null) {
	    return;
	}
	String action = (String) actionEvent.getComponent().getAttributes().get("ACTION");
	if(SAVE_OR_UPDATE.equalsIgnoreCase(action)) {
	    //TODO 
	    Object instance = entityValue.getInstance();
	    logger.info("Saving the EntityValue : " + instance);
	    entityFacade.saveEntityValue(entityValue);
	}
    }

    public void setEntityFacade(EntityFacade entityFacade) {
	this.entityFacade = entityFacade;
    }

    public String getEntityName() {
	return entityName;
    }

    public void setEntityName(String entityName) {
	this.entityName = entityName;
    }
    
}
