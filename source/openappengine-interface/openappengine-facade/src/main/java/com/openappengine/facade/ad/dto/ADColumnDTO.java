/**
 * 
 */
package com.openappengine.facade.ad.dto;

import org.apache.commons.lang.Validate;


/**
 * @author hrishi
 *
 */
public class ADColumnDTO {
	
	private String name;
	
	private String description;
	
	private String helpText;
	
	private String columnName;
	
	private boolean key;
	
	private boolean mandatory;
	
	private boolean updateable;
	
	private boolean selectionColumn;
	
	public ADColumnDTO(String columnName) {
		super();
		this.columnName = columnName;
		Validate.notEmpty(columnName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHelpText() {
		return helpText;
	}

	public void setHelpText(String helpText) {
		this.helpText = helpText;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public boolean isKey() {
		return key;
	}

	public void setKey(boolean key) {
		this.key = key;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public boolean isUpdateable() {
		return updateable;
	}

	public void setUpdateable(boolean updateable) {
		this.updateable = updateable;
	}

	public boolean isSelectionColumn() {
		return selectionColumn;
	}

	public void setSelectionColumn(boolean selectionColumn) {
		this.selectionColumn = selectionColumn;
	}

}