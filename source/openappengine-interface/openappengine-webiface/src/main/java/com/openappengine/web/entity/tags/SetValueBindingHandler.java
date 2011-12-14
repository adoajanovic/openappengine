/**
 * 
 */
package com.openappengine.web.entity.tags;

import java.io.IOException;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagAttribute;
import javax.faces.view.facelets.TagConfig;
import javax.faces.view.facelets.TagHandler;

import com.openappengine.facade.entity.definition.FieldDefinition;
import com.openappengine.facade.entity.definition.ui.UIField;

/**
 * @author hrishikesh.joshi
 * @Dec 14, 2011
 */
public class SetValueBindingHandler extends TagHandler {

	/** The name of the new variable that this tag defines. */
	private final TagAttribute var;

	/** The actual value binding expression. */
	private final TagAttribute valueBinding;

	/**
	 * Constructor. Set up the attributes for this tag.
	 * 
	 * @param config
	 *            TagConfig
	 */
	public SetValueBindingHandler(final TagConfig config) {
		super(config);
		/* Define var and valueBinding attributes. */
		this.var = this.getRequiredAttribute("var");
		this.valueBinding = this.getRequiredAttribute("valueBinding");
	}

	/**
	 * Apply.
	 * 
	 * @param faceletsContext
	 *            faceletsContext
	 * @param parent
	 *            parent
	 * 
	 * @throws IOException
	 *             IOException
	 */
	public void apply(final FaceletContext faceletsContext, final UIComponent parent) {
		/* Create the ValueExpression from the valueBinding attribute. */
		ValueExpression valueExpression = this.valueBinding.getValueExpression(faceletsContext, Object.class);

		/* Get the name of the new value. */
		String tvar = this.var.getValue(faceletsContext);
		FieldDefinition field = (FieldDefinition) valueExpression.getValue(faceletsContext.getFacesContext().getELContext());

		/*
		 * Put the value binding into the FaceletsContext where we can retrieve
		 * it from other components.
		 */
		faceletsContext.setAttribute(tvar, valueExpression);

		/*
		 * Cache the type so we don't have to look it up in each tag.
		 */
		faceletsContext.setAttribute(tvar+"_Field", field);
	}

}
