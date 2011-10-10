/**
 * 
 */
package com.openappengine.bpm.procreader;

import java.util.List;

import org.w3c.dom.Element;

import com.openappengine.bpm.procmod.ProcessDefinition;
import com.openappengine.bpm.procmod.State;
import com.openappengine.bpm.procmod.Transition;
import com.openappengine.utility.UtilString;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 *
 */
public class ProcessDefReader implements IProcessDefReader {

	//TODO - Supports reading only one level deep simple process definitions right now.
	/* (non-Javadoc)
	 * @see com.openappengine.bpm.procreader.IProcessDefReader#readProcessDefinition(org.w3c.dom.Element)
	 */
	public ProcessDefinition readProcessDefinition(Element element) throws ProcessDefinitionException{
		if(element == null) {
			return null;
		}
		
		ProcessDefinition processDefinition = new ProcessDefinition();
		
		String id = UtilXml.childElementValue(element, "id");
		if(UtilString.isEmptyOrBlank(id)) {
			throw new ProcessDefinitionException("ProcessDefinition : " + "id" + " cannot be empty.");
		}
		
		processDefinition.setId(id);
		
		List<? extends Element> stateElements = UtilXml.childElementList(element, "state");
		if(stateElements == null || stateElements.isEmpty()) {
			throw new ProcessDefinitionException("ProcessDefinition :" + "state" + " cannot be empty.");
		}
		
		for (Element stateElement : stateElements) {
			State state = readStateElement(element, stateElement);
			processDefinition.addState(state.getId(), state);
		}
		
		return processDefinition;
	}

	/**
	 * @param element
	 * @param stateElement
	 * @return {@link State}
	 * @throws ProcessDefinitionException
	 */
	private State readStateElement(Element element, Element stateElement)
			throws ProcessDefinitionException {
		State state = new State();
		
		state.setParent(null);
		
		String stateId = UtilXml.childElementValue(element, "id");
		if(UtilString.isEmptyOrBlank(stateId)) {
			throw new ProcessDefinitionException("ProcessDefinition : " + "id" + " cannot be empty.");
		}
		
		state.setId(stateId);
		
		String initState = UtilXml.childElementValue(stateElement, "initial");
		if(!UtilString.isEmptyOrBlank(initState)) {
			Boolean init = Boolean.valueOf(initState);
			if(init != null && init.booleanValue() == true) {
				state.setInitialState(init.booleanValue());
			}
		}
		
		String finalState = UtilXml.childElementValue(stateElement, "final");
		if(!UtilString.isEmptyOrBlank(finalState)) {
			Boolean finalSt = Boolean.valueOf(finalState);
			if(finalSt != null && finalSt.booleanValue() == true) {
				state.setInitialState(finalSt.booleanValue());
			}
		}
		
		List<? extends Element> transitions = UtilXml.childElementList(stateElement, "transition");
		if(transitions != null && !transitions.isEmpty()) {
			for (Element transitionElement : transitions) {
				String event = UtilXml.childElementValue(transitionElement, "event");
				
				String condition = UtilXml.childElementValue(transitionElement, "condition");
				
				String to = UtilXml.childElementValue(transitionElement, "to");
				
				//TODO - Validate these three.
				Transition transition = new Transition();
				transition.setParent(state);
				transition.setTo(to);
				transition.setEvent(event);
				transition.setCondition(condition);
				
				state.addTransition(transition);
			}
		}
		return state;
	}

}
