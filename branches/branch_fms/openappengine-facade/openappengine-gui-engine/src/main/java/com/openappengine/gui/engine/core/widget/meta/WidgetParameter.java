/**
 * 
 */
package com.openappengine.gui.engine.core.widget.meta;

/**
 * @author hrishi
 * since Feb 26, 2012
 */
public class WidgetParameter {
	
	private String name;
	
	private String xpath;
	
	private String textValue;
	
	private boolean mandatory;
	
	private String defaultValue;
	
	void setTextValue(String value) {
		this.textValue = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public String getTextValue() {
		return textValue;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
}
