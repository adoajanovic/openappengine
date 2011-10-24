/**
 * 
 */
package com.openappengine.facade.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.openappengine.facade.party.PartyManagerFacade;

/**
 * @author hrishi
 *
 */
public class FacadeContext implements ApplicationContextAware {
	
	private static final String PARTY_MANAGER_FACADE = "partyManagerFacade";
	
	private static ApplicationContext context;

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = applicationContext;
	}

	public static PartyManagerFacade getPartyManagerFacade() {
		return (PartyManagerFacade) context.getBean(PARTY_MANAGER_FACADE);
	}

}
