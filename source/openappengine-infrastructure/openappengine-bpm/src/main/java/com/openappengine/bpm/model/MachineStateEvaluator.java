/**
 * This class helps to evaluate the states of the machine throughout its execution.
 */
package com.openappengine.bpm.model;

/**
 * @author hrishi
 *
 */
public class MachineStateEvaluator {
	
	private StateMachine stateMachine;
	
	public MachineStateEvaluator(StateMachine stateMachine) {
		super();
		this.stateMachine = stateMachine;
	}

	public Target evaluateInitTarget() {
		Target initialTarget = stateMachine.getInitialTarget();
		if(initialTarget == null) {
			//TODO - Throw an exception.
		}
		return initialTarget; 
	}
	
	

}
