/**
 * 
 */
package com.openappengine.facade.core.component.ui;
import java.util.Map;

import com.openappengine.facade.core.component.AbstractGuiComponent;
import com.openappengine.facade.core.component.executable.PreActionsComponent;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.variable.Variable;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class GuiRootComponent extends AbstractGuiComponent {

	private static final long serialVersionUID = 1L;
	
	private GuiApplicationContext context;
	
	private PreActionsComponent preActions;
	
	private Map<String, Variable> screenVariables;
	
	@Override
	public String getComponentType() {
		return "root-container";
	}

	@Override
	public String getComponentName() {
		return "screen";
	}
	
	public Map<String, Variable> getScreenVariables() {
		return screenVariables;
	}

	public PreActionsComponent getPreActions() {
		return preActions;
	}

	public void setPreActions(PreActionsComponent preActions) {
		this.preActions = preActions;
	}

	public void setScreenVariables(Map<String, Variable> screenVariables) {
		this.screenVariables = screenVariables;
	}

	protected GuiApplicationContext getContext() {
		return context;
	}

	public void setContext(GuiApplicationContext context) {
		this.context = context;
	}

	public boolean isPreActionConfigured() {
		return (preActions != null && preActions.getExecutable() != null);
	}
}
