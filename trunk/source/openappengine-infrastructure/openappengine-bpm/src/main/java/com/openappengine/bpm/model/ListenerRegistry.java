/**
 * 
 */
package com.openappengine.bpm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.openappengine.bpm.bridge.IStateMachineListener;

/**
 * @author hrishi
 *
 */
public class ListenerRegistry implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 	The <code>IStateMachineListeners</code> registered with the StateMachine are registered with this class. 
	 */
	private List<IStateMachineListener> listeners;
	
	/**
	 * 	The owning <code>StateMachine</code> for this ListenerRegistry.
	 * 
	 */
	private StateMachine stateMachine;
	

	public ListenerRegistry() {
		super();
		listeners = new ArrayList<IStateMachineListener>();
	}
	
	/**
	 * Are any listeners registered with the State Machine.
	 * @return boolean
	 */
	public boolean isEmpty() {
		return listeners.isEmpty();
	}
	
	/**
	 * Add <code>IStateMachineListener</code> to this registry.
	 * @param listener
	 */
	public void addListener(IStateMachineListener listener) {
		if(listener == null) {
			return;
		}
		listeners.add(listener);
	}
	
	/**
	 * Notify All the Listeners of this <code>StateMachine</code> on a transition event.
	 * @param previousState
	 * @param newState
	 * @param transition
	 */
	public void  notifyTransitionEvent(State previousState, State newState, Transition transition) {
		for(IStateMachineListener listener : listeners) {
			listener.onTransition(previousState, newState, transition);
		}
	}
	
	public StateMachine getStateMachine() {
		return stateMachine;
	}

	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}
	

}
