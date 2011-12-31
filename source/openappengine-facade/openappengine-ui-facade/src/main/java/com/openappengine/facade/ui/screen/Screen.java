/**
 * 
 */
package com.openappengine.facade.ui.screen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.core.executor.action.PreActionHandler;
import com.openappengine.facade.core.variable.Variable;
import com.openappengine.facade.fsm.Node;
import com.openappengine.facade.fsm.ScreenTransitionEventListener;
import com.openappengine.facade.fsm.Transition;
import com.openappengine.facade.fsm.TransitionEvent;
import com.openappengine.facade.fsm.TransitionEventListener;
import com.openappengine.facade.ui.params.Param;
import com.openappengine.facade.ui.params.Parameters;
import com.openappengine.facade.ui.widgets.SubScreen;
import com.openappengine.facade.ui.widgets.Widget;
import com.openappengine.facade.ui.widgets.container.ContainerPanel;

/**
 * @author hrishikesh.joshi
 * @Dec 21, 2011
 */
public class Screen implements Node {

	private ContainerPanel containerPanel;
	
	private SubScreen activeSubScreen;
	
	private Map<String, Widget> containerWidgetMap = new HashMap<String, Widget>();
	
	private Parameters screenParameters = new Parameters();
	
	private Map<String,Variable> variableMap = new HashMap<String, Variable>();
	
	private PreActionHandler preActionHandler;
	
	private List<Transition> transitions;
	
	private TransitionEventListener listener = new ScreenTransitionEventListener(this); 
	
	public ContainerPanel getContainerPanel() {
		return containerPanel;
	}

	public void setContainerPanel(ContainerPanel containerPanel) {
		this.containerPanel = containerPanel;
	}

	public SubScreen getActiveSubScreen() {
		return activeSubScreen;
	}

	public void setActiveSubScreen(SubScreen activeSubScreen) {
		this.activeSubScreen = activeSubScreen;
	}

	public Map<String, Widget> getContainerWidgetMap() {
		return containerWidgetMap;
	}

	public void setContainerWidgetMap(Map<String, Widget> containerWidgetMap) {
		this.containerWidgetMap = containerWidgetMap;
	}

	public void addWidget(String containerId, Widget widget) {
		if(StringUtils.isEmpty(containerId) || widget == null) {
			return;
		}
		
		this.containerWidgetMap.put(containerId, widget);
	}

	public Parameters getScreenParameters() {
		return screenParameters;
	}

	public void setScreenParameters(Parameters screenParameters) {
		this.screenParameters = screenParameters;
	}
	
	public void addScreenParameter(Param param,Object value) {
		if(param == null) {
			return;
		}
		
		screenParameters.setParam(param, value);
	}

	public PreActionHandler getPreActionHandler() {
		return preActionHandler;
	}

	public void setPreActionHandler(PreActionHandler preActionHandler) {
		this.preActionHandler = preActionHandler;
	}
	
	//Implementations of a Node.
	@Override
	public Collection<Variable> getNodeVariables() {
		return variableMap.values();
	}

	@Override
	public List<Transition> getTransitions() {
		return getTransitions();
	}

	@Override
	public List<Transition> getTransitionsListeningToEvent(TransitionEvent event) {
		if(transitions == null || event == null) {
			return null;
		}
		
		final List<Transition> transitionsListeningToEvent = new ArrayList<Transition>();
		String eventName = event.getEventName();
		for(Transition t : getTransitions()) {
			if(StringUtils.equals(eventName, t.getName())) {
				transitionsListeningToEvent.add(t);
			}
		}
		
		return transitionsListeningToEvent;
	}

	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}
	
	public Map<String,Variable> getVariableMap() {
		return variableMap;
	}
	
	public Collection<Variable> getScreenVariables() {
		return variableMap.values();
	}

	public void putVariable(String variableName, Object object) {
		if (!StringUtils.isEmpty(variableName) && object != null) {
			Variable value = new Variable();
			value.setName(variableName);
			value.setValue(object);
			this.variableMap.put(variableName, value);
		}
	}
	
	public Object getVariable(String name) {
		if(StringUtils.isEmpty(name)) {
			return null;
		}
		
		Variable variable = variableMap.get(name);
		if(variable != null) {
			return variable.getValue();
		}
		
		return null;
	}

}