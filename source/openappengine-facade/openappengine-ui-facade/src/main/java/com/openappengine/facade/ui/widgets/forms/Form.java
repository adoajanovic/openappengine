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
import com.openappengine.facade.model.EntityReference;
import com.openappengine.facade.model.FieldReference;
import com.openappengine.facade.model.RenderMode;
import com.openappengine.facade.model.EntityReference.IncludeFields;
import com.openappengine.facade.ui.form.FieldLayout;
import com.openappengine.facade.ui.form.FormType;
import com.openappengine.facade.ui.params.Param;
import com.openappengine.facade.ui.params.Parameters;
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
	
	private Parameters formParams = new Parameters();
	
	private EntityValue entityValue;
	
	private List<FieldDefinition> fields;
	
	private String entityValueRef;
	
	//TODO - Use this instead of Entity Ref
	private String entityName;
	
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
			initEntityValue();
		}
		
		return entityValue;
	}

	/**
	 * 
	 */
	protected void initEntityValue() {
		entityValue = (EntityValue) formValueHolder.getValue();
	}

	//TODO - Move this to an action.
	/**
	 * @return
	 */
	protected Map<Param, Object> extractFormParameters() {
		Map<Param, Object> screenParameters = getParentScreen().getScreenParameters().getParameterMap();
		Map<Param,Object> entityRequestParams = new HashMap<Param, Object>();
		
		if(screenParameters != null) {
			String entityNm = entityReference.getEntityName();
			EntityDefinition ed = entityFacade.findEntityDefinition(entityNm);
			Assert.notNull(ed,"Entity Definition not found for entity-name " + entityNm);
			Set<Param> requestParams = screenParameters.keySet();
			for (Param requestParam : requestParams) {
				if(ed.getFieldDefinition(requestParam.getName()) != null) {
					FieldDefinition fieldDefinition = ed.getFieldDefinition(requestParam.getName());
					Assert.notNull(fieldDefinition,"Field Definition not found for field-ref:" + requestParam);
					entityRequestParams.put(new Param(fieldDefinition.getName()), screenParameters.get(requestParam));
				}
			}
		}
		return entityRequestParams;
	}

	public void setEntityValue(EntityValue entityValue) {
		this.entityValue = entityValue;
	}
	
	private List<FieldDefinition> getFieldDefinitions() {
		List<FieldDefinition> fields = new ArrayList<FieldDefinition>();
		//TODO first do a null check for entity value.
		if(entityValue == null) {
			initEntityValue();
		}
		
		//TODO - Ugly Implementation. EntityValue should be create irrespective of params. TO BE CORRECTED!!
		if(entityValue != null) {
			EntityDefinition entityDefinition = entityValue.getEntityDefinition();
			fields = entityDefinition.getFields();
			if(entityReference != null) {
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
			}
		}
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

	public Parameters getFormParams() {
		return formParams;
	}

	public void setFormParams(Parameters formParams) {
		this.formParams = formParams;
	}

	public String getEntityValueRef() {
		return entityValueRef;
	}

	public void setEntityValueRef(String entityValueRef) {
		this.entityValueRef = entityValueRef;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
}