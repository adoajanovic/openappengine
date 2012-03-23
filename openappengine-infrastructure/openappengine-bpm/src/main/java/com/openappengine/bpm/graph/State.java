/**
 * 
 */
package com.openappengine.bpm.graph;

import java.util.Map;

import org.w3c.dom.Element;

import com.openappengine.bpm.event.Event;
import com.openappengine.bpm.procreader.ProcessDefReader;

/**
 * @author hrishi
 * 
 */
public class State extends Node implements Parseable {

	private static final long serialVersionUID = 1L;

	/*
	 * A map of child processes. Used if the process has any subprocesses and
	 * itself acts as a ProcessEngine itself.
	 */
	private Map<String, State> children;

	public State() {
		this.supportedEventTypes = new String[] { Event.EVENT_NODE_ENTER,
				Event.EVENT_NODE_LEAVE };
	}

	public State getState(String name) {
		return children.get(name);
	}

	public Map<String, State> getChildren() {
		return children;
	}

	public void setChildren(Map<String, State> children) {
		this.children = children;
	}

	public void read(Element element, ProcessDefReader processDefReader) {
		processDefReader.readNode(element, this);
	}
	
}