/**
 * 
 */
package com.openappengine.entity;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import com.openappengine.facade.entity.EntityFacade;
import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.entity.context.EntityFacadeContext;
import com.openappengine.web.annotations.PreRenderView;
import com.openappengine.web.render.RenderMode;

/**
 * @author hrishi
 * 
 */
public class EntityFormController implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean formRendered;
    
    private String entityName;
    
    private Integer entityId;
    
    private EntityValue entityValue;
    
    protected final Logger logger = Logger.getLogger(getClass());
    
    private EntityFacade entityFacade = EntityFacadeContext.getEntityFacade();
    
    public static final String ACTION_SAVE_OR_UPDATE = "ACTION_SAVE_OR_UPDATE";
    
    public static final String ACTION_SAVE = "ACTION_SAVE";
    
    private RenderMode renderMode;
    
    private EntityFormPhaseListener entityFormPhaseListener;
    
    public EntityFormController() {
    	registerEntityFormLifecycleListener();
    	setDefaultRenderMode();
    	//processRequestParameters();
    }

	protected void registerEntityFormLifecycleListener() {
		setEntityFormPhaseListener(new EntityFormPhaseListener(this));
	}

	protected void setDefaultRenderMode() {
		setRenderMode(new RenderMode(RenderMode.READ_WRITE));
	}

	@PreRenderView
	public void processRequestParameters() {
		entityValue = entityFacade.createEntityValue(entityName, entityId);
		renderMode.changeToReadOnlyMode();
	}

	public void performPreRenderActions() {
		if (!isFormRendered()) {
			// TODO
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
		if (actionEvent == null) {
			return;
		}
		String action = (String) actionEvent.getComponent().getAttributes().get("ACTION");
		if (ACTION_SAVE_OR_UPDATE.equalsIgnoreCase(action)) {
			// TODO
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

	public RenderMode getRenderMode() {
		return renderMode;
	}

	public void setRenderMode(RenderMode renderMode) {
		this.renderMode = renderMode;
	}

	public EntityFormPhaseListener getEntityFormPhaseListener() {
		return entityFormPhaseListener;
	}

	protected void setEntityFormPhaseListener(EntityFormPhaseListener entityFormPhaseListener) {
		this.entityFormPhaseListener = entityFormPhaseListener;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}
    
}
