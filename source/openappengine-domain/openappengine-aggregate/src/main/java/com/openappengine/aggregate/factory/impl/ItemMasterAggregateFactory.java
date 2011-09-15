/**
 *  Item Master Aggregate Factory
 */
package com.openappengine.aggregate.factory.impl;

import java.math.BigDecimal;

import com.openappengine.domain.model.ItItemMaster;
import com.openappengine.factory.GenericAggregateFactory;

/**
 * @author hrishikesh.joshi
 *
 */
public class ItemMasterAggregateFactory extends GenericAggregateFactory {
	
	/**
	 * Create ItItemMaster instance with all the required fields.
	 * @param cost
	 * @param currencyCode
	 * @param description
	 * @param name
	 * @param perishable
	 * @param status
	 * @param type
	 * @param uom
	 * @return {@link ItItemMaster}
	 */
	public ItItemMaster createItemMaster(BigDecimal cost, String currencyCode, String description, String name, boolean perishable, String status, String type, String uom) {
		ItItemMaster itemMaster = new ItItemMaster();
		itemMaster.setCost(cost);
		itemMaster.setCurcode(currencyCode);
		itemMaster.setDesc(description);
		itemMaster.setName(name);
		itemMaster.setPerishable(perishable);
		itemMaster.setStatus(status);
		itemMaster.setType(type);
		itemMaster.setUom(uom);
		return itemMaster;
	}
}
