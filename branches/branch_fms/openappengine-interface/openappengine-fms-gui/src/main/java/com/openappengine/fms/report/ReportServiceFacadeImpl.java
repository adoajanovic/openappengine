/**
 * 
 */
package com.openappengine.fms.report;

import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author hrishikesh.joshi
 * 
 */
public class ReportServiceFacadeImpl implements ReportServiceFacade {

	@Override
	public byte[] createPdfReport(InputStream is, Collection<?> data, Map params) throws ReportServiceException {
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(data);
		JasperPrint fillReport;
		try {
			fillReport = JasperFillManager.fillReport(is, params,beanColDataSource);
			byte[] bytes = JasperExportManager.exportReportToPdf(fillReport);
			return bytes;
		} catch (JRException e) {
			throw new ReportServiceException("Exception while creating Pdf Report.", e);
		}
	}
	
}
