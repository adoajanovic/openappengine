/**
 * 
 */
package com.openappengine.entity.response;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.entity.definition.Entity;
import com.openappengine.entity.definition.Field;
import com.openappengine.utility.ObjectConverter;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 * since Feb 11, 2012
 */
public class DefaultEntityResponse implements EntityResponse {
	
	private Document document;
	
	/**
	 * @param document
	 */
	public DefaultEntityResponse() {
		createEntityEngineResponse();
	}

	private void createEntityEngineResponse() {
		document = UtilXml.makeEmptyXmlDocument("entity-response");
	}
	
	public void addEntity(Entity entity) {
		if(entity == null) {
			return;
		}

		Element root = document.getDocumentElement();
		
		Element entityEle = document.createElement("entity");
		entityEle.setAttribute("name", entity.getEntityName());
		
		List<Field> fields = entity.getFields();
		if(fields != null) {
			for (Field field : fields) {
				Element fieldEle = document.createElement("field");
				fieldEle.setAttribute("name", field.getName());
				
				String fieldValue = ObjectConverter.convert(field.getFieldValue(), String.class);
				fieldEle.setTextContent(fieldValue);
				
				entityEle.appendChild(fieldEle);
			}
		}
		root.appendChild(entityEle);
	}

	@Override
	public Document getEntityResponseDocument() {
		return document;
	}

}
