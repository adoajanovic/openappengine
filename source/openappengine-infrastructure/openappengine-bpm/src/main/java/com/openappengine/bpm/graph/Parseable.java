/**
 * 
 */
package com.openappengine.bpm.graph;

import java.io.Serializable;

import org.w3c.dom.Element;

import com.openappengine.bpm.procreader.ProcessDefReader;

/**
 * @author hrishi
 *
 */
public interface Parseable extends Serializable {
	
	/**
	 * Read Process Definition Node. 
	 * @param element
	 * @param processDefReader TODO
	 */
	public void read(Element element, ProcessDefReader processDefReader);
	
}
