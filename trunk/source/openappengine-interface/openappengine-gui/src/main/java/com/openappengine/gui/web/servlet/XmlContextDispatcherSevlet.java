package com.openappengine.gui.web.servlet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map.Entry;
import java.util.Set;

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
import org.springframework.ui.ModelMap;
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
		
		RequestAttributes oldRequestAttributes = RequestContextHolder.getRequestAttributes();
		
		RequestAttributes currentRequestAttributes = new ServletRequestAttributes(httpServletRequest);
		RequestContextHolder.setRequestAttributes(currentRequestAttributes);
		
		try {
			httpServletRequest.getParameter("codeTypeValue");
			
			StringBuffer requestURL = request.getRequestURL();
			if(requestURL.charAt(requestURL.length()-1) == '/') {
				requestURL.deleteCharAt(requestURL.length()-1);
			}
			String queryString = request.getQueryString();
			requestURL.append("?").append(queryString);
			
			request.setAttribute("currentURL", requestURL);
			
			doService(httpServletRequest, httpServletResponse);
		} catch (Throwable e) {
			// TODO: use configurable exception handler here..
			logger.error("Request Processing Failure.",e);
		}
	}

	private void doService(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
			throws MalformedURLException, ServletException, IOException {
		
		//Create GUI Application Context.
		GuiApplicationContext guiApplicationContext = createGuiApplicationContext(httpServletRequest);
		
		//Wrap the Gui Application Context inside the Request.
		//TODO - Search for a replaceable change for this. Introduce Attributes if needed.
		GuiApplicationContextAwareHttpServletRequest contextWrappedRequest = new GuiApplicationContextAwareHttpServletRequest(
				guiApplicationContext, httpServletRequest);
		
		//In Case of a post handle the action execution.
		if(httpServletRequest.getMethod().equals("POST")) {
			String parameter = httpServletRequest.getParameter("codeTypeValue");
		}
		
		contextFactory.processLifecyleRestoreProcessing(guiApplicationContext);
		
		contextFactory.processLifecycleInitializedEvent(guiApplicationContext);
		
		mergeGuiContextModelAttributes(httpServletRequest,guiApplicationContext);
		
		//Set the Context in the Attribute.
		httpServletRequest.setAttribute(ServletConstants.GUI_WEB_APPLICATION_CONTEXT, guiApplicationContext);
		
		//Do Dispatch
		doDispatch(httpServletRequest, httpServletResponse,contextWrappedRequest);
	}

	/**
	 * @param httpServletRequest
	 * @param guiApplicationContext
	 */
	protected void mergeGuiContextModelAttributes(
			HttpServletRequest httpServletRequest,
			GuiApplicationContext guiApplicationContext) {
		ModelMap modelMap = guiApplicationContext.getExternalContext().getModelMap();
		if(modelMap != null) {
			Set<Entry<String,Object>> entrySet = modelMap.entrySet();
			for (Entry<String, Object> entry : entrySet) {
				String key = entry.getKey();
				Object value = entry.getValue();
				httpServletRequest.setAttribute(key, value);
			}
		}
	}

	protected void doDispatch(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			GuiApplicationContextAwareHttpServletRequest contextWrappedRequest)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = getRequestDispatcher(httpServletRequest);
		requestDispatcher.forward(contextWrappedRequest, httpServletResponse);
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
