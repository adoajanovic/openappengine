/**
 * 
 */
package com.openappengine.facade.ui.facade;

import java.io.Serializable;

import com.openappengine.facade.ui.form.FormDefinition;
import com.openappengine.facade.ui.form.instance.FormInstance;

/**
 * @author hrishikesh.joshi
 * @Dec 15, 2011
 */
public interface FormFacade extends Serializable {

	/**
	 * @param name
	 * @return FormDefinition
	 */
	FormDefinition getFormDefinition(String name);
	
	/**
	 * @param formName
	 * @return {@link FormInstance}
	 */
	FormInstance getFormInstance(String formName);
	
	/**
	 * @param formName
	 * @param entityId
	 * @return
	 */
	FormInstance getFormInstance(String formName,Serializable entityId);
}