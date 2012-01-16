/**
 * 
 */
package com.openappengine.form.controller;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.openappengine.form.UIForm;
import com.openappengine.form.UIFormBeanWrapper;

/**
 * @author hrishikesh.joshi
 *
 */
public class FormController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected final Logger logger = Logger.getLogger(getClass());
	
	private UIFormBeanWrapper formBean;
	
	private boolean formRendered;
	
	public FormController() {
		logger.debug("FormController initialized.");
	}

	public UIFormBeanWrapper getFormBean() {
		return formBean;
	}

	public void setFormBean(UIFormBeanWrapper formBean) {
		this.formBean = formBean;
	}
	
	public void performPreRenderActions() {
	    if(!isFormRendered()) {
    	    	UIForm uiForm = getWrappedFormBean();
    	    	uiForm.preRenderAction();
    	    	setFormRendered(true);
	    }
	}
	
	public String save() {
		logger.debug("UIForm : Performing Save action");
		UIForm uiForm = getWrappedFormBean();
		return null;
	}

	private UIForm getWrappedFormBean() {
	    UIForm uiform = (UIForm) formBean.getWrappedInstance();
	    return uiform;
	}

	public boolean isFormRendered() {
	    return formRendered;
	}

	public void setFormRendered(boolean formRendered) {
	    this.formRendered = formRendered;
	}
}