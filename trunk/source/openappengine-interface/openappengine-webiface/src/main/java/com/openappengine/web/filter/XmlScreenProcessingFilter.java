package com.openappengine.web.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.io.UrlResource;
import org.springframework.web.util.WebUtils;

import com.openappengine.facade.context.factory.DefaultGuiDefinitionReader;
import com.openappengine.facade.ui.params.Param;
import com.openappengine.facade.ui.params.Parameters;
import com.openappengine.facade.ui.screen.Screen;

/**
 * Servlet Filter implementation class XmlScreenProcessingFilter
 */
public class XmlScreenProcessingFilter implements Filter {
	
	private final Logger logger = Logger.getLogger(getClass());
	
	private FilterConfig filterConfig;
	
    /**
     * Default constructor. 
     */
    public XmlScreenProcessingFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {/*
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		
		// TODO - Handle Input XML Processing and create a Screen
		// Definition/Screen Renderer so that the JSF Servlet can render the
		// Component tree from the UI Components and the Screen Definition. 
		
		//TODO - Delegate Handle Request URI to XML Screen Location Mapping in a seperate class.
		String requestURI = httpServletRequest.getRequestURI();
		
		requestURI = requestURI.replace(".screen", ".xml");
		
		//Create the Resource instance.
		UrlResource urlResource = createXmlScreenUrlResouce(httpServletRequest);
		
		urlResource.toString();
		
		if(requestURI.startsWith("/openappengine-webiface")) {
			requestURI = requestURI.replace("/openappengine-webiface", "");
			requestURI = requestURI.substring(0, requestURI.indexOf('?')!=-1?requestURI.indexOf('?'):requestURI.length());
		}
		
		//TODO - Configurable extension
		String realPath;
		
		try {
			realPath = WebUtils.getRealPath(filterConfig.getServletContext(), requestURI);
			File f = new File(realPath);
			if(f.exists()) {
				InputStream is = new FileInputStream(f);
				XmlScreenDefinitionReader reader = new XmlScreenDefinitionReader(null);
				final Screen screen = reader.readScreenDefinition(is);
				is.close();
				
				//TODO - Handle Request Params for this screen and set the Query Params on individual forms by name.
				Map requestParameterMap = httpServletRequest.getParameterMap();
				
				// TODO - Set the current instance from a sub-class such that
				// getCurrentInstance would return the same instance in one
				// thread.
				
				ScreenContext screenContext = new ScreenContext() ;
				
				//TODO - Handle Screen Parameters 
				if(screen != null) {
					Parameters screenParameters = screen.getScreenParameters();
					if(screenParameters != null && !screenParameters.isEmpty()) {
						if(screenParameters.getParameterNames() != null) {
							for(Param screenParam : screenParameters.getParameterNames()) {
									String[] value = (String[]) requestParameterMap.get(screenParam.getName());
									if(value != null) {
										screenParameters.setParam(screenParam, value[0]);
										screen.putVariable(screenParam.getName(), value[0]);
									} else {
										//TODO - Handle required field missing condition.
										if(screenParam.isRequired()) {
											throw new RuntimeException("Missing required parameter " + screenParam.getName() + " for screen: " + requestURI + ".");
									}
								}
							}
						}
					}
				}
				
				screenContext.setScreen(screen);
				ScreenContext.setCurrentInstance(screenContext);
				
				ScreenContextThreadLocal.set(screenContext);
				 
			}
		} catch(Exception e) {
			logger.error("Exception encountered while reading the screen at the URI:" + requestURI);
			//TODO - Add a ProblemReporter here.
		}
		
		//TODO - Configurable Container XHTML location
		httpServletRequest.getRequestDispatcher("/containers/ScreenContainer.iface").forward(httpServletRequest, httpServletResponse);
		
		// pass the request along the filter chain
		//chain.doFilter(request, response);
	 */
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
