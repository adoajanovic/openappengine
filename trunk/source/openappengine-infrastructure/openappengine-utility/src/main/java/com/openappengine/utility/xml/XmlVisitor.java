/**
 * 
 */
package com.openappengine.utility.xml;

import java.util.List;

import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author hrishi
 * since Mar 9, 2012
 */
public class XmlVisitor {
	
	public static void visitLeafNodes(Element ele, XmlVisitorCallback callback) {
		if(ele == null) {
			return;
		}
		
		List<Element> childElements = DomUtils.getChildElements(ele);
		if(childElements != null && !childElements.isEmpty()) {
			for (Element element : childElements) {
				visitLeafNodes(element, callback);
			}
		} else {
			callback.onCallback(ele);
		}
	}
	
	
	
	public interface XmlVisitorCallback {
		
		public void onCallback(Node v);
	}

}
