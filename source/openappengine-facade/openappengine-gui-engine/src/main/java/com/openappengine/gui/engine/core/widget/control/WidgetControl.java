/**
 * 
 */
package com.openappengine.gui.engine.core.widget.control;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.gui.engine.core.component.AbstractGuiComponent;
import com.openappengine.gui.engine.core.component.ui.ValueRefAware;

/**
 * @author hrishi
 * since Feb 5, 2012
 */
public class WidgetControl extends AbstractGuiComponent implements ValueRefAware<Object> {

	private static final long serialVersionUID = 1L;
	
	private String path;
	
	private String type;
	
	private boolean hidden; 
	
	private String valueRef;
	
	private Object value;
	
	private List<SelectOption> selectOptions = new ArrayList<SelectOption>();
	
	@Override
	public String getComponentType() {
		return "widget-control";
	}

	@Override
	public String getComponentName() {
		return "widget-control";
	}

	public String getPath() {
		return path;
	}

	public void setPath(String entryName) {
		this.path = entryName;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public String getValueRef() {
		return valueRef;
	}

	public void setValueRef(String valueRef) {
		this.valueRef = valueRef;
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void setValue(Object value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<SelectOption> getSelectOptions() {
		return selectOptions;
	}

	public void setSelectOptions(List<SelectOption> selectOptions) {
		this.selectOptions = selectOptions;
	}
	
	public boolean hasSelectOptions() {
		return !this.selectOptions.isEmpty();
	}

}
