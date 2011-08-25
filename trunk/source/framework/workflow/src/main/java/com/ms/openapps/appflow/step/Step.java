/**
 * 	Represents an individual step in the App Flow.
 */
package com.ms.openapps.appflow.step;

import com.ms.openapps.appflow.params.InParam;
import com.ms.openapps.appflow.params.OutParam;

/**
 * @author hrishi
 *
 */
public class Step {
	
	private String id;
	
	private Integer sequence;
	
	private InParam[] inParams;
	
	private OutParam[] outParams;
	
	private StepHandler stepHandler;
	
	private Step successor;
	
	private boolean firstStep;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the sequence
	 */
	public Integer getSequence() {
		return sequence;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Step [id=" + id + ", sequence=" + sequence + ", inParam="
				+ inParams + ", outParam=" + outParams + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inParams == null) ? 0 : inParams.hashCode());
		result = prime * result
				+ ((outParams == null) ? 0 : outParams.hashCode());
		result = prime * result
				+ ((sequence == null) ? 0 : sequence.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Step other = (Step) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inParams == null) {
			if (other.inParams!= null)
				return false;
		} else if (!inParams.equals(other.inParams))
			return false;
		if (outParams == null) {
			if (other.outParams != null)
				return false;
		} else if (!outParams.equals(other.outParams))
			return false;
		if (sequence == null) {
			if (other.sequence != null)
				return false;
		} else if (!sequence.equals(other.sequence))
			return false;
		return true;
	}

	/**
	 * @param stepHandler the stepHandler to set
	 */
	public void setStepHandler(StepHandler stepHandler) {
		this.stepHandler = stepHandler;
	}

	/**
	 * @return the stepHandler
	 */
	public StepHandler getStepHandler() {
		return stepHandler;
	}

	/**
	 * @param successor the successor to set
	 */
	public void setSuccessor(Step successor) {
		this.successor = successor;
	}

	/**
	 * @return the successor
	 */
	public Step getSuccessor() {
		return successor;
	}

	/**
	 * @param inParams the inParams to set
	 */
	public void setInParams(InParam[] inParams) {
		this.inParams = inParams;
	}

	/**
	 * @return the inParams
	 */
	public InParam[] getInParams() {
		return inParams;
	}

	/**
	 * @param outParams the outParams to set
	 */
	public void setOutParams(OutParam[] outParams) {
		this.outParams = outParams;
	}

	/**
	 * @return the outParams
	 */
	public OutParam[] getOutParams() {
		return outParams;
	}

	/**
	 * @param id
	 * @param sequence
	 * @param inParams
	 * @param outParams
	 * @param stepHandler
	 */
	public Step(String id, Integer sequence, InParam[] inParams,
			OutParam[] outParams, StepHandler stepHandler,boolean firstStep) {
		super();
		this.id = id;
		this.sequence = sequence;
		this.inParams = inParams;
		this.outParams = outParams;
		this.stepHandler = stepHandler;
		this.firstStep = firstStep;
	}

	/**
	 * @param firstStep the firstStep to set
	 */
	public void setFirstStep(boolean firstStep) {
		this.firstStep = firstStep;
	}

	/**
	 * @return the firstStep
	 */
	public boolean isFirstStep() {
		return firstStep;
	}

}
