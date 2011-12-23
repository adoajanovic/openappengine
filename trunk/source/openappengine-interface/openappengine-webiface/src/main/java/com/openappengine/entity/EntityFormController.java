/**
 * 
 */
package com.openappengine.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.openappengine.facade.entity.EntityFacade;
import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.entity.context.EntityFacadeContext;
import com.openappengine.facade.entity.definition.FieldDefinition;
import com.openappengine.facade.ui.context.UIFacadeContext;
import com.openappengine.facade.ui.facade.FormFacade;
import com.openappengine.facade.ui.form.instance.FormInstance;
import com.openappengine.facade.ui.widgets.container.Container;
import com.openappengine.facade.ui.widgets.container.ContainerPanel;
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
	
	private String state = "draft";
	
	private EntityFacade entityFacade = EntityFacadeContext.getEntityFacade();
	
	protected FormFacade formFacade = UIFacadeContext.getUIFacade();
	
	//TODO - Change to Simple Form or accessed from Screen.
	private FormInstance formInstance;
	
	private ContainerPanel containerPanel = new ContainerPanel();

	/**
	 * Entity Form Per-View Listener
	 */
	private EntityFormPhaseListener entityFormPhaseListener;

	public EntityFormController() {
		registerEntityFormLifecycleListener();
	}

	protected void registerEntityFormLifecycleListener() {
		setEntityFormPhaseListener(new EntityFormPhaseListener(this));
	}

	@PreRenderView
	public void processRequestParameters() {
		if(state.equals("draft")) {
			Map<String, String> requestParameterMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			Map<String,Object> entityRequestParams = new HashMap<String, Object>();
			if(requestParameterMap != null) {
				String formName = requestParameterMap.get("formName");
				formInstance = formFacade.getFormInstance(formName);
				
				Set<String> requestParams = requestParameterMap.keySet();
				for (String requestParam : requestParams) {
					if(formInstance.getFieldDefinition(requestParam) != null) {
						FieldDefinition fieldDefinition = formInstance.getFieldDefinition(requestParam);
						entityRequestParams.put(fieldDefinition.getName(), requestParameterMap.get(requestParam));
					}
				}
				
				if(!entityRequestParams.isEmpty()) {
					formInstance = formFacade.getFormInstance(formName, entityRequestParams);
				}
				
				//TODO - Read the widgets from XML.
				Container centerPanel = new Container();
				centerPanel.addWidget(formInstance);
				containerPanel.setCenterPanel(centerPanel);
			}
			state= "modified";
		}
	}

	public String formSubmit() {
		Object instance = formInstance.getEntityValue().getInstance();
		logger.info("Saving the EntityValue : " + instance);
		EntityValue entityValue = (EntityValue) entityFacade.saveEntityValue(formInstance.getEntityValue());
		formInstance.setEntityValue(entityValue);
		
		List<FieldDefinition> pkFields = entityValue.getEntityDefinition().getPKFields();
		StringBuffer sb = new StringBuffer();
		
		Iterator<FieldDefinition> iterator = pkFields.iterator();
		boolean hasNext = iterator.hasNext();
		while(hasNext) {
			FieldDefinition pkField = iterator.next();
			sb.append(pkField.getName() + "=" + entityValue.get(pkField.getName()));
			
			hasNext = iterator.hasNext();
			if(hasNext) {
				sb.append("&");
			}
		}
		
	    //TODO - Move to a delegate/NavigationHandler.
		String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		viewId += "?faces-redirect=true&formName="+formInstance.getFormDefinition().getName();
		viewId += "&" + sb.toString();
		return viewId;
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

	public ContainerPanel getContainerPanel() {
		return containerPanel;
	}

	public void setContainerPanel(ContainerPanel containerPanel) {
		this.containerPanel = containerPanel;
	}

}
