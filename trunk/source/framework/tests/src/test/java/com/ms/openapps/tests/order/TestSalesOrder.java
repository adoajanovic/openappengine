/**
 * 
 */
package com.ms.openapps.tests.order;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;

import com.ms.openapps.oxm.OxmMappingException;
import com.ms.openapps.service.constants.ServiceNames;
import com.ms.openapps.service.facade.ServiceFacade;
import com.ms.openapps.tests.BaseJUnit4Test;
import com.ms.openapps.util.UtilXml;
import com.openappengine.salesorder.types.CreateSalesOrderRequest;

/**
 * @author hrishi
 *
 */
public class TestSalesOrder extends BaseJUnit4Test{

	@Test
	public void testSimpleCreateSalesOrder() throws OxmMappingException, FileNotFoundException, IOException {
		InputStream resourceAsStream = getClass().getClassLoader()
				.getResourceAsStream("TestCreateSalesOrderRequest.xml");
		oxmMapper = getOxmMapper();
		CreateSalesOrderRequest createSalesOrderObj = (CreateSalesOrderRequest) oxmMapper.unmarshal(resourceAsStream);
		Assert.assertNotNull("CreateSalesOrderRequest unmarshalled object null...", createSalesOrderObj);
		
		Document marshalObject = oxmMapper.marshalObject(createSalesOrderObj);
		
		System.out.println(marshalObject.getDocumentElement());
		
		Document result = ServiceFacade.callXmlService(ServiceNames.SERVICE_CREATE_SALES_ORDER, marshalObject);
		System.out.println(UtilXml.writeXmlDocument(result));
	}

}
