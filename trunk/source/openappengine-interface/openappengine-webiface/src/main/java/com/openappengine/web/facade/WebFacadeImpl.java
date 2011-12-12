/**
 * 
 */
package com.openappengine.web.facade;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author h.shrikant.joshi
 *
 */
public class WebFacadeImpl implements WebFacade {

	/* (non-Javadoc)
	 * @see com.openappengine.web.facade.WebFacade#getParameters()
	 */
	@Override
	public Map<String, Object> getParameters() {
		return getExternalContext().getRequestMap();
	}

	/* (non-Javadoc)
	 * @see com.openappengine.web.facade.WebFacade#getRequest()
	 */
	@Override
	public HttpServletRequest getRequest() {
		ExternalContext externalContext = getFacesContextCurrentInstance().getExternalContext();
		return (HttpServletRequest) externalContext.getRequest();
	}

	protected ExternalContext getExternalContext() {
		return getFacesContextCurrentInstance().getExternalContext();
	}
	
	/**
	 * @return
	 */
	public FacesContext getFacesContextCurrentInstance() {
		return FacesContext.getCurrentInstance();
	}

	/* (non-Javadoc)
	 * @see com.openappengine.web.facade.WebFacade#getRequestAttributes()
	 */
	@Override
	public Map<String, Object> getRequestAttributes() {
		//TODO
		return null;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.web.facade.WebFacade#getRequestParameters()
	 */
	@Override
	public Map<String, Object> getRequestParameters() {
		return getExternalContext().getRequestMap();
	}

	/* (non-Javadoc)
	 * @see com.openappengine.web.facade.WebFacade#getRequestCharacterEncoding()
	 */
	@Override
	public String getRequestCharacterEncoding() {
		return getExternalContext().getRequestCharacterEncoding();
	}

	/* (non-Javadoc)
	 * @see com.openappengine.web.facade.WebFacade#encode(java.lang.Object)
	 */
	@Override
	public Object encode(Object inputObject) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.web.facade.WebFacade#encodeActionUrl(java.lang.String)
	 */
	@Override
	public String encodeActionUrl(String url) {
		return getExternalContext().encodeActionURL(url);
	}

	/* (non-Javadoc)
	 * @see com.openappengine.web.facade.WebFacade#getResponse()
	 */
	@Override
	public HttpServletResponse getResponse() {
		return (HttpServletResponse) getExternalContext().getResponse();
	}

	/* (non-Javadoc)
	 * @see com.openappengine.web.facade.WebFacade#getSession()
	 */
	@Override
	public HttpSession getSession() {
		return (HttpSession) getExternalContext().getSession(false);
	}

	/* (non-Javadoc)
	 * @see com.openappengine.web.facade.WebFacade#getSessionAttributes()
	 */
	@Override
	public Map<String, Object> getSessionAttributes() {
		return getExternalContext().getSessionMap();
	}

	/* (non-Javadoc)
	 * @see com.openappengine.web.facade.WebFacade#getServletContext()
	 */
	@Override
	public ServletContext getServletContext() {
		//TODO
		return null;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.web.facade.WebFacade#getApplicationAttributes()
	 */
	@Override
	public Map<String, Object> getApplicationAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.web.facade.WebFacade#getErrorParameters()
	 */
	@Override
	public Map<String, Object> getErrorParameters() {
		// TODO Auto-generated method stub
		return null;
	}

}
