/**
 * 
 */
package com.openappengine.facade.core.component.ui;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.core.component.AbstractGuiComponent;
import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.executable.PreRenderActionsComponent;
import com.openappengine.facade.core.component.transition.TransitionComponent;
import com.openappengine.facade.core.component.ui.container.PageContentComponent;
import com.openappengine.facade.core.component.ui.container.WidgetsComponent;
import com.openappengine.facade.core.component.ui.message.Message;
import com.openappengine.facade.core.component.ui.message.MessageSeverity;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.variable.Variable;
import com.openappengine.facade.fsm.Node;
import com.openappengine.facade.fsm.TransitionEvent;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class GuiRootComponent extends AbstractGuiComponent implements Node {

	private static final long serialVersionUID = 1L;
	
	private GuiApplicationContext context;
	
	private PreRenderActionsComponent preRenderActionsComponent;
	
	private PageContentComponent pageContent;
	
	private final List<TransitionComponent> screenTransitions = new ArrayList<TransitionComponent>();
	
	private Map<String, Variable> screenVariables = new ConcurrentHashMap<String, Variable>();
	
	private final List<Message> messages = new ArrayList<Message>();
	
	@Override
	public String getComponentType() {
		return "root-container";
	}

	@Override
	public String getComponentName() {
		return "root";
	}
	
	public Map<String, Variable> getScreenVariables() {
		return screenVariables;
	}

	public PreRenderActionsComponent getPreRenderActionComponent() {
		return preRenderActionsComponent;
	}

	public void setPreRenderActionComponent(PreRenderActionsComponent preActions) {
		this.preRenderActionsComponent = preActions;
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
	
	/**
	 * Get Widget keyed by Id.
	 * @param id
	 * @return
	 */
	public GuiComponent getWidget(String id) {
		if(StringUtils.isEmpty(id)) {
			return null;
		}
		
		List<WidgetsComponent> widgets = pageContent.getWidgets();
		if(widgets != null) {
			for (WidgetsComponent widgetsComponent : widgets) {
				if(StringUtils.equals(widgetsComponent.getId(),id)) {
					return widgetsComponent;
				}
			}
		}
		
		return null;
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

	public void addMessages(List<Message> messages) {
		messages.addAll(messages);
	}
	
	public void addInfoMessage(String code) {
		Message message = new Message(code,MessageSeverity.INFO);
		messages.add(message);
	}
	
	public void addErrorMessage(String code) {
		Message message = new Message(code,MessageSeverity.ERROR);
		messages.add(message);
	}
	
	public void addWarningMessage(String code) {
		Message message = new Message(code,MessageSeverity.WARNING);
		messages.add(message);
	}
	
	public void clearMessages() {
		messages.clear();
	}
}
