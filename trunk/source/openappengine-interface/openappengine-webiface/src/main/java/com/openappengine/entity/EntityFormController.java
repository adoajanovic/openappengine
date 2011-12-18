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
import com.openappengine.facade.ui.context.UIFacadeContext;
import com.openappengine.facade.ui.facade.FormFacade;
import com.openappengine.facade.ui.form.instance.FormInstance;
import com.openappengine.web.annotations.PreRenderView;

/**
 * @author hrishi
 * 
 */
public class EntityFormController implements Serializable {

	private static final long serialVersionUID = 1L;

	protected final Logger logger = Logger.getLogger(getClass());

	public static final String ACTION_SAVE_OR_UPDATE = "ACTION_SAVE_OR_UPDATE";

	public static final String ACTION_SAVE = "ACTION_SAVE";
	
	private EntityFormRequest entityFormRequest;

	private EntityFacade entityFacade = EntityFacadeContext.getEntityFacade();
	
	protected FormFacade formFacade = UIFacadeContext.getUIFacade();
	
	private FormInstance formInstance;

	/**
	 * Entity Form Per-View Listener
	 */
	private EntityFormPhaseListener entityFormPhaseListener;

	public EntityFormController() {
		registerEntityFormLifecycleListener();
		entityFormRequest = new EntityFormRequest();
	}

	protected void registerEntityFormLifecycleListener() {
		setEntityFormPhaseListener(new EntityFormPhaseListener(this));
	}

	@PreRenderView
	public void processRequestParameters() {
		formInstance = formFacade.getFormInstance(entityFormRequest.getFormName(), entityFormRequest.getEntityId());
	}

	public void processEntityAction(ActionEvent actionEvent) {
		if (actionEvent == null) {
			return;
		}
		String action = (String) actionEvent.getComponent().getAttributes().get("ACTION");
		//TODO - Use an ActionDelegator to perform these actions according to the configuration.
		if (ACTION_SAVE_OR_UPDATE.equalsIgnoreCase(action)) {
			Object instance = formInstance.getEntityValue().getInstance();
			logger.info("Saving the EntityValue : " + instance);
			EntityValue entityValue = (EntityValue) entityFacade.saveEntityValue(formInstance.getEntityValue());
			formInstance.setEntityValue(entityValue);
		}

	}

	public void setEntityFacade(EntityFacade entityFacade) {
		this.entityFacade = entityFacade;
	}

	public EntityFormPhaseListener getEntityFormPhaseListener() {
		return entityFormPhaseListener;
	}

	protected void setEntityFormPhaseListener(EntityFormPhaseListener entityFormPhaseListener) {
		this.entityFormPhaseListener = entityFormPhaseListener;
	}

	public FormInstance getFormInstance() {
		return formInstance;
	}

	public void setFormInstance(FormInstance formInstance) {
		this.formInstance = formInstance;
	}

	public EntityFormRequest getEntityFormRequest() {
		return entityFormRequest;
	}

	public void setEntityFormRequest(EntityFormRequest entityFormRequest) {
		this.entityFormRequest = entityFormRequest;
	}

}
