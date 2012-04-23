package com.openappengine.fms.report;

import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

public interface ReportServiceFacade {

	byte[] createPdfReport(InputStream is, Collection<?> data, Map params) throws ReportServiceException;

	byte[] createPdfReport(String jasperTemplate, Object reportBean) throws ReportServiceException;

}
