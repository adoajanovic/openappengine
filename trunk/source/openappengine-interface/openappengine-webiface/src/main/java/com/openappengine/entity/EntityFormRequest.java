/**
 * 
 */
package com.openappengine.entity;

import java.io.Serializable;

/**
 * @author hrishi
 * 
 */
public class EntityFormRequest {

    private Serializable entityId;

    private String entityName;

    public String getEntityName() {
	return entityName;
    }

    public void setEntityName(String entityName) {
	this.entityName = entityName;
    }

    public Serializable getEntityId() {
	return entityId;
    }

    public void setEntityId(Serializable entityId) {
	this.entityId = entityId;
    }

}
