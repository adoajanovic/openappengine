/**
 * 
 */
package com.ms.openapps.tests.oxm;

import java.io.FileNotFoundException;
import java.io.InputStream;

import junit.framework.Assert;

import org.junit.Test;

import com.ms.openapps.messages.GenericServiceRequestMessage;
import com.ms.openapps.oxm.OxmMappingException;
import com.ms.openapps.tests.BaseJUnit4Test;

/**
 * @author hrishi
 * 
 */
public class TestOxmLifecycleHandler extends BaseJUnit4Test {

	/**
	 * @throws FileNotFoundException
	 * @throws OxmMappingException
	 */
	@Test
	public void testOxmMarshalling() throws FileNotFoundException,
			OxmMappingException {
		oxmMapper = getOxmMapper();
		InputStream resourceAsStream = getClass().getClassLoader()
				.getResourceAsStream("TestItemMaster.xml");
		Object unmarshalledObj = oxmMapper.unmarshal(resourceAsStream);
		if(unmarshalledObj != null) {
			GenericServiceRequestMessage genericServiceRequestMessage = (GenericServiceRequestMessage) unmarshalledObj;
			System.out.println(genericServiceRequestMessage);
		}
		Assert.assertNotNull("Unmarshalled Object Null..", unmarshalledObj);
	}

}
