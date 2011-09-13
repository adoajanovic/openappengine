/**
 * 	A Generic Entity.
 */
package com.openappengine.repository.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.EntityListeners;

/**
 * @author hrishi
 *
 */
@EntityListeners(AuditListener.class)
public abstract class GenericEntity implements Auditable,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Embedded
	private AuditInfo auditInfo = new AuditInfo();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ms.openapps.model.entities.audit.Auditable#getAuditInfo()
	 */
	@Override
	public AuditInfo getAuditInfo() {
		return auditInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ms.openapps.model.entities.audit.Auditable#setAuditInfo(com.ms.openapps
	 * .model.entities.audit.AuditInfo)
	 */
	@Override
	public void setAuditInfo(AuditInfo auditInfo) {
		this.auditInfo = auditInfo;
	}
}