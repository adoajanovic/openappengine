/**
 * 
 */
package com.ms.openapps.report.factory;

import java.io.Serializable;

import net.sf.jasperreports.engine.JasperReport;

import com.ms.openapps.util.UtilFactory;
import com.ms.openapps.util.factory.GenericFactory;


/**
 * @author hrishi
 *
 */
public class ReportTemplateRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static GenericFactory genericFactory = (GenericFactory) UtilFactory.newGenericFactory();
	
	/**
	 * Add Report template to the Repository.
	 * @param reportId
	 * @param jasperReport
	 */
	public static void addReport(String reportId, JasperReport jasperReport) {
		genericFactory.put(reportId, jasperReport);
	}
	
	/**
	 * Gets the Jasper Report template from the Factory.
	 * @param reportId
	 * @return {@link JasperReport}
	 */
	public static JasperReport getReport(String reportId) { 
		return (JasperReport) genericFactory.get(reportId);
	}

}
