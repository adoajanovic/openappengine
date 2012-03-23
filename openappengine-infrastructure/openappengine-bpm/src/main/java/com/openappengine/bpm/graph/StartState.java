/**
 * 
 */
package com.openappengine.bpm.graph;

import org.w3c.dom.Element;

import com.openappengine.bpm.event.Event;
import com.openappengine.bpm.procreader.ProcessDefReader;

/**
 * @author hrishikesh.joshi
 *
 */
public class StartState extends Node implements Parseable {
	
	private static final long serialVersionUID = 1L;

	/**
	 *  Set this as initial state
	 */
	public StartState() {
		super();
		this.supportedEventTypes = new String[]{Event.EVENT_NODE_LEAVE};
	}

	public void read(Element element,ProcessDefReader reader) {
		reader.readNode(element, this);
	}
}
