/**
 * 
 */
package com.openappengine.repository.entity;

/**
 * @author hrishi
 *
 */
public interface Auditable {
	
	public AuditInfo getAuditInfo();
	
	public void setAuditInfo(AuditInfo auditInfo);

}
