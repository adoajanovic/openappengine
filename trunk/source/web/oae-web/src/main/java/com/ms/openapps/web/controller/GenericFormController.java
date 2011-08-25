/**
 * 
 */
package com.ms.openapps.web.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @author hrishi
 *
 */
public abstract class GenericFormController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Add High Severity Error Message
	 * 
	 * @param msg
	 */
	protected void addErrorMessage(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
	}
	
	/**
	 * Add Success Message
	 * 
	 * @param msg
	 */
	protected void addSuccessMessage(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
	}

}
