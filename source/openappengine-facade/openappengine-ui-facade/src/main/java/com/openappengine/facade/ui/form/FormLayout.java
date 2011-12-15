/**
 * 
 */
package com.openappengine.facade.ui.form;

import java.io.Serializable;

/**
 * @author hrishikesh.joshi
 * @Dec 15, 2011
 */
public class FormLayout implements Serializable {

	private static final long serialVersionUID = 1L;

	private int columns;
	
	private static FormLayout defaultLayout;
	
	/**
	 * @return {@link FormLayout}
	 */
	public static FormLayout getDefault() {
		defaultLayout = new FormLayout();
		defaultLayout.setColumns(2);
		return defaultLayout;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
}
