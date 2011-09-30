/**
 *	The base 
 */
package com.openappengine.bpm.bridge;

import com.openappengine.bpm.model.State;
import com.openappengine.bpm.model.Transition;

/**
 * @author hrishikesh.joshi
 *
 */
public interface IStateMachineListener {
	
	/**
	 *  Listener for onEntry of a State.
	 */
	public void onEntry();
	
	/**
	 *  Listener for onExit of a State.
	 */
	public void onExit();
	
	/**
	 * Listener for a State Transition event.
	 * @param previousState
	 * @param newState
	 * @param transition
	 */
	public void onTransition(State previousState,State newState,Transition transition);

}
