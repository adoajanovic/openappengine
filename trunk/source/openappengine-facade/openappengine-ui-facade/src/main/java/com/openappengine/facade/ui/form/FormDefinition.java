/**
 * 
 */
package com.openappengine.facade.ui.form;

import com.openappengine.facade.model.EntityReference;
import com.openappengine.facade.model.RenderMode;

/**
 * @author hrishikesh.joshi
 * @Dec 15, 2011
 */
public class FormDefinition {
	
	private String name;
	
	private EntityReference entityReference;
	
	private FieldLayout fieldLayout = FieldLayout.getDefault();
	
	private RenderMode renderMode = RenderMode.READ_ONLY;
	
	private FormType formType = FormType.SIMPLE;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EntityReference getEntityReference() {
		return entityReference;
	}

	public void setEntityReference(EntityReference entityReference) {
		this.entityReference = entityReference;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormDefinition other = (FormDefinition) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public FieldLayout getFieldLayout() {
		return fieldLayout;
	}

	public void setFieldLayout(FieldLayout fieldLayout) {
		this.fieldLayout = fieldLayout;
	}
}
