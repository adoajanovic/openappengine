/**
 * 
 */
package com.openappengine.service;

import java.util.List;

import com.openappengine.model.itemmaster.Item;
import com.openappengine.model.itemmaster.ItemSpecification;

/**
 * @author hrishi
 *
 */
public interface IItemMasterService {
	
	/**
	 * Get Items by {@link ItemSpecification}.
	 * @param itemSpecification
	 * @return
	 */
	public List<Item> fetchItemsForSpecification(ItemSpecification itemSpecification);

}
