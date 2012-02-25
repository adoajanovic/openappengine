/**
 * 
 */
package com.openappengine.gui.engine.core.component.ui;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;

import com.openappengine.gui.engine.core.component.AbstractGuiComponent;
import com.openappengine.gui.engine.core.component.GuiComponent;
import com.openappengine.gui.engine.core.component.executable.PreRenderActions;
import com.openappengine.gui.engine.core.component.transition.TransitionComponent;
import com.openappengine.gui.engine.core.component.ui.container.PageContentComponent;
import com.openappengine.gui.engine.core.component.ui.container.WidgetContainer;
import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.variable.Variable;
import com.openappengine.gui.engine.fsm.Node;
import com.openappengine.gui.engine.fsm.TransitionEvent;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class GuiRootComponent extends AbstractGuiComponent implements Node {

	private static final long serialVersionUID = 1L;
	
	private GuiEngineContext context;
	
	private PreRenderActions preRenderActions;
	
	private PageContentComponent pageContent;
	
	private final List<TransitionComponent> screenTransitions = new ArrayList<TransitionComponent>();
	
	private Map<String, Variable> screenVariables = new ConcurrentHashMap<String, Variable>();
	
	@Override
	public String getComponentType() {
		return "root-container";
	}

	@Override
	public String getComponentName() {
		return "root";
	}
	
	//TODO - Move to GuiEngineContext
	public Map<String, Variable> getScreenVariables() {
		return screenVariables;
	}

	//TODO - Move to GuiEngineContext
	public PreRenderActions getPreRenderActions() {
		return preRenderActions;
	}

	public void setPreRenderActionComponent(PreRenderActions preActions) {
		this.preRenderActions = preActions;
	}

	public void setScreenVariables(Map<String, Variable> screenVariables) {
		this.screenVariables = screenVariables;
	}

	protected GuiEngineContext getContext() {
		return context;
	}

	public void setContext(GuiEngineContext context) {
		this.context = context;
	}
	
	public PageContentComponent getPageContent() {
		return pageContent;
	}

	public void setPageContent(PageContentComponent pageContent) {
		this.pageContent = pageContent;
	}

	public List<TransitionComponent> getScreenTransitions() {
		return screenTransitions;
	}

	public void addScreenTransition(TransitionComponent transition) {
		if(transition == null || screenTransitions.contains(transition)) {
			return;
		}
		
		this.screenTransitions.add(transition);
	}
	
	//Implementations of Node Interface
	@Override
	public Collection<Variable> getNodeVariables() {
		if(screenVariables != null) {
			return screenVariables.values();
		}
		return null;
	}

	@Override
	public List<TransitionComponent> getTransitions() {
		return screenTransitions;
	}

	@Override
	public List<TransitionComponent> getTransitionsListeningToEvent(TransitionEvent event) {
		if(event == null) {
			return null;
		}
		
		String eventName = event.getEventName();
		List<TransitionComponent> transitions = new ArrayList<TransitionComponent>();
		if(screenTransitions != null) {
			for (TransitionComponent transition : screenTransitions) {
				if(StringUtils.equals(eventName, transition.getId())) {
					transitions.add(transition);
				}
			}
		}
		return transitions;
	}
	
}
