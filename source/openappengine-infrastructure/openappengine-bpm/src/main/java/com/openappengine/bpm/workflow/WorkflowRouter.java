/**
 * 
 */
package com.openappengine.bpm.workflow;

import org.apache.log4j.Logger;

import com.openappengine.bpm.model.ProcessExecutor;
import com.openappengine.bpm.model.Process;
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
}
