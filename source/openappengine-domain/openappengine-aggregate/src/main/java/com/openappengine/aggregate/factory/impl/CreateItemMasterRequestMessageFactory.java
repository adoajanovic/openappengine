/**
 * 
 */
package com.openappengine.aggregate.factory.impl;

import org.w3c.dom.Document;

import com.openappengine.factory.FactoryException;
import com.openappengine.factory.XmlMessageFactory;
import com.openappengine.messages.itemmaster.CreateItemMasterRequest;
import com.openappengine.messages.itemmaster.ItemMaster;
import com.openappengine.oxm.IOxmMapper;
import com.openappengine.oxm.OxmMapperContext;
import com.openappengine.oxm.OxmMappingException;

/**
 * @author hrishikesh.joshi
 *
 */
public class CreateItemMasterRequestMessageFactory extends XmlMessageFactory {
	
	/**
	 * Returns CreateItemMasterRequest Xml Document from the given ItemMaster instance.
	 * @param itemMaster
	 * @return Document - CreateItemMasterRequestDocument
	 * @throws FactoryException
	 */
	public Document createItemMasterRequestDocument(ItemMaster itemMaster) throws FactoryException {
		CreateItemMasterRequest createItemMasterRequest = new CreateItemMasterRequest();
		createItemMasterRequest.setItemMaster(itemMaster);
		IOxmMapper oxmMapper = OxmMapperContext.getOxmMapper();
		try {
			return oxmMapper.marshalObject(itemMaster);
		} catch (OxmMappingException e) {
			throw new FactoryException("Request Object cannot be marshalled");
		}
	}

}
