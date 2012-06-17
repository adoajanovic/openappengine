/**
 * 
 */
package com.openappengine.gui.engine.fsm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.openappengine.gui.engine.core.executor.action.Executable;

/**
 * @author hrishikesh.joshi
 * @since Dec 28, 2011
 */
public class Transition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String guardConditionExpression;
	
	private Executable executable;
	
	private List<TransitionOutcome> conditionalOutcomes = new ArrayList<TransitionOutcome>();
	
	private TransitionOutcome defaultOutcome;
	
	private TransitionOutcome errorOutcome;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGuardConditionExpression() {
		return guardConditionExpression;
	}

	public void setGuardConditionExpression(String guardConditionExpression) {
		this.guardConditionExpression = guardConditionExpression;
	}

	public Executable getExecutable() {
		return executable;
	}

	public void setExecutable(Executable executable) {
		this.executable = executable;
	}

	public List<TransitionOutcome> getConditionalOutcomes() {
		return conditionalOutcomes;
	}

	public void setConditionalOutcomes(List<TransitionOutcome> conditionalOutcomes) {
		this.conditionalOutcomes = conditionalOutcomes;
	}

	public TransitionOutcome getDefaultOutcome() {
		return defaultOutcome;
	}

	public void setDefaultOutcome(TransitionOutcome defaultOutcome) {
		this.defaultOutcome = defaultOutcome;
	}

	public TransitionOutcome getErrorOutcome() {
		return errorOutcome;
	}

	public void setErrorOutcome(TransitionOutcome errorOutcome) {
		this.errorOutcome = errorOutcome;
	}
}
