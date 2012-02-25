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
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.openappengine.gui.engine.context.factory.DefaultGuiDefinitionReader;
import com.openappengine.gui.engine.context.factory.FactoryConstants;
import com.openappengine.gui.engine.context.factory.FactoryFinder;
import com.openappengine.gui.engine.context.factory.GuiContextFactory;
import com.openappengine.gui.engine.context.factory.WebContextFactoryInitializationCallback;
import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.ext.ExternalContext;
import com.openappengine.gui.engine.core.ext.ExternalWebContext;
import com.openappengine.gui.engine.core.widget.context.HttpServletWidgetProcessorContextFactory;
import com.openappengine.gui.engine.core.widget.context.WidgetProcessorContextFactory;
import com.openappengine.gui.engine.core.widget.processor.WidgetProcessor;
import com.openappengine.gui.engine.core.widget.processor.factory.WidgetProcessorFactory;
import com.openappengine.gui.web.support.GuiApplicationContextAwareHttpServletRequest;

/**
 * Servlet implementation class GuiEngineDispatcherSevlet
 */
public class GuiEngineDispatcherSevlet extends HttpServlet {
	
	//Create only ONE instance of the logger.
	protected static final Logger logger = Logger.getLogger(GuiEngineDispatcherSevlet.class);
	
	public static final String GUI_WEB_APPLICATION_CONTEXT = "GUI_WEB_APPLICATION_CONTEXT";
	
	private String defaultScreenFileExtension = ".screen";
	
	private String screenFileExtension;

	private static final String FILE_EXTENSION = ".xml";

	private static final long serialVersionUID = 1L;

	private GuiContextFactory contextFactory;
	
	private ServletContext servletContext;

	private String path = "/home";
	
	private WidgetProcessorContextFactory widgetProcessorContextFactory = new HttpServletWidgetProcessorContextFactory();

	private WidgetProcessorFactory widgetProcessorFactory = new WidgetProcessorFactory();;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuiEngineDispatcherSevlet() {
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
		GuiEngineContext guiEngineContext = null;
		
		Resource resource = createXmlScreenUrlResouce(httpServletRequest);
		ExternalContext externalContext = new ExternalWebContext(httpServletRequest);
		
		if(httpServletRequest.getMethod().equals("GET")) {
			//Create New GUI Application Context from Factory.
			guiEngineContext = createGuiApplicationContext(resource);
			guiEngineContext.setExternalContext(externalContext);
			
			//Post Restore
			//contextFactory.processLifecylePostRestoreProcessing(guiEngineContext);
			
			//Pre-Render Actions.
			contextFactory.processLifecylePreRenderActions(guiEngineContext);
			
			//Transform Widgets.
			contextFactory.processLifecycleTransformWidgetsEvent(guiEngineContext);
		} else if (httpServletRequest.getMethod().equals("POST")) {

			//Restore the Context from the Factory.
			guiEngineContext = contextFactory.getApplicationContext(resource);
			guiEngineContext.setExternalContext(externalContext);
			
			//Clear the Context Messages
			guiEngineContext.getMessageContext().clearAllMessages();
			
			//Process WidgetType Submission.
			doProcessWidgetPost(httpServletRequest, guiEngineContext);
			
		}
		
		httpServletRequest.setAttribute("currentURL", httpServletRequest.getRequestURL());
		httpServletRequest.setAttribute("messageContext", guiEngineContext.getMessageContext());
		httpServletRequest.setAttribute("guiEngineContext", guiEngineContext);
		
		//contextFactory.processLifecycleInitializedEvent(guiApplicationContext);
		
		contextFactory.refreshMessages(guiEngineContext);
		
		httpServletRequest.setAttribute(ServletConstants.GUI_WEB_APPLICATION_CONTEXT, guiEngineContext);
		contextWrappedRequest = new GuiApplicationContextAwareHttpServletRequest(guiEngineContext, httpServletRequest);
		
		//Do Dispatch
		doDispatch(contextWrappedRequest,httpServletResponse);
	}

	/**
	 * @param request
	 * @param guiApplicationContext
	 * @throws LinkageError
	 */
	private void doProcessWidgetPost(HttpServletRequest request,GuiEngineContext guiApplicationContext) throws LinkageError {
		String widgetType = request.getParameter("widgetType");
		
		//Get WidgetProcessor Based on the WidgetType Type.
		WidgetProcessor widgetProcessor = widgetProcessorFactory.
					getWidgetProcessor(guiApplicationContext.getExternalContext(),
									   guiApplicationContext.getELContext(),
									   guiApplicationContext.getTransitionEventListener(),
									   guiApplicationContext.getMessageContext(),widgetType);
		
		//Process WidgetType
		widgetProcessor.processWidget();
	}

	/**
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 */
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
	protected GuiEngineContext createGuiApplicationContext(Resource resource) throws MalformedURLException {
		GuiEngineContext applicationContext = contextFactory.createGuiEngineContext(resource);
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

	/**
	 * @return the widgetProcessorContextFactory
	 */
	protected WidgetProcessorContextFactory getWidgetProcessorContextFactory() {
		return widgetProcessorContextFactory;
	}

	/**
	 * @param widgetProcessorContextFactory the widgetProcessorContextFactory to set
	 */
	public void setWidgetProcessorContextFactory(WidgetProcessorContextFactory widgetProcessorContextFactory) {
		if(widgetProcessorContextFactory == null) {
			throw new IllegalArgumentException("WidgetProcessorContextFactory cannot be null.");
		} else if (!HttpServletWidgetProcessorContextFactory.class
						.isAssignableFrom(widgetProcessorContextFactory.getClass())) {
			throw new IllegalArgumentException(
					"WidgetProcessorContext cannot be initialized. The WidgetProcessorContextFactory is either null or not extending the HttpServletWidgetProcessorContextFactory class.");
		}
		this.widgetProcessorContextFactory = widgetProcessorContextFactory;
	}

}
