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

    private String formName;

    public Serializable getEntityId() {
	return entityId;
    }

    public void setEntityId(Serializable entityId) {
	this.entityId = entityId;
    }

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

}
