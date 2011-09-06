/**
 * 
 */
package com.ms.openapps.report.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author hrishi
 *
 */
public class Report implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String reportId;
	
	private List<SubReport> subreports;

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public List<SubReport> getSubreports() {
		return subreports;
	}

	public void setSubreports(List<SubReport> subreports) {
		this.subreports = subreports;
	}
	
}
