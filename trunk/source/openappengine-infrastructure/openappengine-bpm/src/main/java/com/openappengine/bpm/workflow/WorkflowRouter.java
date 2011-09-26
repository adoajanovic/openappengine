/**
 * 
 */
package com.openappengine.bpm.workflow;

import org.apache.log4j.Logger;

import com.openappengine.bpm.model.ProcessExecutor;
import com.openappengine.bpm.model.ProcessModel;
import com.openappengine.bpm.model.Workflow;
import com.openappengine.bpm.model.WorkflowContext;

/**
 * @author hrishi
 *
 */
public class WorkflowRouter {

	private Workflow workflow;
	private final Logger logger = Logger.getLogger(getClass());
	
	public WorkflowRouter(Workflow workflow) throws WorkflowRouterException {
		super();
		validateWorkflow(workflow);
		this.workflow = workflow;
	}

	/**
	 * @param workflow
	 * @throws WorkflowRouterException
	 */
	private void validateWorkflow(Workflow workflow)
			throws WorkflowRouterException {
		if(workflow == null) {
			throw new WorkflowRouterException("Workflow cannot be null. WorkflowRouter cannot be instantiated.");
		}
	}
	
	public void runSync(WorkflowContext ctx) {
		logger .info("Invoking Workflow [" + workflow.getName() + "]...");
		
		//Get Init Process and execute process
		String initProcess = workflow.getInitProcess();
		ProcessModel runningProcessModel = workflow.getProcess(initProcess);
		ProcessExecutor processExecutor = runningProcessModel.getProcessExecutor();
		WorkflowContext context = processExecutor.execute(ctx);
		
	}
}
