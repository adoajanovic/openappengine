/**
 * 
 */
package com.openappengine.entity;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import com.openappengine.facade.entity.EntityFacade;
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

	private EntityForm entityForm;

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
		entityForm = new EntityForm();
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
		if (ACTION_SAVE_OR_UPDATE.equalsIgnoreCase(action)) {
			Object instance = entityForm.getEntityValue().getInstance();
			logger.info("Saving the EntityValue : " + instance);
			entityFacade.saveEntityValue(entityForm.getEntityValue());
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

	public EntityForm getEntityForm() {
		return entityForm;
	}

	public void setEntityForm(EntityForm entityForm) {
		this.entityForm = entityForm;
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
