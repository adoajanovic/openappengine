/**
 * 
 */
package com.openappengine.entity;

import java.io.Serializable;

import com.openappengine.facade.entity.EntityValue;

/**
 * @author hrishi
 *
 */
public class EntityForm {
    
    private Serializable id;
    
    private EntityValue entityValue;
    
    private String entityName;

    public EntityValue getEntityValue() {
        return entityValue;
    }

    public void setEntityValue(EntityValue entityValue) {
        this.entityValue = entityValue;
    }

    public Serializable getId() {
        return id;
    }

    public void setId(Serializable id) {
        this.id = id;
    }

    public String getEntityName() {
	return entityName;
    }

    public void setEntityName(String entityName) {
	this.entityName = entityName;
    }

}
