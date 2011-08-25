/**
 * 
 */
package com.ms.openapps.model.entities.audit;

/**
 * @author hrishi
 *
 */
public interface Auditable {
	
	public AuditInfo getAuditInfo();
	
	public void setAuditInfo(AuditInfo auditInfo);

}
