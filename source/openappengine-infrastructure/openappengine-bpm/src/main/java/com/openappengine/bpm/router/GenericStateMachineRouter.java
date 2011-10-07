/**
 * 
 */
package com.openappengine.bpm.router;

import com.openappengine.bpm.api.IErrorReporter;
import com.openappengine.bpm.bridge.IStateMachineListener;
import com.openappengine.bpm.model.Event;
import com.openappengine.bpm.model.MachineStateEvaluator;
import com.openappengine.bpm.model.ProcessStatus;
import com.openappengine.bpm.model.ProcessInstance;
import com.openappengine.bpm.model.TransitionStep;

/**
 * @author hrishi
 *
 */
public class GenericStateMachineRouter implements IStateMachineRouter {
	
	private IStateMachineListener stateMachineListener;
	
	private IErrorReporter errorReporter;
	
	private ProcessInstance processInstance;
	
	private ProcessStatus processStatus;
	
	private MachineStateEvaluator machineStateEvaluator;
	
	public GenericStateMachineRouter(ProcessInstance processInstance) {
		super();
		this.processStatus = new ProcessStatus();
		this.processInstance = processInstance;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.bpm.router.IStateMachineRouter#registerStateMachineListener(com.openappengine.bpm.bridge.IStateMachineListener)
	 */
	public void registerStateMachineListener(IStateMachineListener iStateMachineListener) {
		this.stateMachineListener = iStateMachineListener;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.bpm.router.IStateMachineRouter#registerErrorReporter(com.openappengine.bpm.api.IErrorReporter)
	 */
	public void registerErrorReporter(IErrorReporter errorReporter) {
		this.errorReporter = errorReporter;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.bpm.router.IStateMachineRouter#triggerEvent(com.openappengine.bpm.model.Event)
	 */
	public void triggerEvent(Event event) {
		TransitionStep step = new TransitionStep(processStatus);
		
	}

	/* (non-Javadoc)
	 * @see com.openappengine.bpm.router.IStateMachineRouter#resetStateMachine()
	 */
	public void resetStateMachine() {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see com.openappengine.bpm.router.IStateMachineRouter#run()
	 */
	public void run() {
		// TODO Auto-generated method stub
	}

}
