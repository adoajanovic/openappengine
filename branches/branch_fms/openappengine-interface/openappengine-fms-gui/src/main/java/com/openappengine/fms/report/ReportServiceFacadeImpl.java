/**
 * 
 */
package com.openappengine.fms.report;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.openappengine.fms.interfaces.dto.OrderReportDTO;
import com.openappengine.fms.interfaces.dto.OrderReportDTO.OrderReportLineItem;
import com.openappengine.fms.print.PrintingServiceFacadeImpl;

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
			//JasperExportManager.exportReportToPdfFile(fillReport, "C:\\Users\\hrishi\\Desktop\\Order.pdf");
			byte[] bytes = JasperExportManager.exportReportToPdf(fillReport);
			return bytes;
		} catch (JRException e) {
			throw new ReportServiceException("Exception while creating Pdf Report.", e);
		}
	}

	@Override
	public byte[] createPdfReport(String jasperTemplate, Object reportBean) throws ReportServiceException {
		List reportData = new ArrayList();
		reportData.add(reportBean);
		
		Map params = new HashMap();
		params.put("SUBREPORT_DIR", "report/");
		
		InputStream is = ReportServiceFacadeImpl.class.getClassLoader().getResourceAsStream("report/" + jasperTemplate);
		return createPdfReport(is,reportData,params);
	}
	
	public static void main(String[] args) throws ReportServiceException {
		OrderReportDTO dto = new OrderReportDTO();
		dto.setFromParty("Prathamesh Tours");
		dto.setFromPartyAddress("4, Sharada Estate, Opp. Janakalyan Society, Vazira Naka, Borivali (W), Mumbai.");
		InputStream logoIs = ReportServiceFacadeImpl.class.getClassLoader().getResourceAsStream("app_data/demo_logo.jpg");;
		dto.setFromPartyLogo(logoIs);
		dto.setFromPartyPhone("9869441359");
		dto.setFromPartyWebsite("http://www.prathameshtours.com");
		dto.setOrderDate(new Date());
		dto.setReceiptBookNo("OR00001");
		List<OrderReportLineItem> orderItems = new ArrayList<OrderReportDTO.OrderReportLineItem>();
		
		OrderReportLineItem lineItem = dto.new OrderReportLineItem();
		lineItem.setProductName("Demo Trip");
		lineItem.setQuantity(new BigDecimal(1.0));
		lineItem.setTotal(new BigDecimal(100.0));
		lineItem.setUnitListPrice(new BigDecimal(100.0));
		
		orderItems.add(lineItem);
		dto.setOrderItems(orderItems);
		
		dto.setLineTotalPrice(new BigDecimal(100.0));
		dto.setTotalTax(new BigDecimal(5.0));
		dto.setGrandTotal(new BigDecimal(105.0));
		
		
		InputStream is = ReportServiceFacadeImpl.class.getClassLoader().getResourceAsStream("report/R_Order.jasper");
		List<OrderReportDTO> data = new ArrayList<OrderReportDTO>();
		data.add(dto);
		Map params = new HashMap();
		params.put("SUBREPORT_DIR", "report/");
		byte[] bs = new ReportServiceFacadeImpl().createPdfReport(is, data, params);
		
		new PrintingServiceFacadeImpl().printDocument(bs);
		
	}
}
