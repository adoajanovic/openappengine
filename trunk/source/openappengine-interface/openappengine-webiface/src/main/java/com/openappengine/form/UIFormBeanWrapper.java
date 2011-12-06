/**
 * 
 */
package com.openappengine.form;

import com.openappengine.data.DataBeanWrapper;

/**
 * @author hrishikesh.joshi
 *
 */
public class UIFormBeanWrapper extends DataBeanWrapper {

	public Object formBean;
	
	/**
	 * @param object
	 */
	public UIFormBeanWrapper(Object object) {
		super(object);
		this.formBean = object;
	}

	public Object getFormBean() {
		return formBean;
	}

	public void setFormBean(Object formBean) {
		this.formBean = formBean;
	}

}
