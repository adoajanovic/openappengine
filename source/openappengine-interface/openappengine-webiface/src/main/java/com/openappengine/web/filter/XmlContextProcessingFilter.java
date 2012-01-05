package com.openappengine.web.filter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.io.UrlResource;

import com.openappengine.facade.context.factory.DefaultGuiDefinitionReader;
import com.openappengine.facade.context.factory.FactoryConstants;
import com.openappengine.facade.context.factory.FactoryFinder;
import com.openappengine.facade.context.factory.GuiContextFactory;
import com.openappengine.facade.context.factory.WebContextFactoryInitializationCallback;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.core.ext.ExternalWebContext;
import com.openappengine.web.request.GuiApplicationContextAwareHttpServletRequest;

/**
 * Servlet Filter implementation class XmlContextProcessingFilter
 */
public class XmlContextProcessingFilter implements Filter {
	
	private final Logger logger = Logger.getLogger(getClass());
	
	private FilterConfig filterConfig;

	private GuiContextFactory contextFactory;

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
	protected UrlResource createXmlScreenUrlResouce(HttpServletRequest request) throws MalformedURLException {
		String requestURI = request.getRequestURI();
		requestURI = requestURI.replace(".screen", ".xml");
		StringBuffer path = request.getRequestURL();
		String xmlScreenUrl = path.toString().replace(".screen", ".xml");
		UrlResource urlResource = new UrlResource(xmlScreenUrl);
		return urlResource;
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
		
		//
		requestDispatcher.forward(contextWrappedRequest, httpServletResponse);
	}

	/**
	 * @param httpServletRequest
	 * @return
	 */
	protected RequestDispatcher getRequestDispatcher(HttpServletRequest httpServletRequest) {
		path = "/containers/ScreenContainer.iface";
		RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(path);
		return requestDispatcher;
	}

	/**
	 * @param httpServletRequest
	 * @return 
	 * @throws MalformedURLException
	 */
	protected GuiApplicationContext createGuiApplicationContext(HttpServletRequest httpServletRequest) throws MalformedURLException {
		UrlResource urlResource = createXmlScreenUrlResouce(httpServletRequest);
		ExternalContext externalContext = new ExternalWebContext(httpServletRequest);
		GuiApplicationContext applicationContext = contextFactory.createGuiApplicationContext(urlResource, externalContext);
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
		this.filterConfig = fConfig;
		
		initializeGuiContextFactory();
	}

}
