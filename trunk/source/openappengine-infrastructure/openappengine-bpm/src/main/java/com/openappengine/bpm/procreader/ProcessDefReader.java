/**
 * 
 */
package com.openappengine.bpm.procreader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.bpm.action.Action;
import com.openappengine.bpm.event.Event;
import com.openappengine.bpm.executable.ActionHandler;
import com.openappengine.bpm.graph.EndState;
import com.openappengine.bpm.graph.Node;
import com.openappengine.bpm.graph.ProcessDefinition;
import com.openappengine.bpm.graph.StartState;
import com.openappengine.bpm.graph.State;
import com.openappengine.bpm.graph.Transition;
import com.openappengine.bpm.xml.Problem;
import com.openappengine.bpm.xml.problem.IProblemListener;
import com.openappengine.utility.UtilString;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 *
 */
public class ProcessDefReader implements IProcessDefReader,IProblemListener {
	
	protected ProcessDefinition processDefinition;
	
	protected InputStream inputStream;
	
	protected Document document;
	
	protected List<Problem> problems; 
	
	public ProcessDefReader(InputStream inputStream) throws ProcessDefinitionException {
		super();
		this.inputStream = inputStream;
		readSetXmlDocumentNode();
		problems = new ArrayList<Problem>();
	}
	
	private void readSetXmlDocumentNode() throws ProcessDefinitionException { 
		try {
			document = UtilXml.readXmlDocument(inputStream);
		} catch (Exception e) {
			throw new ProcessDefinitionException("Unable to create the Document from the InputStream.", e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.openappengine.bpm.procreader.IProcessDefReader#readProcessDefinition(org.w3c.dom.Element)
	 */
	public ProcessDefinition readProcessDefinition()
			throws ProcessDefinitionException {
		ProcessDefinition processDefinition = new ProcessDefinition();

		if (document == null ||document.getDocumentElement() == null) {
			return null;
		}

		Element documentElement = document.getDocumentElement();
		
		if(!"process-definition".equalsIgnoreCase(documentElement.getNodeName())) {
			addProblem(new Problem("Incorrect Root Object", Problem.LEVEL_ERROR));
		}
		
		String processName = documentElement.getAttribute("name");
		if(UtilString.isEmptyOrBlank(processName)) {
			addProblem(new Problem("[process-definition] : Attribute name cannot be empty.", Problem.LEVEL_ERROR));
		}
		processDefinition.setName(processName);
		
		StartState startState = readStartState(documentElement);
		processDefinition.setStartState(startState);

		List<EndState> endStates = readEndState(documentElement);
		processDefinition.setEndStates(endStates);

		List<? extends Element> stateElementList = UtilXml.childElementList(
				documentElement, "state");
		if (stateElementList != null && !stateElementList.isEmpty()) {
			for (Element stateElement : stateElementList) {
				State state = new State();
				state.read(stateElement, this);
			}
		}
		return processDefinition;
	}

	/**
	 * @param documentElement
	 * @return
	 * @throws ProcessDefinitionException
	 */
	private StartState readStartState(Element documentElement)
			throws ProcessDefinitionException {
		List<? extends Element> startStateElements = UtilXml.childElementList(documentElement, "start-state");
		if(startStateElements == null || startStateElements.size() != 1) {
			throw new ProcessDefinitionException("[start-state] : Only One Expected");
		}
		Element startStateElement = startStateElements.get(0);
		StartState startState = readStartStateElement(startStateElement);
		return startState;
	}
	
	/**
	 * @param documentElement
	 * @return
	 * @throws ProcessDefinitionException
	 */
	public List<EndState> readEndState(Element documentElement)
			throws ProcessDefinitionException {
		List<EndState> endStates = new ArrayList<EndState>();
		List<? extends Element> endStateElements = UtilXml.childElementList(documentElement, "end-state");
		for (Element endStateElement : endStateElements) {
			EndState endState = new EndState();
			endState.read(endStateElement, this);
			endStates.add(endState);
		}
		return endStates;
	}

	/**
	 * @param reader
	 * @param transitionElement
	 * @return TODO
	 */
	public Transition readTransition(Element transitionElement) {
		Transition transition = new Transition();
		String name = transitionElement.getAttribute("name");
		if (!UtilString.isEmptyOrBlank(name)) {
			this.addProblem(new Problem(
					"'from' attribute should not be present in the transition element in start-start",
					Problem.LEVEL_ERROR));
		}
		transition.setName(name);
		
		String from = transitionElement.getAttribute("from");
		if (!UtilString.isEmptyOrBlank(from)) {
			this.addProblem(new Problem(
					"'from' attribute should not be present in the transition element in start-start",
					Problem.LEVEL_ERROR));
		}
		
		String to = transitionElement.getAttribute("to");
		if (UtilString.isEmptyOrBlank(to)) {
			this.addProblem(new Problem(
					"'to' attribute not present on the transition element in start-start",
					Problem.LEVEL_ERROR));
		}
		transition.setToNode(to);
		
		String condition = transitionElement.getAttribute("condition");
		if (!UtilString.isEmptyOrBlank(condition)) {
			transition.setCondition(condition);	
		}
		return transition;
	}
	
	/**
	 * Read a Event Node from 
	 * @param element
	 * @return {@link Event}
	 */
	public Event readEvent(Element element) {
		Event event = new Event();
		String eventType = element.getAttribute("eventType");
		if(UtilString.isEmptyOrBlank(eventType)) {
			addProblem(new Problem("[event] : Attribute eventType cannot be blank.", Problem.LEVEL_ERROR));
		}
		
		event.setEventType(eventType);
		
		List<? extends Element> actionElementList = UtilXml.childElementList(element, "action");
		if(actionElementList != null && !actionElementList.isEmpty()) {
			for (Element actionElement : actionElementList) {
				Action action = readActionElement(actionElement);
				event.addAction(action);
			}
		}
		return event;
	}

	/**
	 * @param actionElement
	 * @return {@link Action}
	 */
	private Action readActionElement(Element actionElement) {
		String name = actionElement.getAttribute("name");
		if(UtilString.isEmptyOrBlank(name)) {
			addProblem(new Problem("[action] : Attribute name cannot be blank.", Problem.LEVEL_ERROR));
		}
		String src = actionElement.getAttribute("src");
		if(UtilString.isEmptyOrBlank(src)) {
			addProblem(new Problem("[action] : Attribute src cannot be blank.", Problem.LEVEL_ERROR));
		}
		Class<?> actionCls = null;
		try {
			actionCls = Class.forName(src);
			if(!ActionHandler.class.isAssignableFrom(actionCls)) {
				addProblem(new Problem("[action] " + src + " : Should implement ActionHandler interface.", Problem.LEVEL_ERROR));	
			}
		} catch (ClassNotFoundException e) {
			addProblem(new Problem("[action] " + src + " : Could not be instantiated.", Problem.LEVEL_ERROR));
		}
		Action action = new Action(name, actionCls);
		return action;
	}
	
	
	/**
	 * @param element
	 * @param processDefReader
	 * @return TODO
	 */
	public void readNode(Element element, Node node) {
		String name = element.getAttribute("name");
		if (UtilString.isEmptyOrBlank(name)) {
			this.addProblem(new Problem(
					"[state] : Attribute name cannot be blank.",
					Problem.LEVEL_ERROR));
		}
		
		node.setName(name);

		List<? extends Element> transitionElementList = UtilXml
				.childElementList(element, "transition");
		if (transitionElementList != null && !transitionElementList.isEmpty()) {
			for (Element transitionElement : transitionElementList) {
				Transition transition = this.readTransition(transitionElement);
				node.addTransition(transition);
			}
		}

		List<? extends Element> eventElementList = UtilXml.childElementList(
				element, "event");
		for (Element eventElement : eventElementList) {
			Event event = this.readEvent(eventElement);
			node.addEvent(event);
		}
	}
	
	/**
	 * @param startStateElement
	 * @return
	 */
	private StartState readStartStateElement(Element startStateElement) {
		StartState startState = new StartState();
		startState.read(startStateElement, this);
		return startState;
	}
	
	public void addProblem(Problem problem) {
		if(problem == null) {
			return;
		}
		
		this.problems.add(problem);
	}

}
