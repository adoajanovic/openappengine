package com.openappengine.gui.web.support;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import com.openappengine.facade.context.factory.DefaultGuiDefinitionReader;
import com.openappengine.facade.context.factory.FactoryConstants;
import com.openappengine.facade.context.factory.FactoryFinder;
import com.openappengine.facade.context.factory.GuiContextFactory;
import com.openappengine.facade.context.factory.WebContextFactoryInitializationCallback;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.core.ext.ExternalWebContext;

/**
 * Servlet Filter implementation class XmlContextProcessingFilter
 */
public class XmlContextProcessingFilter implements Filter {
	
	private final Logger logger = Logger.getLogger(getClass());
	
	private GuiContextFactory contextFactory;
	
	private ServletContext servletContext;

	private String path;
	
    /**
     * Default constructor. 
     */
    public XmlContextProcessingFilter() {
    	logger.info("Initializing XmlScreenProcessing Filter");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Create a {@link UrlResource} instance from the request. Used by the {@link DefaultGuiDefinitionReader}
	 * @param request
	 * @return
	 * @throws MalformedURLException
	 */
	protected Resource createXmlScreenUrlResouce(HttpServletRequest request) throws MalformedURLException {
		String requestURI = request.getRequestURI();
		String xmlScreenUrl = requestURI.replace(".screen", ".xml");
		if(xmlScreenUrl.startsWith(servletContext.getContextPath())) {
			xmlScreenUrl = xmlScreenUrl.substring(servletContext.getContextPath().length());
			xmlScreenUrl = servletContext.getRealPath(xmlScreenUrl);
		}
		Resource resource = new FileSystemResource(xmlScreenUrl);
		return resource;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		//Create GUI Application Context.
		GuiApplicationContext guiApplicationContext = createGuiApplicationContext(httpServletRequest);
		
		//Wrap the Gui Application Context inside the Request.
		RequestDispatcher requestDispatcher = getRequestDispatcher(httpServletRequest);
		GuiApplicationContextAwareHttpServletRequest contextWrappedRequest = new GuiApplicationContextAwareHttpServletRequest(
				guiApplicationContext, httpServletRequest);
		
		requestDispatcher.forward(contextWrappedRequest, httpServletResponse);
	}

	/**
	 * @param httpServletRequest
	 * @return
	 */
	protected RequestDispatcher getRequestDispatcher(HttpServletRequest httpServletRequest) {
		//forward to a configured path which points to the appropriate ftl.
		path = "/home/";
		RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(path);
		return requestDispatcher;
	}

	/**
	 * @param httpServletRequest
	 * @return 
	 * @throws MalformedURLException
	 */
	protected GuiApplicationContext createGuiApplicationContext(HttpServletRequest httpServletRequest) throws MalformedURLException {
		Resource resource = createXmlScreenUrlResouce(httpServletRequest);
		ExternalContext externalContext = new ExternalWebContext(httpServletRequest);
		GuiApplicationContext applicationContext = contextFactory.createGuiApplicationContext(resource, externalContext);
		return applicationContext;
	}

	/**
	 *  Initialize the GUI Application Context Factory.
	 */
	protected void initializeGuiContextFactory() {
		contextFactory = (GuiContextFactory) FactoryFinder.getFactory(FactoryConstants.XML_SCREEN_APPLICATION_CONTEXT_FACTORY, new WebContextFactoryInitializationCallback());
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.servletContext = fConfig.getServletContext();
		initializeGuiContextFactory();
	}
}
