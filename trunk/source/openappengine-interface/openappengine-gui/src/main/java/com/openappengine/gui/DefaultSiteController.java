package com.openappengine.gui;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.component.ui.container.PageContentComponent;
import com.openappengine.facade.core.component.ui.container.WidgetsComponent;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.gui.web.support.GuiApplicationContextAwareHttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DefaultSiteController {
	
	private static final Logger logger = LoggerFactory.getLogger(DefaultSiteController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/{name}")
	public String handleRequest(HttpServletRequest request,@PathVariable("name") String  name,Locale locale, Model model) {
		
		if(GuiApplicationContextAwareHttpServletRequest.class.isAssignableFrom(request.getClass())) {
			GuiApplicationContext context = ((GuiApplicationContextAwareHttpServletRequest)request).getGuiApplicationContext();
			if(context != null) {
				GuiRootComponent root = context.getUIRoot();
				model.addAttribute("uiRoot", root);
				
				PageContentComponent pageContent = root.getPageContent();
				if(pageContent != null) {
					List<WidgetsComponent> widgets = pageContent.getWidgets();
					for (WidgetsComponent widget : widgets) {
						List<GuiComponent> childWidgets = widget.getChildComponents();
						for (GuiComponent guiComponent : childWidgets) {
							model.addAttribute(guiComponent.getClass().getName(), guiComponent);			
						}
					}
				}
			}
		}
		
		//TODO - Move to a Login Controller which sets the logged in date
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return name;
	}
	
}
