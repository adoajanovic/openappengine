/**
 * 
 */
package com.openappengine.bpm.graph;

/**
 * @author hrishikesh.joshi
 *
 */
public class Transition {
	
	private String name;
	
	private Node from;
	
	/* A Boolean Expression -- Guard Condition */
	private String condition = "true";
	
	/* Node State - Node Event to */ 
	private Node to;
	
	private String toNode;
	
	/**
	 *  Parent state having this as an outgoing transition.
	 */
	private Node parent;
	
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	/**
	 * @return the from
	 */
	public Node getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(Node from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public Node getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(Node to) {
		this.to = to;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the toNode
	 */
	public String getToNode() {
		return toNode;
	}

	/**
	 * @param toNode the toNode to set
	 */
	public void setToNode(String toNode) {
		this.toNode = toNode;
	}

}
