/**
 * 
 */
package com.openappengine.gui.web.servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.context.GuiApplicationContext;

/**
 * @author hrishi
 * since Jan 21, 2012
 */
public class XmlContextFreemarkerView extends FreeMarkerView {

	@Override
	protected void exposeHelpers(Map<String, Object> model,HttpServletRequest request) throws Exception {
		super.exposeHelpers(model, request);
		GuiApplicationContext guiApplicationContext = (GuiApplicationContext) request.getAttribute(ServletConstants.GUI_WEB_APPLICATION_CONTEXT);
		if(guiApplicationContext != null) {
			GuiRootComponent root = guiApplicationContext.getUIRoot();
			model.put("uiRoot", root);
			
			//Add Model Map to the Request Context.
			model.putAll(guiApplicationContext.getExternalContext().getModelMap());
		}
	}

	@Override
	public void setUrl(String url) {
		super.setUrl(url);
	}
	
	
}
