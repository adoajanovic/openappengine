/**
 * 
 */
package com.openappengine.web.facade;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author hrishi
 *
 */
public interface WebFacade {
    
    Map<String, Object> getParameters();
    
    HttpServletRequest getRequest();
    
    Map<String, Object> getRequestAttributes();
    
    Map<String, Object> getRequestParameters();
    
    FacesContext getFacesContextCurrentInstance();
    
    String getRequestCharacterEncoding();
    
    Object encode(Object inputObject);
    
    String encodeActionUrl(String url);

    HttpServletResponse getResponse();

    HttpSession getSession();
    
    Map<String, Object> getSessionAttributes();

    ServletContext getServletContext();
    
    Map<String, Object> getApplicationAttributes();

    Map<String, Object> getErrorParameters();

}