/**
 * 
 */
package com.openappengine.web.entity.tags;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagAttribute;
import javax.faces.view.facelets.TagConfig;
import javax.faces.view.facelets.TagHandler;

import com.openappengine.facade.entity.definition.FieldDefinition;
import com.openappengine.facade.entity.definition.ui.UIField;

/**
 * @author hrishikesh.joshi
 * 
 */
public abstract class IsTypeHandler extends TagHandler {

	private final TagAttribute field;

	/**
	 * @param config
	 */
	public IsTypeHandler(TagConfig config) {
		super(config);
		this.field = this.getRequiredAttribute("field");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.view.facelets.FaceletHandler#apply(javax.faces.view.facelets
	 * .FaceletContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void apply(FaceletContext faceletsContext, UIComponent aParent) throws IOException {
		/* Get the name of the value binding. */
		String tid = this.field.getValue(faceletsContext);
		
		FieldDefinition fieldDefinition = (FieldDefinition) field.getObject(faceletsContext);

		faceletsContext.getVariableMapper().resolveVariable(tid + "_Field").getValue(faceletsContext);
		/*
		 * If the type is a boolean, process the body of the tag.
		 */
		if (isType(fieldDefinition)) {
			this.nextHandler.apply(faceletsContext, aParent);
		}
	}

	/**
	 * 
	 * 
	 * @param type
	 *            type
	 * 
	 * @return true if this is the correct type.
	 */
	protected abstract boolean isType(FieldDefinition fieldDef);

}
