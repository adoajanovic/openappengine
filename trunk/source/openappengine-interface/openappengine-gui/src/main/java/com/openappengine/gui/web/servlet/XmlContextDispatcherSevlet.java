package com.openappengine.gui.web.servlet;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.openappengine.gui.web.support.GuiApplicationContextAwareHttpServletRequest;

/**
 * Servlet implementation class XmlContextDispatcherSevlet
 */
public class XmlContextDispatcherSevlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private GuiContextFactory contextFactory;
	
	private ServletContext servletContext;

	private String path;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XmlContextDispatcherSevlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.servletContext = config.getServletContext();
		initializeGuiContextFactory();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
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
		
		contextFactory.processLifecyleRestoreProcessing(applicationContext);
		
		contextFactory.processLifecycleInitializedEvent(applicationContext);
		
		return applicationContext;
	}

	/**
	 *  Initialize the GUI Application Context Factory.
	 */
	protected void initializeGuiContextFactory() {
		contextFactory = (GuiContextFactory) FactoryFinder.getFactory(FactoryConstants.XML_SCREEN_APPLICATION_CONTEXT_FACTORY, new WebContextFactoryInitializationCallback());
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

}
