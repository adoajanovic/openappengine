/**
 * 
 */
package com.openappengine.facade.entity;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;

import com.openappengine.facade.entity.definition.Entity;

/**
 * @author hrishikesh.joshi
 * @since  Feb 6, 2012
 *
 */
public class XmlEntityValue implements EntityValue {
	
	private Document instance;
	
	private String entityName;
	
	private Entity entityDefinition;
	
	/**
	 * @param instance
	 * @param entityName
	 * @param entityDefinition
	 */
	public XmlEntityValue(Document instance, String entityName,Entity entityDefinition) {
		super();
		if(StringUtils.isEmpty(entityName)) {
			throw new IllegalArgumentException("EntityName cannot be empty.");
		}
		
		if(entityDefinition == null) {
			throw new IllegalArgumentException("EntityDefinition cannot be null.");
		}
		
		
		this.instance = instance;
		this.entityName = entityName;
		this.entityDefinition = entityDefinition;
	}

	@Override
	public String getEntityName() {
		return entityName;
	}

	@Override
	public Object getInstance() {
		return instance;
	}

	@Override
	public void setInstance(Object value) {
		if(value instanceof Document) {
			this.instance = (Document) value;	
		}
	}

	@Override
	public Entity getEntityDefinition() {
		return entityDefinition;
	}

}
