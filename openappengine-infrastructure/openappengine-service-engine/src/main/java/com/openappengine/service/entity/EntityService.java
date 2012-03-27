/**
 * 
 */
package com.openappengine.service.entity;

import com.openappengine.entity.EntityEngineFacade;
import com.openappengine.entity.api.ValueEntity;
import com.openappengine.entity.context.EntityEngineFacadeContext;
import com.openappengine.service.AbstractDomainService;

/**
 * @author hrishikesh.joshi
 * @since  Mar 13, 2012
 *
 */
public class EntityService extends AbstractDomainService {
	
	private String entityName;
	
	private ValueEntity valueEntity;
	
	/**
	 * Make EntityValue by Entity Name
	 */
	public void makeValueEntity() {
		EntityEngineFacade facade = EntityEngineFacadeContext.getEntityFacade();
		valueEntity = facade.makeValueEntity(getEntityName());
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public ValueEntity getValueEntity() {
		return valueEntity;
	}

	public void setValueEntity(ValueEntity valueEntity) {
		this.valueEntity = valueEntity;
	}

}
