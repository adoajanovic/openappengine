/**
 * 
 */
package com.openappengine.servicedef.party;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Document;

import com.ms.openapps.util.UtilXml;
import com.openappengine.messages.party.CreatePartyRequest;
import com.openappengine.oxm.IOxmMapper;
import com.openappengine.oxm.OxmMapperContext;
import com.openappengine.oxm.OxmMappingException;
import com.openappengine.servicedef.ServiceNames;
import com.openappengine.serviceengine.facade.ServiceFacade;

/**
 * @author hrishi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/repository-context.xml","/oxmContext.xml","/aggregate-context.xml","/service-engine-context.xml"})
public class TestCreateParty {

	@Test
	public void testCreateParty() throws OxmMappingException, FileNotFoundException, IOException {
		
		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("TestCreatePartyRequest.xml");
		IOxmMapper oxmMapper = OxmMapperContext.getOxmMapper();
		CreatePartyRequest createPartyRequestObj = (CreatePartyRequest) oxmMapper.unmarshal(resourceAsStream);
		Assert.assertNotNull("CreatePartyRequest unmarshalled object null...", createPartyRequestObj);
		
		Document marshalObject = oxmMapper.marshalObject(createPartyRequestObj);
		
		System.out.println(marshalObject.getDocumentElement());
		
		Document result = ServiceFacade.callXmlService(ServiceNames.SERVICE_CREATE_PARTY, marshalObject);
		System.out.println(UtilXml.writeXmlDocument(result));
	}

}
