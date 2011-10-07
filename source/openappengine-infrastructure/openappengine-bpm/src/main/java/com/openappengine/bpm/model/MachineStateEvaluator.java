/**
 * This class helps to evaluate the states of the machine throughout its execution.
 */
package com.openappengine.bpm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author hrishi
 *
 */
public class MachineStateEvaluator {
	
	/**
	 *  Default Constructor.
	 */
	public MachineStateEvaluator() {
		super();
	}

	/**
	 * If the ProcessInstance is in INIT state, return the InitialTarget as the Next State.
	 * 
	 * @return {@link Target} - Evaluate the Next State of the Machine 
	 */
	public List<Target> evaluateTarget(ProcessInstance processInstance) {
		ProcessStatus processStatus = processInstance.getMachineStatus();
		List<Target> targets = new ArrayList<Target>();
		Target target = null;
		if(processStatus.isInitState()) {	//ProcessInstance is in InitState --> The Init State is the Next Target. 
			target = processInstance.getInitialTarget();
			targets.add(target);
		} else {
			List<Event> queuedEvents = processStatus.getQueuedEvents();
			Set<? extends State> activeStates = processStatus.getActiveStates();
			if(queuedEvents != null && !queuedEvents.isEmpty()) {
				for (Event event : queuedEvents) {
					for (State state : activeStates) {
						String eventName = event.getName();
						if(state.containsTransitionsWaitingForEvent(eventName)) {
							List<Transition> transitions = state.getTransitions(eventName);
							for (Transition transition : transitions) {
								Target parent = transition.getParent();
								transition.getTarget();
							}
						}
					}
				}
			}
		}
		return targets;
	}
	
	

}
