/**
 * 
 */
package com.openappengine.repository.entity;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.log4j.Logger;

/**
 * @author hrishi
 *
 */
public class AuditListener {
	
	private final transient Logger logger = Logger.getLogger(getClass());
	
	@PrePersist
	public void setAddedAuditInfo(Auditable model) {
		Date now = new Date();//.nowDate();
		String loggedUserName = "";//LoggedUserNameContext.get();
		model.getAuditInfo().setDtAdded(now);
		model.getAuditInfo().setDtLastModif(now);
		model.getAuditInfo().setAddedBy(loggedUserName);
		model.getAuditInfo().setLastModifBy(loggedUserName);
		logger.info("Set DtAddedBy =" + now);
		logger.info("Set AddedBy =" + loggedUserName);
	}
	
	@PreUpdate
	public void setUpdateAuditInfo(Auditable model) {
		Date now = new Date();
		String loggedUserName = "";//LoggedUserNameContext.get();
		model.getAuditInfo().setDtLastModif(now);
		model.getAuditInfo().setLastModifBy(loggedUserName);
		logger.info("Set LastModifBy =" + loggedUserName);
		logger.info("Set DtLastModif =" + now);
	}
	
}
