/**
 * 
 */
package com.openappengine.entity;

import java.io.Serializable;

import com.openappengine.facade.entity.EntityValue;
import com.openappengine.web.render.RenderMode;

/**
 * @author hrishi
 *
 */
public class EntityForm {
    
    private Serializable id;
    
    private String entityName;
    
    private EntityValue entityValue;
    
    private RenderMode renderMode;
    
    public EntityForm() {
    	setRenderMode(new RenderMode());
    }

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

	public RenderMode getRenderMode() {
		return renderMode;
	}

	public void setRenderMode(RenderMode renderMode) {
		this.renderMode = renderMode;
	}
}
