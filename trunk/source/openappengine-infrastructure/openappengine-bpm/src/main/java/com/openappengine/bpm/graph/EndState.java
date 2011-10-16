/**
 * 
 */
package com.openappengine.bpm.graph;

import java.util.List;

import org.w3c.dom.Element;

import com.openappengine.bpm.event.Event;
import com.openappengine.bpm.procreader.ProcessDefReader;
import com.openappengine.bpm.xml.Problem;
import com.openappengine.utility.UtilString;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishikesh.joshi
 *
 */
public class EndState extends State implements Parseable{
	
	private static final long serialVersionUID = 1L;

	/**
	 *  Sets the final state field to True.
	 */
	public EndState() {
		super();
		this.supportedEventTypes = new String[]{Event.EVENT_NODE_ENTER};
	}

	public void read(Element element, ProcessDefReader processDefReader) {
		String name = element.getAttribute("name");
		if(UtilString.isEmptyOrBlank(name)) {
			processDefReader.addProblem(new Problem("[end-state] : Attribute name cannot be empty.",Problem.LEVEL_ERROR));	
		}
		this.setName(name);
		
		List<? extends Element> transitionElementList = UtilXml.childElementList(element,"transition");
		if(transitionElementList != null && !transitionElementList.isEmpty()) {
			processDefReader.addProblem(new Problem("No Transition Element can be present in the EndState.",Problem.LEVEL_ERROR));
		}
		
		List<? extends Element> eventElementList = UtilXml.childElementList(element,"event");
		if(eventElementList != null && eventElementList.size() == 1) {
			Element eventElement = eventElementList.get(0);
			Event event = processDefReader.readEvent(eventElement,this);
			this.addEvent(event);
		}
	}

}
