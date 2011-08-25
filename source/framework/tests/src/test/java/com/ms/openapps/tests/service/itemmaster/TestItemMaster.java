/**
 * 
 */
package com.ms.openapps.tests.service.itemmaster;

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
import com.openappengine.itemmaster.types.CreateItemMasterRequest;

/**
 * @author hrishi
 *
 */
public class TestItemMaster extends BaseJUnit4Test{

	@Test
	public void testSimpleItemMaster() throws OxmMappingException, FileNotFoundException, IOException {
		InputStream resourceAsStream = getClass().getClassLoader()
				.getResourceAsStream("TestItemMasterRequest.xml");
		oxmMapper = getOxmMapper();
		CreateItemMasterRequest createItemMasterObj = (CreateItemMasterRequest) oxmMapper.unmarshal(resourceAsStream);
		Assert.assertNotNull("ItemMasterRequest unmarshalled object null...", createItemMasterObj);
		
		Document marshalObject = oxmMapper.marshalObject(createItemMasterObj);
		
		System.out.println(marshalObject.getDocumentElement());
		
		Document result = ServiceFacade.callXmlService(ServiceNames.SERVICE_CREATE_ITEM_MASTER, marshalObject);
		System.out.println(UtilXml.writeXmlDocument(result));
	}

}
