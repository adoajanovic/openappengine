/**
 * 
 */
package com.openappengine.gui.web.support;

import javax.servlet.ServletRequest;

import org.springframework.web.bind.ServletRequestDataBinder;

/**
 * @author hrishi
 * since Jan 15, 2012
 */
public class GuiFormDataBinder extends ServletRequestDataBinder {
	
	private Class<?> formBackingClass;
	
	/**
	 * @param target
	 * @param formBackingClass
	 */
	public GuiFormDataBinder(Object target, Class<?> formBackingClass) {
		super(target);
		this.formBackingClass = formBackingClass;
	}

	/**
	 * @param target
	 * @param objectName
	 */
	public GuiFormDataBinder(Object target, String objectName) {
		super(target, objectName);
	}

	public Class<?> getFormBackingClass() {
		return formBackingClass;
	}

	protected void setFormBackingClass(Class<?> formBackingClass) {
		this.formBackingClass = formBackingClass;
	}

	@Override
	public void bind(ServletRequest request) {
		super.bind(request);
	}

}
