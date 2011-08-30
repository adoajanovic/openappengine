/**
 * 
 */
package com.ms.openapps.oxm.beans;

import java.util.Date;


/**
 * @author h.shrikant.joshi
 *
 */
public class LeaveRequestPayload extends PayloadData {

	private static final long serialVersionUID = 1L;

	private Date startDate;
	
	private Date endDate;
	
	private Long employeeId;

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
