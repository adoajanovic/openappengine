/**
 * 
 */
package com.openappengine.form.controller;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.openappengine.facade.entity.EntityFacade;
import com.openappengine.facade.entity.EntityValue;

/**
 * @author hrishi
 * 
 */
public class EntityFormController implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean formRendered;
    
    private EntityValue entityValue;
    
    protected Logger logger = Logger.getLogger(getClass());

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
    
    public String performSaveAction() {
	Object instance = entityValue.getInstance();
	logger.info("Saving the EntityValue : " + instance);
	return null;
    }
    
}
