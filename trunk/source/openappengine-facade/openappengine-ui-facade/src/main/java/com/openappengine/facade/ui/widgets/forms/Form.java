package com.openappengine.facade.ui.widgets.forms;

import java.io.Serializable;

import com.openappengine.facade.ui.common.EntityReference;
import com.openappengine.facade.ui.common.RenderMode;
import com.openappengine.facade.ui.form.FieldLayout;
import com.openappengine.facade.ui.form.FormType;
import com.openappengine.facade.ui.widgets.Widget;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @author hrishikesh.joshi
 * @Dec 15, 2011
 */
@XStreamAlias("form")
public class Form extends Widget implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityReference entityReference;

	private FieldLayout fieldLayout = FieldLayout.getDefault();

	private RenderMode renderMode = RenderMode.READ_ONLY;

	@XStreamAsAttribute
	@XStreamAlias("form-type")
	private FormType formType = FormType.SIMPLE;
	
	public Form() {
		setType("simple-form");
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
}