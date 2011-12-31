/**
 * 
 */
package com.openappengine.facade.core;

import java.util.Map;

import com.openappengine.facade.core.variable.Variable;
import com.openappengine.facade.ui.params.Parameters;
import com.openappengine.facade.ui.preaction.PreAction;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class XmlScreenUIRoot implements UIRoot {
	
	private Map<String, Variable> screenVariables;
	
	private PreAction preAction;
	
	private Parameters inputParameters;

	@Override
	public Map<String, Variable> getScreenVariables() {
		return screenVariables;
	}

	@Override
	public PreAction getPreAction() {
		return preAction;
	}

	@Override
	public Parameters getInputParameters() {
		return inputParameters;
	}

	public void setScreenVariables(Map<String, Variable> screenVariables) {
		this.screenVariables = screenVariables;
	}

	public void setPreAction(PreAction preAction) {
		this.preAction = preAction;
	}

	public void setInputParameters(Parameters inputParameters) {
		this.inputParameters = inputParameters;
	}

}
