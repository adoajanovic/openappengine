/**
 * 
 */
package com.openappengine.bpm.router;

import com.openappengine.bpm.api.IErrorReporter;
import com.openappengine.bpm.bridge.IStateMachineListener;
import com.openappengine.bpm.model.Event;

/**
 * @author hrishikesh.joshi
 *
 */
public interface IStateMachineRouter {
	
	/**
	 * Add A Listener to the events on State Machine.
	 * @param iStateMachineListener
	 */
	public void registerStateMachineListener(IStateMachineListener iStateMachineListener);
	
	/**
	 * Add an ErrorReporter for the ProcessInstance being executed.
	 * @param errorReporter
	 */
	public void registerErrorReporter(IErrorReporter errorReporter);

	/**
	 * Trigger the incoming event on the StateEngine.
	 * @param event
	 */
	public void triggerEvent(Event event);
	
	/**
	 *  Reset the ProcessInstance to its initial event
	 */
	public void resetStateMachine();
	
	/**
	 * 	Run the State Machine
	 */
	public void run();

}
