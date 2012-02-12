/**
 * 
 */
package com.openappengine.facade.core.action.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.openappengine.facade.core.request.transformer.ExternalRequestParamsXml;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 * since Feb 10, 2012
 */
public class EntityActionRequestXml implements ActionRequestXml {
	
	private Document document;
	
	private ExternalRequestParamsXml externalRequestParamsXml;
	
	private ActionParamsXml actionParamsXml;
	
	private String actionName;
	
	public EntityActionRequestXml(ExternalRequestParamsXml externalRequestParamsXml,
			ActionParamsXml actionParamsXml,String actionName) {
		this.externalRequestParamsXml = externalRequestParamsXml;
		this.actionParamsXml = actionParamsXml;
		this.actionName = actionName;
		createActionRequestDocument(externalRequestParamsXml, actionParamsXml);
	}

	/**
	 * @param externalRequestParamsXml
	 * @param actionParamsXml
	 */
	private void createActionRequestDocument(
			ExternalRequestParamsXml externalRequestParamsXml,
			ActionParamsXml actionParamsXml) {
		document = UtilXml.makeEmptyXmlDocument("action-request");
		
		
		
		if(externalRequestParamsXml != null) {
			Document externalRequestXmlDoc = externalRequestParamsXml.getDocument();
			if(externalRequestXmlDoc != null) {
				Element externalRequestEle = externalRequestXmlDoc.getDocumentElement();
				Node node = document.adoptNode(externalRequestEle);
				document.getDocumentElement().appendChild(node);
			}
		}
		
		if(actionParamsXml != null) {
			Document actionParamsXmlDoc = actionParamsXml.getDocument();
			if(actionParamsXmlDoc != null) {
				Element externalRequestEle = actionParamsXmlDoc.getDocumentElement();
				Node node = document.adoptNode(externalRequestEle);
				document.getDocumentElement().appendChild(node);
			}
		}
		
		System.out.println(UtilXml.writeXmlDocument(document));
	}
	
	@Override
	public Document getActionRequestXmlDocument() {
		return document;
	}
	
	public String getActionName() {
		return actionName;
	}

	public String getEntityName() {
		if(actionParamsXml instanceof EntityActionParamsXml) {
			return ((EntityActionParamsXml) actionParamsXml).getEntityName();
		}
		
		return null;
	}
	
}
