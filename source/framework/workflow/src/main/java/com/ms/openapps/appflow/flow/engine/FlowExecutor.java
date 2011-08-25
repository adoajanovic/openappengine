/**
 * 
 */
package com.ms.openapps.appflow.flow.engine;

import com.ms.openapps.appflow.context.WorkflowParameterContext;
import com.ms.openapps.appflow.exceptions.AppFlowException;
import com.ms.openapps.appflow.flow.Flow;
import com.ms.openapps.appflow.step.Step;

/**
 * @author hrishi
 *
 */
public class FlowExecutor {
	
	private Flow flow;
	
	private WorkflowParameterContext parameters;
	
	public FlowExecutor(Flow flow,WorkflowParameterContext parameters) {
		this.flow = flow;
		this.parameters = parameters;
	}
	
	private int processStep =  0;
	
	public void executeFlow() {
		if(flow == null) {
			throw new AppFlowException("Flow is not initialized");
		}
		
		if(flow.getSteps() == null || flow.getSteps().length == 0) {
			throw new AppFlowException("Flow Steps cannot be empty");
		}
		
		//TODO - Determine the first step from the flow.
		Step currentStep = flow.getFirstStep();
		Step[] steps = flow.getSteps();
		
		for(Step step : steps){
			// Pre Excute Step
			this.preExecuteStep(step);
			
			step.getStepHandler().executeStep();
			
			// Post Excute Step
			this.postExecuteStep(step);
		}
		
	}

	/**
	 *  Assemble the flow with parameters before executing the step
	 * @param step
	 */
	private void preExecuteStep(Step step) {
		//TODO - Read INParams for the STEP from the Flow Context and set them in the corresponding properties of the STEP
		
	}
	
	/**
	 *  Assemble the flow with parameters after executing the step
	 * @param step
	 */
	private void postExecuteStep(Step step) {
		//TODO - Read OUTParams for the STEP from properties of the STEP set them in the FlowContext
		
		//TODO - Evaluate Successor Step from this Step
		
	}
	
	
	/**
	 * @param flow the flow to set
	 */
	public void setFlow(Flow flow) {
		this.flow = flow;
	}

	/**
	 * @return the flow
	 */
	public Flow getFlow() {
		return flow;
	}

}