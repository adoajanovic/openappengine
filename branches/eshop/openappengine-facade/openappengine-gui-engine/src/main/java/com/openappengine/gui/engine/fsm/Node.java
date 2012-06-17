/**
 * 
 */
package com.openappengine.gui.engine.fsm;

import java.util.Collection;
import java.util.List;

import com.openappengine.gui.engine.core.component.transition.TransitionComponent;
import com.openappengine.gui.engine.core.variable.Variable;

/**
 * @author hrishikesh.joshi
 * @since Dec 28, 2011
 */
public interface Node {
	
	Collection<Variable> getNodeVariables();
	
	List<TransitionComponent> getTransitions();
	
	List<TransitionComponent> getTransitionsListeningToEvent(TransitionEvent event);

}
