/**
 * 
 */
package com.openappengine.gui.engine.core.widget.control;


/**
 * @author hrishikesh.joshi
 * @since  Feb 24, 2012
 *
 */
public class SelectOption extends WidgetControl {

	private static final long serialVersionUID = 1L;
	
	private String label;
	
	private String value;

	@Override
	public String getComponentType() {
		return "select-option";
	}

	@Override
	public String getComponentName() {
		return "select-option";
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String labelId) {
		this.label = labelId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
