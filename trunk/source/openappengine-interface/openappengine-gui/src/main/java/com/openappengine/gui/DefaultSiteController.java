package com.openappengine.gui;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.gui.web.support.GuiApplicationContextAwareHttpServletRequest;
import com.openappengine.model.code.CodeType;

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
				
				StringBuffer requestURL = request.getRequestURL();
				if(requestURL.charAt(requestURL.length()-1) == '/') {
					requestURL.deleteCharAt(requestURL.length()-1);
				}
				String queryString = request.getQueryString();
				requestURL.append("?").append(queryString);
				model.addAttribute("currentURL", requestURL.toString());
				
				//Add Model Map to the Request Context.
				model.addAllAttributes(context.getExternalContext().getModelMap());
			}
		}
		
		//TODO - Move to a Login Controller which sets the logged in date
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return name;
	}
	
	@RequestMapping(value = "/action/{id}")
	public void handleActionRequest(HttpServletRequest request,@PathVariable("id") String id,ModelMap model) {
		logger.info("Action : " + id + " called..");
		Object formBackingObject = bindFormBackingObject(request);
	}

	/**
	 * @param request
	 */
	private Object bindFormBackingObject(HttpServletRequest request) {
		String className = request.getParameter("formBackingClass");
		try {
			Class<?> formBackingClazz = Class.forName(className);
			Object newInstance = formBackingClazz.newInstance();
			ServletRequestDataBinder binder = new ServletRequestDataBinder(newInstance);
			binder.bind(request);
			return newInstance;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
