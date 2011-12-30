/**
 * 
 */
package com.openappengine.facade.ui.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.model.FieldReference;

/**
 * @author hrishikesh.joshi
 * @Dec 15, 2011
 */
public class FieldLayout implements Serializable {

	private static final long serialVersionUID = 1L;

	private int columns;
	
	private List<FieldReference> fieldReferences = new ArrayList<FieldReference>();
	
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

	public List<FieldReference> getFieldReferences() {
		return fieldReferences;
	}

	public void setFieldReferences(List<FieldReference> fieldReferences) {
		this.fieldReferences = fieldReferences;
	}
}
