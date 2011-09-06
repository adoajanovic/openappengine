/**
 * 
 */
package com.ms.openapps.report.model;

import java.io.Serializable;

/**
 * @author h.shrikant.joshi
 *
 */
public class SubReport implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String subReportId;

	public String getSubReportId() {
		return subReportId;
	}

	public void setSubReportId(String subReportId) {
		this.subReportId = subReportId;
	}

}
