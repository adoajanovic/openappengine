/**
 * 
 */
package com.openappengine.facade.context.factory.support;

import org.springframework.beans.factory.parsing.ReaderContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Delegate to parse the Xml Definitions. 
 * 
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class ScreenDefinitionParserDelegate {
	
	private ReaderContext readerContext;
	
	private Element root;

	public ScreenDefinitionParserDelegate(ReaderContext readerContext, Element root) {
		super();
		this.readerContext = readerContext;
		this.setRoot(root);
	}
	
	/**
	 * Used to check if the node name of the XML Node is equal to the Screen XSD defined
	 * element and parse accordingly.
	 * 
	 * @param node
	 * @param nodeName
	 * @return NodeName equals the XML Node Name parsed currently.
	 */
	public boolean nodeNameEquals(Node node,String nodeName) {
		return nodeName.equals(node.getNodeName());
	}

	public ReaderContext getReaderContext() {
		return readerContext;
	}

	public void setReaderContext(ReaderContext readerContext) {
		this.readerContext = readerContext;
	}

	public Element getRoot() {
		return root;
	}

	public void setRoot(Element root) {
		this.root = root;
	}
	
}
