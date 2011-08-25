/**
 * 
 */
package com.ms.openapps.appflow.flow;

import com.ms.openapps.appflow.context.WorkflowParameterContext;
import com.ms.openapps.appflow.step.Step;

/**
 * @author hrishi
 *
 */
public class Flow {
	
	private String id;
	
	private Step[] steps;
	
	private int currentStep;

	private Step firstStep;
	
	/**
	 * @param currentStep the currentStep to set
	 */
	public void setCurrentStep(Integer currentStep) {
		this.currentStep = currentStep;
	}

	/**
	 * @return the currentStep
	 */
	public Integer getCurrentStep() {
		return currentStep;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param steps the steps to set
	 */
	public void setSteps(Step[] steps) {
		this.steps = steps;
	}

	/**
	 * @return the steps
	 */
	public Step[] getSteps() {
		return steps;
	}

	/**
	 * @param firstStep the firstStep to set
	 */
	public void setFirstStep(Step firstStep) {
		this.firstStep = firstStep;
	}

	/**
	 * @return the firstStep
	 */
	public Step getFirstStep() {
		return firstStep;
	}

	/**
	 * @param id
	 * @param steps
	 * @param workflowParameters
	 * @param firstStep
	 */
	public Flow(String id, Step[] steps, 
			Step firstStep) {
		super();
		this.id = id;
		this.steps = steps;
		this.firstStep = firstStep;
	}
	
}
