/**
 * 
 */
package com.openappengine.facade.fsm;

import java.io.Serializable;
import java.util.Map;

/**
 * @author hrishikesh.joshi
 * @since Dec 28, 2011
 */
public class TransitionOutcome implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String targetUrl;
	
	private String outcomeId;
	
	private String conditionalExpression;
	
	private Map<String, Object> transitionParams;

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public Map<String, Object> getTransitionParams() {
		return transitionParams;
	}

	public void setTransitionParams(Map<String, Object> transitionParams) {
		this.transitionParams = transitionParams;
	}

	public String getOutcomeId() {
		return outcomeId;
	}

	public void setOutcomeId(String outcomeId) {
		this.outcomeId = outcomeId;
	}

	public String getConditionalExpression() {
		return conditionalExpression;
	}

	public void setConditionalExpression(String conditionalExpression) {
		this.conditionalExpression = conditionalExpression;
	}

}
