/**
 * 
 */
package com.openappengine.form;

import java.io.Serializable;

import com.openappengine.data.DataBeanWrapper;

/**
 * @author hrishikesh.joshi
 *
 */
public class UIFormBeanWrapper extends DataBeanWrapper implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
