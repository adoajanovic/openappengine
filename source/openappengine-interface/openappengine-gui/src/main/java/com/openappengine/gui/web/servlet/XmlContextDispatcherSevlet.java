package com.openappengine.gui.web.servlet;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.openappengine.facade.context.factory.DefaultGuiDefinitionReader;
import com.openappengine.facade.context.factory.FactoryConstants;
import com.openappengine.facade.context.factory.FactoryFinder;
import com.openappengine.facade.context.factory.GuiContextFactory;
import com.openappengine.facade.context.factory.WebContextFactoryInitializationCallback;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.core.ext.ExternalWebContext;
import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.entity.context.EntityFacadeContext;
import com.openappengine.facade.fsm.TransitionEvent;
import com.openappengine.gui.web.support.GuiApplicationContextAwareHttpServletRequest;

/**
 * Servlet implementation class XmlContextDispatcherSevlet
 */
public class XmlContextDispatcherSevlet extends HttpServlet {
	
	protected final Logger logger = Logger.getLogger(getClass());
	
	private String defaultScreenFileExtension = ".screen";
	
	private String screenFileExtension;

	private static final String FILE_EXTENSION = ".xml";

	private static final long serialVersionUID = 1L;

	public static final String GUI_WEB_APPLICATION_CONTEXT = "GUI_WEB_APPLICATION_CONTEXT";

	private GuiContextFactory contextFactory;
	
	private ServletContext servletContext;

	private String path = "/home";
       
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
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws MalformedURLException,
			ServletException, IOException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		RequestAttributes currentRequestAttributes = new ServletRequestAttributes(httpServletRequest);
		RequestContextHolder.setRequestAttributes(currentRequestAttributes);
		
		try {
			request.setAttribute("currentURL", request.getRequestURL());
			doService(httpServletRequest, httpServletResponse);
		} catch (Throwable e) {
			// TODO: use configurable exception handler here..
			logger.error("Request Processing Failure.",e);
		}
	}

	private void doService(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
			throws MalformedURLException, ServletException, IOException {
		HttpServletRequest contextWrappedRequest = httpServletRequest;
		GuiApplicationContext guiApplicationContext = null;
		
		Resource resource = createXmlScreenUrlResouce(httpServletRequest);
		ExternalContext externalContext = new ExternalWebContext(httpServletRequest);
		
		if(httpServletRequest.getMethod().equals("GET")) {
			//Create New GUI Application Context from Factory.
			guiApplicationContext = createGuiApplicationContext(resource, externalContext);
			contextFactory.processLifecyleRestoreProcessing(guiApplicationContext);
			contextFactory.processLifecycleInitializedEvent(guiApplicationContext);
		} else if (httpServletRequest.getMethod().equals("POST")) {
			//Restore the Context from the Factory.
			guiApplicationContext = contextFactory.getApplicationContext(resource);
			String widgetBackingClassName = httpServletRequest.getParameter("widgetClass");
			String widgetId = httpServletRequest.getParameter("widgetId");
			String widgetTransition = httpServletRequest.getParameter("widgetTransition");
			String widgetValueRef = httpServletRequest.getParameter("widgetValueRef");
			String widgetEntityName = httpServletRequest.getParameter("widgetEntityName");
			
			if(!StringUtils.isEmpty(widgetBackingClassName)) {
				try {
					Class<?> formBackingClass = ClassUtils.forName(widgetBackingClassName, getClass().getClassLoader());
					Object bindedInstance = formBackingClass.newInstance();
					ServletRequestDataBinder binder = new ServletRequestDataBinder(bindedInstance);
					//TODO - Validate and bind
					//TODO - If Valid bind.
					
					binder.bind(contextWrappedRequest);
					
					
					EntityValue entityValue = (EntityValue) guiApplicationContext.getELContext().getVariable(widgetValueRef);
					entityValue.setInstance(bindedInstance);
					
					guiApplicationContext.getExternalContext().getModelMap().addAttribute(widgetId, bindedInstance);
					
					guiApplicationContext.getELContext().registerELContextVariable(widgetValueRef, entityValue);
					
					//TODO- Check transition triggered and perform Transition.
					if(StringUtils.isNotEmpty(widgetTransition)) {
						TransitionEvent transitionEvent = new TransitionEvent(widgetTransition,guiApplicationContext.getExternalContext(),guiApplicationContext.getELContext());
						guiApplicationContext.getTransitionEventListener().onApplicationEvent(transitionEvent);
					}
					
				} catch(Exception e) {
					//TODO - Handle
					e.printStackTrace();
				}
				
			}
		}
		
		httpServletRequest.setAttribute(ServletConstants.GUI_WEB_APPLICATION_CONTEXT, guiApplicationContext);
		contextWrappedRequest = new GuiApplicationContextAwareHttpServletRequest(guiApplicationContext, httpServletRequest);
		
		//Do Dispatch
		doDispatch(contextWrappedRequest,httpServletResponse);
	}

	protected void doDispatch(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = getRequestDispatcher(httpServletRequest);
		requestDispatcher.forward(httpServletRequest, httpServletResponse);
	}
	
	/**
	 * @param httpServletRequest
	 * @return
	 */
	protected RequestDispatcher getRequestDispatcher(HttpServletRequest httpServletRequest) {
		RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(path);
		return requestDispatcher;
	}

	/**
	 * @param resource
	 * @param externalContext TODO
	 * @return 
	 * @throws MalformedURLException
	 */
	protected GuiApplicationContext createGuiApplicationContext(Resource resource, ExternalContext externalContext) throws MalformedURLException {
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
	 * Create a {@link UrlResource} instance from the request. Used by the {@link DefaultGuiDefinitionReader}
	 * @param request
	 * @return
	 * @throws MalformedURLException
	 */
	protected Resource createXmlScreenUrlResouce(HttpServletRequest request) throws MalformedURLException {
		String requestURI = request.getRequestURI();
		String extension = StringUtils.isEmpty(screenFileExtension)?defaultScreenFileExtension:screenFileExtension;
		String xmlScreenUrl = requestURI.replace(extension, FILE_EXTENSION);
		if(xmlScreenUrl.startsWith(servletContext.getContextPath())) {
			xmlScreenUrl = xmlScreenUrl.substring(servletContext.getContextPath().length());
			xmlScreenUrl = servletContext.getRealPath(xmlScreenUrl);
		}
		Resource resource = new FileSystemResource(xmlScreenUrl);
		return resource;
	}

	/**
	 * @return the screenFileExtension
	 */
	public String getScreenFileExtension() {
		return screenFileExtension;
	}

	/**
	 * @param screenFileExtension the screenFileExtension to set
	 */
	public void setScreenFileExtension(String screenFileExtension) {
		this.screenFileExtension = screenFileExtension;
	}

}
