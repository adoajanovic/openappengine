package com.openappengine.facade.ui.widgets.forms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.Assert;

import com.openappengine.facade.entity.EntityFacade;
import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.entity.context.EntityFacadeContext;
import com.openappengine.facade.entity.definition.EntityDefinition;
import com.openappengine.facade.entity.definition.FieldDefinition;
import com.openappengine.facade.ui.common.EntityReference;
import com.openappengine.facade.ui.common.EntityReference.IncludeFields;
import com.openappengine.facade.ui.common.FieldReference;
import com.openappengine.facade.ui.common.RenderMode;
import com.openappengine.facade.ui.form.FieldLayout;
import com.openappengine.facade.ui.form.FormType;
import com.openappengine.facade.ui.params.Params;
import com.openappengine.facade.ui.widgets.Widget;

/**
 * @author hrishikesh.joshi
 * @Dec 15, 2011
 */
public class Form extends Widget implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityReference entityReference;

	private FieldLayout fieldLayout = FieldLayout.getDefault();

	private RenderMode renderMode = RenderMode.READ_ONLY;
	
	private FormType formType = FormType.SIMPLE;
	
	private FormValueHolder formValueHolder;
	
	private Params formParams = new Params();
	
	private EntityValue entityValue;
	
	private List<FieldDefinition> fields;
	
	private transient EntityFacade entityFacade = EntityFacadeContext.getEntityFacade();
	
	public Form() {
		setType("simple-form");
		formValueHolder = new FormValueHolder(this);
	}

	public FieldLayout getFieldLayout() {
		return fieldLayout;
	}

	public void setFieldLayout(FieldLayout fieldLayout) {
		this.fieldLayout = fieldLayout;
	}

	public RenderMode getRenderMode() {
		return renderMode;
	}

	public void setRenderMode(RenderMode renderMode) {
		this.renderMode = renderMode;
	}

	public FormType getFormType() {
		return formType;
	}

	public void setFormType(FormType formType) {
		this.formType = formType;
	}

	public EntityReference getEntityReference() {
		return entityReference;
	}

	public void setEntityReference(EntityReference entityReference) {
		this.entityReference = entityReference;
	}

	public EntityValue getEntityValue() {
		if(entityValue == null) {
			Map<String, Object> entityRequestParams = extractFormParameters();
			formParams.setParameterMap(entityRequestParams);
			entityValue = (EntityValue) formValueHolder.getValue();
		}
		
		return entityValue;
	}

	/**
	 * @return
	 */
	protected Map<String, Object> extractFormParameters() {
		Map<String, String[]> requestParameterMap = getParentScreen().getRequestParameters();
		Map<String,Object> entityRequestParams = new HashMap<String, Object>();
		
		if(requestParameterMap != null) {
			EntityDefinition ed = entityFacade.findEntityDefinition(entityReference.getEntityName());
			Assert.notNull(ed,"Entity Definition not found for entity-name " + entityReference.getEntityName());
			Set<String> requestParams = requestParameterMap.keySet();
			for (String requestParam : requestParams) {
				if(ed.getFieldDefinition(requestParam) != null) {
					FieldDefinition fieldDefinition = ed.getFieldDefinition(requestParam);
					Assert.notNull(fieldDefinition,"Field Definition not found for field-ref:" + requestParam);
					String[] values = requestParameterMap.get(requestParam);
					entityRequestParams.put(fieldDefinition.getName(), values[0]);
				}
			}
		}
		return entityRequestParams;
	}

	public void setEntityValue(EntityValue entityValue) {
		this.entityValue = entityValue;
	}
	
	private List<FieldDefinition> getFieldDefinitions() {
		List<FieldDefinition> fields = null;
		EntityDefinition entityDefinition = getEntityValue().getEntityDefinition();
		fields = entityDefinition.getFields();
		if(entityReference.getIncludeFields().equals(IncludeFields.AUTO)) {
			//TODO - Add a delegate to fetch all the entities from hibernate.
			return fields;
		} else if(entityReference.getIncludeFields().equals(IncludeFields.REFERENCED)) {
			fields = new ArrayList<FieldDefinition>();
			List<FieldReference> fieldReferences = getFieldLayout().getFieldReferences();
			if(fieldReferences != null) {
				for (FieldReference fieldReference : fieldReferences) {
					String fieldName = fieldReference.getFieldName();
					fields.add(entityDefinition.getFieldDefinition(fieldName));
				}
			}
		} //TODO - Handle PK and non-pk conditions.
		return fields;
	}

	public List<FieldDefinition> getFields() {
		if(fields == null) {
			fields = getFieldDefinitions();
		}
		return fields;
	}

	public void setFields(List<FieldDefinition> fields) {
		this.fields = fields;
	}

	public Params getFormParams() {
		return formParams;
	}

	public void setFormParams(Params formParams) {
		this.formParams = formParams;
	}
}