/**
 * 
 */
package com.openappengine.facade.ui.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

import com.openappengine.facade.entity.EntityFacade;
import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.entity.context.EntityFacadeContext;
import com.openappengine.facade.entity.definition.EntityDefinition;
import com.openappengine.facade.entity.definition.FieldDefinition;
import com.openappengine.facade.ui.common.EntityReference.IncludeFields;
import com.openappengine.facade.ui.common.FieldReference;
import com.openappengine.facade.ui.form.FormDefinition;
import com.openappengine.facade.ui.form.FormDefinitionCache;
import com.openappengine.facade.ui.form.instance.FormInstance;

/**
 * @author hrishikesh.joshi
 * @Dec 15, 2011
 */
public class FormFacadeImpl implements FormFacade {

	private static final long serialVersionUID = 1L;
	
	private FormDefinitionCache formDefinitionCache;
	
	private EntityFacade entityFacade = EntityFacadeContext.getEntityFacade();
	
	public FormDefinition getFormDefinition(String name) {
		return formDefinitionCache.getFormDefinition(name);
	}

	protected FormDefinitionCache getFormDefinitionCache() {
		return formDefinitionCache;
	}

	public void setFormDefinitionCache(FormDefinitionCache formDefinitionCache) {
		this.formDefinitionCache = formDefinitionCache;
	}
	
	protected FormInstance getEmptyValueFormInstance(String formName) {
		FormDefinition formDefinition = getFormDefinition(formName);
		Assert.notNull(formDefinition,"FormDefinition not found for form-name:" + formName);
		
		FormInstance formInstance = new FormInstance();
		formInstance.setFormDefinition(formDefinition);
		
		List<FieldDefinition> fieldDefinitions = new ArrayList<FieldDefinition>();
		EntityDefinition entityDefinition = entityFacade.findEntityDefinition(formName);
		
		if(formDefinition.getEntityReference().getIncludeFields().equals(IncludeFields.REFERENCED)) {
			List<FieldReference> fieldReferences = formDefinition.getFieldLayout().getFieldReferences();
			for (FieldReference fieldReference : fieldReferences) {
				FieldDefinition fieldDefinition = entityDefinition.getFieldDefinition(fieldReference.getFieldName());
				fieldDefinitions.add(fieldDefinition);
			}
		} else if(formDefinition.getEntityReference().getIncludeFields().equals(IncludeFields.AUTO)) {
			fieldDefinitions.addAll(entityDefinition.getFields());
		} //TODO - Add PK and Non-PK logic
		
		formInstance.setFieldDefinitions(fieldDefinitions);
		return formInstance;
	}

	public FormInstance getFormInstance(String formName) {
		FormInstance formInstance = getEmptyValueFormInstance(formName);
		String entityName = formInstance.getFormDefinition().getEntityReference().getEntityName();
		EntityValue entityValue = entityFacade.createEntityValue(entityName);
		formInstance.setEntityValue(entityValue);
		return formInstance;
	}
	
	public FormInstance getFormInstance(String formName,Map<String,Object> properties) {
		FormInstance formInstance = getFormInstance(formName);
		EntityValue entityValue = entityFacade.findUniqueEntityValue(formInstance.getFormDefinition().getName(), properties);
		formInstance.setEntityValue(entityValue);
		return formInstance;
	}

	public FormInstance getFormInstance(String formName, Serializable entityId) {
		FormInstance formInstance = getEmptyValueFormInstance(formName);
		String entityName = formInstance.getFormDefinition().getEntityReference().getEntityName();
		EntityValue entityValue = entityFacade.createEntityValue(entityName,entityId);
		formInstance.setEntityValue(entityValue);
		return formInstance;
	}

}
