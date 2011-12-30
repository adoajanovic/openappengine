/**
 * 
 */
package com.openappengine.facade.context.factory.xml;

import org.springframework.beans.factory.parsing.ReaderContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.openappengine.facade.context.factory.support.ScreenDefinitionParserDelegate;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class DefaultScreenDefinitionDocumentReader implements ScreenDefinitionDocumentReader {
	
	/**
	 *  Represents the XML Pre-Actions Node. 
	 */
	private static final String PREACTIONS = "pre-actions";
	
	
	private ReaderContext readerContext;

	@Override
	public void registerScreenDefinition(Document doc, ScreenReaderContext readerContext) {
		this.readerContext = readerContext;
		
		Element root = doc.getDocumentElement();
		
		ScreenDefinitionParserDelegate delegate = createParserDelegate(readerContext, root);
		
		parseScreenDefinition(root, delegate);
	}

	/**
	 * @param readerContext
	 */
	protected ScreenDefinitionParserDelegate createParserDelegate(ScreenReaderContext readerContext,Element root) {
		ScreenDefinitionParserDelegate parserDelegate = new ScreenDefinitionParserDelegate(readerContext,root);
		return parserDelegate;
	}
	
	protected void parseScreenDefinition(Element root,ScreenDefinitionParserDelegate delegate) {
		NodeList nodeList = root.getChildNodes();
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if(node instanceof Element) {
				parseElement((Element)node, delegate);
			}
		}
	}
	
	private void parseElement(Element element,ScreenDefinitionParserDelegate delegate) {
		if(delegate.nodeNameEquals(element, PREACTIONS)) {
			parsePreActions(element, delegate);
		}
	}
	
	private void parsePreActions(Element element,ScreenDefinitionParserDelegate delegate) {
		//TODO - Create a method in the delegate to parse the <pre-actions> XML node.
	}

}
