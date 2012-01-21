/**
 * 
 */
package com.openappengine.facade.core.component.condition;

import java.util.List;

import com.openappengine.facade.core.component.GuiComponent;

/**
 * @author hrishi
 * since Jan 21, 2012
 */
public class ConditionComponent implements GuiComponent {

	private static final long serialVersionUID = 1L;
	
	private String condition;

	@Override
	public String getComponentType() {
		return "condition";
	}

	@Override
	public String getComponentName() {
		return "condition";
	}

	@Override
	public boolean hasChildren() {
		return false;
	}

	@Override
	public List<GuiComponent> getChildComponents() {
		return null;
	}

	@Override
	public String getId() {
		return null;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
