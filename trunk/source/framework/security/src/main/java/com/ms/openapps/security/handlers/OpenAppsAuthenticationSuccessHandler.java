/**
 * 
 */
package com.ms.openapps.security.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.ms.openapps.security.constants.SecurityWebConstants;
import com.ms.openapps.security.registry.LoggedInUser;
import com.ms.openapps.security.registry.UserContextService;
import com.ms.openapps.util.DateTimeUtil;
import com.ms.openapps.util.UUIDKeyGenerator;

/**
 * @author hrishi
 *
 */
public class OpenAppsAuthenticationSuccessHandler implements
	AuthenticationSuccessHandler {

	private final Logger logger = Logger.getLogger(getClass());
	
	private String targetSuccessUrl = "/welcome.jsf";
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		
		if(authentication!=null && authentication.getPrincipal()!=null && authentication.getPrincipal() instanceof User) {
			User user = (User) authentication.getPrincipal();
			LoggedInUser loggedInUser = new LoggedInUser(user.getUsername(),
					user.getPassword(), user.isAccountNonExpired(),
					user.isAccountNonLocked(), user.isCredentialsNonExpired(),
					user.isEnabled(), DateTimeUtil.nowDate());
			String sessionId = UUIDKeyGenerator.getDefaultUUID();
			request.getSession().setAttribute(SecurityWebConstants.SESSION_ID, sessionId);
			UserContextService.addLoggedInUser(sessionId, loggedInUser);
			logger.debug("Authentication Success Handler invoked for Authentication " + loggedInUser);
		}
		
		response.sendRedirect(request.getContextPath() + targetSuccessUrl);
	}

	/**
	 * @param targetSuccessUrl the targetSuccessUrl to set
	 */
	public void setTargetSuccessUrl(String targetSuccessUrl) {
		this.targetSuccessUrl = targetSuccessUrl;
	}

	/**
	 * @return the targetSuccessUrl
	 */
	public String getTargetSuccessUrl() {
		return targetSuccessUrl;
	}

}
