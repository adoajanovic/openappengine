/**
 * 
 */
package com.openappengine.facade.fsm;

import java.util.Collection;
import java.util.List;

import com.openappengine.facade.core.component.transition.TransitionComponent;
import com.openappengine.facade.core.variable.Variable;

/**
 * @author hrishikesh.joshi
 * @since Dec 28, 2011
 */
public interface Node {
	
	Collection<Variable> getNodeVariables();
	
	List<TransitionComponent> getTransitions();
	
	List<TransitionComponent> getTransitionsListeningToEvent(TransitionEvent event);

}
