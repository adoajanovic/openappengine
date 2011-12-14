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

/**
 * @author hrishikesh.joshi
 *
 */
public class SetTagHandler extends TagHandler {
	
    private final TagAttribute value;

    private final TagAttribute var;

	/**
	 * @param config
	 */
	public SetTagHandler(TagConfig config) {
		super(config);
		this.value = this.getRequiredAttribute("value");
        this.var = this.getRequiredAttribute("var");
	}

	/* (non-Javadoc)
	 * @see javax.faces.view.facelets.FaceletHandler#apply(javax.faces.view.facelets.FaceletContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void apply(FaceletContext ctx, UIComponent parent) throws IOException {
		Object oValue = this.value.getObject(ctx);
        ctx.setAttribute(var.getValue(ctx), oValue);
	}

}
