/**
 * 
 */
package com.openappengine.gui.engine.core.action.xml;

import org.springframework.util.Assert;
import org.w3c.dom.Document;

/**
 * @author hrishi
 * since Feb 11, 2012
 */
public class EntityActionParamsXml implements ActionParamsXml {

	private Document document;
	
	private String entityName;
	
	/**
	 * @param document
	 */
	public EntityActionParamsXml(String entityName,Document document) {
		Assert.notNull(entityName, "EntityName cannot be null.");
		this.entityName = entityName;
		Assert.notNull(document, "ActionParamsXml cannot be null.");
		this.document = document;
	}
	
	public String getEntityName() {
		return entityName;
	}

	@Override
	public Document getDocument() {
		return document;
	}

	@Override
	public String getActionName() {
		return document.getDocumentElement().getAttribute("action-name");
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

}
