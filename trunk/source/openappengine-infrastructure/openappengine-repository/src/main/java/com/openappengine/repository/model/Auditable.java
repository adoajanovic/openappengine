/**
 * 
 */
package com.openappengine.repository.model;

/**
 * @author hrishi
 *
 */
public interface Auditable {
	
	public AuditInfo getAuditInfo();
	
	public void setAuditInfo(AuditInfo auditInfo);

}
