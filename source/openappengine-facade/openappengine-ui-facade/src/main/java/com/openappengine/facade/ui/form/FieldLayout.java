/**
 * 
 */
package com.openappengine.facade.ui.form;

import java.io.Serializable;

/**
 * @author hrishikesh.joshi
 * @Dec 15, 2011
 */
public class FieldLayout implements Serializable {

	private static final long serialVersionUID = 1L;

	private int columns;
	
	private static FieldLayout defaultLayout;
	
	/**
	 * @return {@link FieldLayout}
	 */
	public static FieldLayout getDefault() {
		defaultLayout = new FieldLayout();
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
